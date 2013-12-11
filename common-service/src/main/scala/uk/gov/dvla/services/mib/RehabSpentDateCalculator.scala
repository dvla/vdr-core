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

  def apply(driver: Driver, endorsement: Endorsement): Date = {
    (Option(endorsement.getConviction) orElse Option(endorsement.getOffence))
      .map(new DateTime(_))
      .map { startDate =>

        val defaultSpentDate = startDate plus P5Y
        val disq = driver.getDisqualifications find (_.getEndorsementID == endorsement.getId)

        def disqLongerThan5Y(spentDate: DateTime) =
          (for {
            dq <- disq
            from <- Option(dq.getDisqFromDate) map (new DateTime(_))
            to <- Option(dq.getDisqToDate) map (new DateTime(_))
            isLonger = new Duration(from, to).compareTo(P5Y.toDurationFrom(from)) > 0
            spent = to if isLonger
          } yield spent) getOrElse spentDate
    
        def lifetimeDisq(spentDate: DateTime) =
          disq filter (_.getForLife) map (_ => Never) getOrElse spentDate
    
        def custodialPeriod(spentDate: DateTime) = endorsement.getCustodialPeriod match {
          case "3" => Never
          case "2" =>
            if (new Duration(startDate, spentDate).compareTo(P7Y.toDurationFrom(startDate)) > 1)
              spentDate
            else
              startDate plus P7Y
          case _ => spentDate
        }

        def minor(spentDate: DateTime) = {
          val bDay = new DateTime(driver.getBirthDetails.getDate)
          val age = new Duration(bDay, startDate)
          val isAdult = age.compareTo(P18Y.toDurationFrom(bDay)) >= 0

          if (isAdult)
            spentDate
          else {
            val normalDuration = new Duration(startDate, spentDate)
            val halvedDuration = Duration.millis(normalDuration.getMillis / 2)
            startDate plus halvedDuration
          }
        }

        val rules = (disqLongerThan5Y _) andThen lifetimeDisq andThen custodialPeriod andThen minor
        rules(defaultSpentDate).toDate
      } getOrElse null
  }
}
