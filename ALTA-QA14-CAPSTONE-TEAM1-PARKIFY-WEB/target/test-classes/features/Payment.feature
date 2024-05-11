@Payment
Feature:
  As a User I want to book car parking place successfully
  Background: Already login
    Given User open the web parkify
    When User input "altaproject@gmail.com" as email and "altaproject" as password and click login
    Then User already on dashboard page

  Scenario:
    And User click barcode in dashboard page
    And User will directed to barcode page
    And User click exit park button
    And User select payment "VA BCA"
  #And User click confirm button
  #And User will go to detail payment

