Feature: As a customer
  I want to see the my car's information on DVLA website
  So that i can verify the details

  @dvla
  Scenario: Verify all the cars details from csv file
    Given I visit DVLA vehicle information page
    When I check the vehicles information provided in the csv file
    Then I should see the vehicle details mentioned in the csv file