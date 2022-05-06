Feature: Basic syntax

  Scenario: This is Scenario 1
    Given user is on TS homepage
    When user clicks on the About us button
    Then user is redirected to About us page
    And Close the browser