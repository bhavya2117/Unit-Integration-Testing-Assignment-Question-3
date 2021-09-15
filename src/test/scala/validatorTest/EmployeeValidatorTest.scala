package validatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
class EmployeeValidatorTest extends AnyFunSuite{

  val FirstEmployeeSherlock = Employee("Sherlock", "Watson", 32,50000, "Software Consultant", "Knoldus", "johnlee123@gmail.com" )
  val SecondEmployeeJohn = Employee("John", "Leo", 26,30000, "Software Trainee", "Philips", "morsiongill@gmail.com" )
  val ThirdEmployeeKing = Employee("King", "Albert", 43,65000, "Sr. Software Engineer", "CTS", "katyperry43@gmail.com" )
  val FourthEmployeeThomas = Employee("Thomas", "Edison", 22,25000, "Software Consultant", "Knoldus", "brownstrowman21?@gmail.com" )


  test("Checking if Employee- FirstEmployeeSherlock working in Knoldus(company present in Database) is a valid Employee"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(FirstEmployeeSherlock)
    assert(expectResult == result)
  }


  test("Checking if Employee- SecondEmployeeJohn working in Philips(company present in Database) is a valid Employee"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(SecondEmployeeJohn)
    assert(expectResult == result)
  }


  test("Checking if Employee- ThirdEmployeeKing working in company CTS(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(ThirdEmployeeKing)
    assert(expectResult == result)
  }

  test("Checking if Employee- FourthEmployeeThomas working in Knoldus(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(FourthEmployeeThomas)
    assert(expectResult == result)
  }

}
