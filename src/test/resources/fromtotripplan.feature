Feature: Trip can be planned trough departure and destination fields

  Background:
    Given I open BudapestGO
    When I accept cookies

    Scenario: Trip plan
      When I type "Savoya Park" into departure field
      When I type "Újpest-városkapu" into destination field
      When I click on the plan button
      Then I get the possible routes