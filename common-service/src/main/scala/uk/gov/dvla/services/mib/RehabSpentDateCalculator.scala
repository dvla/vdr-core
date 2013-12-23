package uk.gov.dvla.services.mib

import uk.gov.dvla.domain.{Driver, Endorsement}
import org.joda.time._
import java.util.Date
import collection.JavaConversions._

object RehabSpentDateCalculator {
  val P5Y = new Period("P5Y")
  val P7Y = new Period("P7Y")
  val P18Y = new Period("P18Y")
  val Never = DateTime.parse("3000-01-01")

  trait RehabPeriod
  case object Indefinite extends RehabPeriod
  case class UntilDisqualified(date: DateTime) extends RehabPeriod
  case class StandardPeriod(period: Period) extends RehabPeriod

  def apply(driver: Driver, endorsement: Endorsement): Date = {
    (Option(endorsement.getConviction) orElse Option(endorsement.getOffence))
      .map(new DateTime(_))
      .map { startDate =>

        val disq = Option(driver.getDisqualifications) flatMap {
          _ find (_.getEndorsementID == endorsement.getId)
        }
    
        def lifetimeDisq(rehab: RehabPeriod): RehabPeriod =
          disq filter (d => d.getForLife != null && d.getForLife) map (_ => Indefinite) getOrElse rehab
    
        def custodialPeriod(rehab: RehabPeriod): RehabPeriod  = endorsement.getCustodialPeriod match {
          case "3" => Indefinite
          case "2" => StandardPeriod(P7Y)
          case _ => rehab
        }

        def minor(rehab: RehabPeriod): RehabPeriod = {
          val bDay = new DateTime(driver.getBirthDetails.getDate)
          val age = new Duration(bDay, startDate)
          val wasMinor = age.compareTo(P18Y.toDurationFrom(bDay)) < 0

          (wasMinor, rehab) match {
            case (true, StandardPeriod(p)) => StandardPeriod(halvePeriod(p))
            case _ => rehab
          }
        }

        def longerDisq(rehab: RehabPeriod): RehabPeriod =
          (rehab, disq map (d => new DateTime(d.getDisqToDate))) match {
            case (StandardPeriod(p), Some(disqTo)) if startDate.plus(p).isBefore(disqTo) =>
              UntilDisqualified(disqTo.plusDays(1))
            case _ => rehab
          }

        val defaultPeriod = StandardPeriod(P5Y)
        val rules = custodialPeriod _ andThen lifetimeDisq andThen minor andThen longerDisq
        (rules(defaultPeriod) match {
          case StandardPeriod(p) => startDate.plus(p)
          case UntilDisqualified(d) => d
          case Indefinite => Never
        }).toDate
      } getOrElse null
  }

  def halvePeriod(period: Period) = {
    require(period.withYears(0).withMonths(0) == Period.ZERO,
      "Handling periods of granularity less than a month is not implemented")
    val (yh, yc) = (period.getYears / 2, period.getYears % 2)
    val (mh, mc) = (period.getMonths / 2, period.getMonths % 2)
    Period.years(yh).withMonths(mh + 6 * yc + mc)
  }
}
