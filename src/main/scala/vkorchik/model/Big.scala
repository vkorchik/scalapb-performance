package vkorchik.model

case class Small(id: Int, name: Option[String], exists: Option[Boolean])
case class Medium(id: Int, name: Option[String], exists: Option[Boolean], small: Seq[Small])
case class Big(
                id: Int,
                name: Option[String],
                exists: Option[Boolean],
                small: Seq[Small],
                medium: Seq[Medium]
              )


case class Huge(
                 id: Int,
                 name: Option[String],
                 exists: Option[Boolean],
                 small: Seq[Small],
                 medium: Seq[Medium],
                 big: Seq[Big],
                 field1: Option[String],
                 field2: Option[String],
                 field3: Option[String],
                 field4: Option[String],
                 field5: Option[String],
                 field6: Option[String],
                 field7: Option[String],
                 field8: Option[String],
                 field9: Option[String],
                 field10: Option[String]
               )

case class Enormous(
                     id: Int,
                     name: Option[String],
                     exists: Option[Boolean],
                     small: Seq[Small],
                     medium: Seq[Medium],
                     big: Seq[Big],
                     huge: Seq[Huge],
                     longs: Seq[Long],
                     field1: Option[String],
                     field2: Option[String],
                     field3: Option[String],
                     field4: Option[String],
                     field5: Option[String],
                     field6: Option[String],
                     field7: Option[String],
                     field8: Option[String],
                     field9: Option[String],
                     field10: Option[String],
                     field11: Option[String],
                     field12: Option[String],
                     field13: Option[String],
                     field14: Option[String],
                     field15: Option[String],
                     field16: Option[String],
                     field17: Option[String],
                     field18: Option[String],
                     field19: Option[String],
                     field20: Option[String],
                     hugeExt1: Option[Huge],
                     hugeExt2: Option[Huge]
                   )
