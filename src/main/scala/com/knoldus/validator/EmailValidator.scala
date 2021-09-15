package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {

    if (checkAtTheRate(emailId) && checkRecipient(emailId) && checkDomainName(emailId) && checkTopLevelDomain(emailId))
     return true

    false

}
  def checkRecipient(emailID: String): Boolean = {

    for (i <- 0 until (emailID.length)) {

      val characterAtIndex: Char = emailID.charAt(i)
      if (characterAtIndex == '@')
        return true
      if (!characterAtIndex.isDigit && !characterAtIndex.isLetter)
        return false
    }
    false
  }
  def checkAtTheRate (emailId: String): Boolean = {
    for (i <- 0 until emailId.length)
      if (emailId.charAt (i) == '@')
        return true
    false
  }

  def checkDomainName (emailId: String): Boolean = {

    if (! checkAtTheRate (emailId) ) return false
    var index = emailId.indexOf ("@") + 1
    while (emailId.charAt (index) != '.') {
      if (! Character.isLetterOrDigit (emailId.charAt (index) ) ) return false
      index = index + 1
    }
    true
  }

  def checkTopLevelDomain (emailId: String): Boolean = {

    if (! checkAtTheRate (emailId) ) return false
    val index = emailId.indexOf (".")
    val checkTopLevelDomain = emailId.substring (index)
    if (checkTopLevelDomain.equals (".com") || checkTopLevelDomain.equals (".net") || checkTopLevelDomain.equals (".org") || checkTopLevelDomain.equals (".co.in"))
      return true
    false

  }
  }
