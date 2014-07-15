package uk.gov.dvla.services.utils

import java.util.{List => JList}
import scala.collection.JavaConversions._

object J2S {
  def list[T](xs: JList[T]): List[T] = Option(xs).map(_.toList).getOrElse(Nil)

  def emptyList[T]: List[T] = Nil
}
