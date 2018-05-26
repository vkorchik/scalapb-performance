package vkorchik.converter

import vkorchik.model.Enormous

trait Converter {
  def parseFrom(array: Array[Byte]): Enormous
  def toByteArray(big: Enormous): Array[Byte]
}
