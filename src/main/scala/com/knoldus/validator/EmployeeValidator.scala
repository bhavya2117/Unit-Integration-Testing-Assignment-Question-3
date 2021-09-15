package com.knoldus.validator

import com.knoldus.models.Employee
import com.knoldus.db.CompanyReadDto

class EmployeeValidator {

  def employeeIsValid(employee: Employee): Boolean = {

    val DB_Obj = new CompanyReadDto
    val CompanyName = DB_Obj.getCompanyByName(employee.CompanyName)
    val ValidateEmailId_Obj = new EmailValidator
    val emailIsExist = ValidateEmailId_Obj.emailIdIsValid(employee.EmailId)
    if(emailIsExist && CompanyName != None)
      return true
    false
  }
}
