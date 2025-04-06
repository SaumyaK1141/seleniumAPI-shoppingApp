Feature: Mobile API Testing

  Scenario: Validate the Mobile API response
    Given I have a mobile API
    When I validate the response
    Then the status code should be 200
    And the name of the object with ID "6" should be "Apple AirPods"