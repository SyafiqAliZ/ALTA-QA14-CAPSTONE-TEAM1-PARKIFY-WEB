@Delete
Feature: Delete Operator and User account successfully
  I can delete account succesfully

  @TCDel-1
  Scenario: Delete user account
    Given User open the web parkify
    When User input "jodideleteuser@gmail.com" as email and "jodigantengbanget" as password and click login
    Then User already on dashboard page
    And User click profile button
    Then User redirected to profile page
    And click delete account button
    Then message will be show "Are you absolutely sure?"
    Then user click continue
    Then user will see message "berhasil menghapus akun"

  @TCdel-2
  Scenario: Delete user account
    Given User open the web parkify
    When User input "jodideleteoperator@gmail.com" as email and "jodigantengbanget" as password and click login
    Then User already on dashboard page
    And User click profile button
    Then User redirected to profile page
    And click delete account button
    Then message will be show "Are you absolutely sure?"
    Then user click continue
    Then user will see message "berhasil menghapus akun"