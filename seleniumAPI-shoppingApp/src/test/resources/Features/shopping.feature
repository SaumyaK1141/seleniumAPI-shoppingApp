Feature: Shopping website automation

 Scenario: Complete product purchase
    Given I login to the shopping website
    When I add a few products to the cart
    And I proceed to checkout
    Then I can checkout successfully

