package vkorchik

import vkorchik.model._

object Data {

  val small = Small(123, Some("name"), Some(true))

  val medium = Medium(123, Some("name"), Some(true), Seq.fill(10)(small))

  val big = Big(123, Some("name"), Some(true), Seq.fill(10)(small), Seq.fill(10)(medium))

  val huge = Huge(123, Some("name"), Some(true),
    Seq.fill(10)(small), Seq.fill(10)(medium), Seq.fill(10)(big),
    Some("1"), Some("2"), Some("3"),
    Some("4"), Some("5"), Some("6"),
    Some("7"), Some("8"), Some("9"),
    Some("10")
  )

  val enormous = Enormous(123, Some("name"), Some(true),
    Seq.fill(10)(small), Seq.fill(10)(medium), Seq.fill(10)(big), Seq.fill(10)(huge),
    Seq.fill(100)(123L),
    Some("1"), Some("2"), Some("3"),
    Some("4"), Some("5"), Some("6"),
    Some("7"), Some("8"), Some("9"),
    Some("10"), Some("11"), Some("12"),
    Some("13"), Some("14"), Some("15"),
    Some("16"), Some("17"), Some("18"),
    Some("19"), Some("20"),
    Some(huge), Some(huge)
  )
}
