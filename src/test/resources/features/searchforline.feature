Feature: Search for specific line details and schedule

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: Use the searchbar by line number
    Given I set into a searchbar a line number
    Then I get the line details and schedule