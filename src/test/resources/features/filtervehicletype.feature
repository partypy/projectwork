Feature: Route planning with fixed-track means of transport

  Background:
    Given I open BudapestGO
    And I accept cookies

  Scenario: I would like to plan the trip by tram only
    When I plan route from "Budapest-Kelenföld" to "Nyugati Pályaudvar" only with tram
    Then I get only tram routes
