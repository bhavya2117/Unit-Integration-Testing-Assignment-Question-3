package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db._

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {

    val DB_obj = new CompanyReadDto
    val CompanyIsExist = DB_obj.getCompanyByName(company.Name)

    val emailIsExist = new EmailValidator
    val EmailCheck = emailIsExist.emailIdIsValid(company.EmailId)
    if (EmailCheck && CompanyIsExist == None)
      return true
    false

  }
}
