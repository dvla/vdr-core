package main.scala.uk.gov.dvla.core.domain

import org.joda.time.DateTime

case class Address(buildingName: String, ddtfare: String, postTown: String, postCode: String)

case class Name(title: String, givenName: List[String], familyName: String)

case class Licence(validFrom: DateTime, validTo: DateTime,
                   entitlements: List[Entitlement] = List[Entitlement](),
                   endorsements: List[Endorsement] = List[Endorsement]())

case class Entitlement(code: String, validFrom: DateTime, validTo: DateTime, provisional: Boolean,
                       priorTo: Boolean, stated: Boolean, infoCodes: List[String] = List[String]())

case class Endorsement(disqual: Boolean, code: String, court: String, offDate: DateTime,
                       expDate: DateTime, removed: DateTime, conviction: Option[DateTime], sentencing: Option[DateTime],
                       period: Option[String], fine: Option[Number], noPoints: Option[Int])

case class Driver(dln: String, dob: DateTime, name: Name, licence: List[Licence], gender: Int, address: Address,
                  recordType: Option[String], stopMarker: List[Int] = List[Int](), restrictionKey: List[Int] = List[Int]())
