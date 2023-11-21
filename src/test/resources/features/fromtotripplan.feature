Feature: Trip can be planned trough departure and destination fields

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: Trip plan
    When I set "Savoya Park" into departure field
    And I set "Újpest-városkapu" into destination field
    And I plan the route
    Then I get the possible routes