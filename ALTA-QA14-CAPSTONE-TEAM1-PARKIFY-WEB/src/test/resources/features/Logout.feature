@Logout
Feature: Logout as Operator and User
  I can logout succesfully

  @TC1
  Scenario: Logout successfully as user
    Given User open the web parkify
    When User input "jodigantengUSR@gmail.com" as email and "jodigantengbanget" as password and click login
    Then User already on dashboard page
    And User click profile button
    Then User redirected to profile page
    And User click logout button
    Then User redirected to login page
    Then User see "Logout successfully" as message

  @TC2
  Scenario: Logout successfully as operator
    Given User open the web parkify
    When User input "jodigantengOP@gmail.com" as email and "jodigantengbanget" as password and click login
    Then User already on dashboard page
    And User click profile button
    Then User redirected to profile page
    And User click logout button
    Then User redirected to login page
    Then User see "Logout successfully" as message