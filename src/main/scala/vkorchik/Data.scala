package vkorchik

import vkorchik.Protos._

import scala.collection.JavaConverters._

object Data {

  object Scala {
    val small = protos.Small(123, Some("name"), Some(true))

    val medium = protos.Medium(123, Some("name"), Some(true), Seq.fill(10)(small))

    val big = protos.Big(
      id = 123,
      name = Some("name"),
      exists = Some(true),
      small = Seq.fill(10)(small),
      medium = Seq.fill(10)(medium),
    )

    val huge = protos.Huge(
      id = 123,
      name = Some("name"),
      exists = Some(true),
      small = Seq.fill(10)(small),
      medium = Seq.fill(10)(medium),
      big = Seq.fill(10)(big),
      field1 = Some("1"),
      field2 = Some("2"),
      field3 = Some("3"),
      field4 = Some("4"),
      field5 = Some("5"),
      field6 = Some("6"),
      field7 = Some("7"),
      field8 = Some("8"),
      field9 = Some("9"),
      field10 = Some("10")
    )

    val enormous = protos.Enormous(
      id = 123,
      name = Some("name"),
      exists = Some(true),
      small = Seq.fill(10)(small),
      medium = Seq.fill(10)(medium),
      big = Seq.fill(10)(big),
      huge = Seq.fill(10)(huge),
      longs = Seq.fill(100)(123L),
      field1 = Some("1"),
      field2 = Some("2"),
      field3 = Some("3"),
      field4 = Some("4"),
      field5 = Some("5"),
      field6 = Some("6"),
      field7 = Some("7"),
      field8 = Some("8"),
      field9 = Some("9"),
      field10 = Some("10"),
      field11 = Some("11"),
      field12 = Some("12"),
      field13 = Some("13"),
      field14 = Some("14"),
      field15 = Some("15"),
      field16 = Some("16"),
      field17 = Some("17"),
      field18 = Some("18"),
      field19 = Some("19"),
      field20 = Some("20"),
      hugeExt1 = Some(huge),
      hugeExt2 = Some(huge)
    )
  }

  object Java {

    val small =
      Small.newBuilder()
        .setId(123)
        .setName("name")
        .setExists(true)
        .buildPartial()


    val medium =
      Medium.newBuilder()
        .setId(123)
        .setName("name")
        .setExists(true)
        .addAllSmall(List.fill(10)(small).asJava)
        .buildPartial()


    val big =
      Big.newBuilder()
        .setId(123)
        .setName("name")
        .setExists(true)
        .addAllSmall(List.fill(10)(small).asJava)
        .addAllMedium(List.fill(10)(medium).asJava)
        .buildPartial()

    val huge =
      Huge.newBuilder()
        .setId(123)
        .setName("name")
        .setExists(true)
        .addAllSmall(List.fill(10)(small).asJava)
        .addAllMedium(List.fill(10)(medium).asJava)
        .addAllBig(List.fill(10)(big).asJava)
        .setField1("1")
        .setField2("2")
        .setField3("3")
        .setField4("4")
        .setField5("5")
        .setField6("6")
        .setField7("7")
        .setField8("8")
        .setField9("9")
        .setField10("10")
        .buildPartial()

    val enormous =
      Enormous.newBuilder()
        .setId(123)
        .setName("name")
        .setExists(true)
        .addAllSmall(List.fill(10)(small).asJava)
        .addAllMedium(List.fill(10)(medium).asJava)
        .addAllBig(List.fill(10)(big).asJava)
        .addAllHuge(List.fill(10)(huge).asJava)
        .addAllLongs(List.fill(100)(long2Long(123L)).asJava)
        .setField1("1")
        .setField2("2")
        .setField3("3")
        .setField4("4")
        .setField5("5")
        .setField6("6")
        .setField7("7")
        .setField8("8")
        .setField9("9")
        .setField10("10")
        .setField11("11")
        .setField12("12")
        .setField13("13")
        .setField14("14")
        .setField15("15")
        .setField16("16")
        .setField17("17")
        .setField18("18")
        .setField19("19")
        .setField20("20")
        .setHugeExt1(huge)
        .setHugeExt2(huge)
        .buildPartial()
  }

}
