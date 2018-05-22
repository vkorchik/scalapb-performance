package vkorchik

import vkorchik.Protos.{Big, Huge, Medium, Small}

import scala.collection.JavaConverters._

object Data {

  object scala {
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
  }

  object java {

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
  }

}
