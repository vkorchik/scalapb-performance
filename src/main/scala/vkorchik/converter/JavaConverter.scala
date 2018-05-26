package vkorchik.converter

import vkorchik.model._

import scala.collection.JavaConverters._

object JavaConverter extends Converter {

  private def smallFrom(s: vkorchik.Protos.Small): Small = Small(s.getId, Some(s.getName), Some(s.getExists))

  private def smallFrom(a: Small): vkorchik.Protos.Small =
    vkorchik.Protos.Small.newBuilder()
      .setId(a.id)
      .setName(a.name.get)
      .setExists(a.exists.get)
      .buildPartial()

  private def mediumFrom(m: vkorchik.Protos.Medium): Medium =
    Medium(m.getId, Some(m.getName), Some(m.getExists), m.getSmallList.asScala.map(smallFrom))

  private def mediumFrom(a: Medium): vkorchik.Protos.Medium =
    vkorchik.Protos.Medium.newBuilder()
      .setId(a.id)
      .setName(a.name.get)
      .setExists(a.exists.get)
      .addAllSmall(a.small.map(smallFrom).asJava)
      .buildPartial()

  private def bigFrom(m: vkorchik.Protos.Big): Big =
    Big(m.getId, Some(m.getName), Some(m.getExists),
      m.getSmallList.asScala.map(smallFrom),
      m.getMediumList.asScala.map(mediumFrom)
    )

  private def bigFrom(a: Big): vkorchik.Protos.Big =
    vkorchik.Protos.Big.newBuilder()
      .setId(a.id)
      .setName(a.name.get)
      .setExists(a.exists.get)
      .addAllSmall(a.small.map(smallFrom).asJava)
      .addAllMedium(a.medium.map(mediumFrom).asJava)
      .buildPartial()

  private def hugeFrom(m: vkorchik.Protos.Huge): Huge =
    Huge(m.getId, Some(m.getName), Some(m.getExists),
      m.getSmallList.asScala.map(smallFrom),
      m.getMediumList.asScala.map(mediumFrom),
      m.getBigList.asScala.map(bigFrom),
      Some(m.getField1),
      Some(m.getField2),
      Some(m.getField3),
      Some(m.getField4),
      Some(m.getField5),
      Some(m.getField6),
      Some(m.getField7),
      Some(m.getField8),
      Some(m.getField9),
      Some(m.getField10)
    )

  private def hugeFrom(a: Huge): vkorchik.Protos.Huge =
    vkorchik.Protos.Huge.newBuilder()
      .setId(a.id)
      .setName(a.name.get)
      .setExists(a.exists.get)
      .addAllSmall(a.small.map(smallFrom).asJava)
      .addAllMedium(a.medium.map(mediumFrom).asJava)
      .addAllBig(a.big.map(bigFrom).asJava)
      .setField1(a.field1.get)
      .setField2(a.field2.get)
      .setField3(a.field3.get)
      .setField4(a.field4.get)
      .setField5(a.field5.get)
      .setField6(a.field6.get)
      .setField7(a.field7.get)
      .setField8(a.field8.get)
      .setField9(a.field9.get)
      .setField10(a.field10.get)
      .buildPartial()

  def enormousToPb(a: Enormous): vkorchik.Protos.Enormous = {
    vkorchik.Protos.Enormous.newBuilder()
      .setId(a.id)
      .setName(a.name.get)
      .setExists(a.exists.get)
      .addAllSmall(a.small.map(smallFrom).asJava)
      .addAllMedium(a.medium.map(mediumFrom).asJava)
      .addAllBig(a.big.map(bigFrom).asJava)
      .addAllHuge(a.huge.map(hugeFrom).asJava)
      .addAllLongs(a.longs.map(long2Long).asJava)
      .setField1(a.field1.get)
      .setField2(a.field2.get)
      .setField3(a.field3.get)
      .setField4(a.field4.get)
      .setField5(a.field5.get)
      .setField6(a.field6.get)
      .setField7(a.field7.get)
      .setField8(a.field8.get)
      .setField9(a.field9.get)
      .setField10(a.field10.get)
      .setField11(a.field11.get)
      .setField12(a.field12.get)
      .setField13(a.field13.get)
      .setField14(a.field14.get)
      .setField15(a.field15.get)
      .setField16(a.field16.get)
      .setField17(a.field17.get)
      .setField18(a.field18.get)
      .setField19(a.field19.get)
      .setField20(a.field20.get)
      .setHugeExt1(a.hugeExt1.map(hugeFrom).get)
      .setHugeExt2(a.hugeExt2.map(hugeFrom).get)
      .buildPartial()

  }

  def enormousFromPb(m: vkorchik.Protos.Enormous): Enormous = {
    Enormous(m.getId, Some(m.getName), Some(m.getExists),
      m.getSmallList.asScala.map(smallFrom),
      m.getMediumList.asScala.map(mediumFrom),
      m.getBigList.asScala.map(bigFrom),
      m.getHugeList.asScala.map(hugeFrom),
      m.getLongsList.asScala.map(Long2long),
      Some(m.getField1),
      Some(m.getField2),
      Some(m.getField3),
      Some(m.getField4),
      Some(m.getField5),
      Some(m.getField6),
      Some(m.getField7),
      Some(m.getField8),
      Some(m.getField9),
      Some(m.getField10),
      Some(m.getField11),
      Some(m.getField12),
      Some(m.getField13),
      Some(m.getField14),
      Some(m.getField15),
      Some(m.getField16),
      Some(m.getField17),
      Some(m.getField18),
      Some(m.getField19),
      Some(m.getField20),
      Some(m.getHugeExt1).map(hugeFrom),
      Some(m.getHugeExt2).map(hugeFrom)
    )
  }

  override def parseFrom(array: Array[Byte]): Enormous = {
    val b = vkorchik.Protos.Enormous.parseFrom(array)
    enormousFromPb(b)
  }

  override def toByteArray(b: Enormous): Array[Byte] = {
    enormousToPb(b).toByteArray
  }
}
