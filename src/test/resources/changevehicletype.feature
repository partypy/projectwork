Feature: Route planning with fixed-track means of transport

  Background:
    Given I open BudapestGO
    When I accept cookies

  Scenario: I would like to plan the trip by tram only
    Given "departure location" field is filled
    Given "destination location" field is filled
    When I set only tram lines
    Then I get only yellow(tram colored) routes
