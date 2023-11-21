Feature: Search for specific line details and schedule

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: Use the searchbar by line number
    Given searchbar is available
    When I enter the line name
    And I select the desired line name
    Then I get the line details and schedule