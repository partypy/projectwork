Feature: Route planning with fixed-track means of transport

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: I would like to plan the trip by tram only
    Given set departure location to "Bazilika"
    And set destination location to "Nyugati Pályaudvar"
    And set only tram lines
    When I plan the route
    Then I get only tram routes
