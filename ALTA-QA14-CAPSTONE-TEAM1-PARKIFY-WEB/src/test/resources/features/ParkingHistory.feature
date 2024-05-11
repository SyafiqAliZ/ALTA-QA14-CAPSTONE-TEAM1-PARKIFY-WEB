@ParkingHistory
Feature: Parking History

  Scenario:
  As a user i want to see parking history

    Given User open the web parkify
    When User input "altaproject@gmail.com" as email and "altaproject" as password and click login
    Then User already on dashboard page
    And User click parking history card
    And User already on parking history page
     # And user click parking booked
     # Then User will see some parking history information

