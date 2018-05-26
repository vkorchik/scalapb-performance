package vkorchik.converter

import vkorchik.model._

object ScalaConverter extends Converter {

  private def smallFrom(s: vkorchik.protos.Small): Small = Small(s.id, s.name, s.exists)

  private def smallFrom(s: Small): vkorchik.protos.Small = vkorchik.protos.Small(s.id, s.name, s.exists)

  private def mediumFrom(m: vkorchik.protos.Medium): Medium = Medium(m.id, m.name, m.exists, m.small.map(smallFrom))

  private def mediumFrom(m: Medium): vkorchik.protos.Medium = vkorchik.protos.Medium(m.id, m.name, m.exists, m.small.map(smallFrom))

  private def bigFrom(m: vkorchik.protos.Big): Big =
    Big(m.id, m.name, m.exists, m.small.map(smallFrom), m.medium.map(mediumFrom))

  private def bigFrom(m: Big): vkorchik.protos.Big =
    vkorchik.protos.Big(m.id, m.name, m.exists, m.small.map(smallFrom), m.medium.map(mediumFrom))

  private def hugeFrom(m: vkorchik.protos.Huge): Huge =
    Huge(m.id, m.name, m.exists,
      m.small.map(smallFrom), m.medium.map(mediumFrom), m.big.map(bigFrom),
      m.field1, m.field2, m.field3,
      m.field4, m.field5, m.field6,
      m.field7, m.field8, m.field9,
      m.field10
    )

  private def hugeFrom(m: Huge): vkorchik.protos.Huge =
    vkorchik.protos.Huge(m.id, m.name, m.exists,
      m.small.map(smallFrom), m.medium.map(mediumFrom), m.big.map(bigFrom),
      m.field1, m.field2, m.field3,
      m.field4, m.field5, m.field6,
      m.field7, m.field8, m.field9,
      m.field10
    )

  def enormousToPb(m: Enormous): vkorchik.protos.Enormous = {
    vkorchik.protos.Enormous(
      m.id,
      m.name,
      m.exists,
      m.small.map(smallFrom), m.medium.map(mediumFrom), m.big.map(bigFrom),
      m.huge.map(hugeFrom),
      m.longs,
      m.field1, m.field2, m.field3,
      m.field4, m.field5, m.field6,
      m.field7, m.field8, m.field9,
      m.field10,
      m.field11, m.field12, m.field13,
      m.field14, m.field15, m.field16,
      m.field17, m.field18, m.field19,
      m.field20,
      m.hugeExt1.map(hugeFrom), m.hugeExt2.map(hugeFrom)
    )
  }

  def enormousFromPb(m: vkorchik.protos.Enormous): Enormous = {
    Enormous(
      m.id,
      m.name,
      m.exists,
      m.small.map(smallFrom), m.medium.map(mediumFrom), m.big.map(bigFrom),
      m.huge.map(hugeFrom),
      m.longs,
      m.field1, m.field2, m.field3,
      m.field4, m.field5, m.field6,
      m.field7, m.field8, m.field9,
      m.field10,
      m.field11, m.field12, m.field13,
      m.field14, m.field15, m.field16,
      m.field17, m.field18, m.field19,
      m.field20,
      m.hugeExt1.map(hugeFrom), m.hugeExt2.map(hugeFrom)
    )
  }

  override def parseFrom(array: Array[Byte]) = {
    val b = vkorchik.protos.Enormous.parseFrom(array)
    enormousFromPb(b)
  }

  override def toByteArray(e: Enormous) = {
    enormousToPb(e).toByteArray
  }
}
