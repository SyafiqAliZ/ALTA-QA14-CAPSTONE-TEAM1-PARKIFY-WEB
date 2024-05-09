@Register
Feature: Register successfully as  User or Operator
  I can register as user or operator with valid credential

@TCRE-1
Scenario Outline: Register with valid credential
  Given User open the web parkify
  When User click sign up button
  Then User redirected to register page
  Then User choose "<accountType>"
  And User input "<fullName>" as full name "<email>" as email and "<password>" as password and click sign up
  Then User redirected to login page
  And User will see "selamat data sudah terdaftar" as pop up message

  Examples:
    | accountType | fullName         | email                 | password   |
    | Operator    | operator parkify | parkifyOP03@gmail.com | passwordop |
    | User        | user parkify     | parkifyUS03@gmail.com | passwordus |

@TCRE-2
Scenario Outline: Register with invalid credential
  Given User open the web parkify
  When User click sign up button
  Then User redirected to register page
  Then User choose "<accountType>"
  And User input "<fullName>" as full name "<email>" as email and "<password>" as password and click sign up
  Then User see "<errorMessage>" as error message
  Examples:
    | accountType | fullName         | email                 | password   | errorMessage         |
    | Operator    | operator parkify | parkifyOP04@gmai      | passwordop | Not a valid email    |
    | Operator    | operator parkify |                       | passwordop | Email is required    |
    | User        |                  | parkifyUS09@gmail.com | passwordus | Name is required     |
    | User        | user parkify     | parkifyUS08@gmail.com | 1234567    | Password is required |

