@Runner3
Feature: Trip can be planned trough departure and destination fields

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: Trip plan
    When I plan a trip from  "Savoya Park" to "Újpest-városkapu"
    Then I get the possible routes