Feature: Search for specific line details and schedule

  Background:
    Given I open BudapestGO
    When I decline cookies

  Scenario: Use the searchbar by line number
    Given searchbar is available
    When I enter the line name
    When I click on the first item
    Then I get the line details and schedule