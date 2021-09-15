package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  val KnoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val PhilipsCompany: Company = Company("Philips", "philips@gmail.com", "Noida")
  val Companies: HashMap[String, Company] = HashMap("Knoldus" -> KnoldusCompany, "Philips" -> PhilipsCompany)

  def getCompanyByName(name: String): Option[Company] = Companies.get(name)

}
