package uk.gov.dvla.services.utils

import java.util.{List => JList}
import scala.collection.JavaConversions._

object J2S {
  def list[T](xs: JList[T]): List[T] = xs.toList
  def emptyList[T]: List[T] = Nil
}
