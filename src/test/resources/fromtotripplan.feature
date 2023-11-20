Feature: Trip can be planned trough departure and destination fields

  Background:
    Given I open BudapestGO
    When I accept cookies

    Scenario: Trip plan
      When I type "departure location" into departure field
      When I type "destination location" into destination field
      When I click on the plan button
      Then I get the possible routes