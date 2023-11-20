Feature: Selection of vehicles that can be used on the trip

  Background:
    Given I open BudapestGO
    When I accept cookies

  Scenario: Deselect the unwanted vehicles types
    Given all types are selected
    When I set subway to disabled
    When I set suburban railway to disabled
    When I set ferry to disabled
    When I set tram to disabled
    When I set trolleybus to disabled
    When I set bus to disabled
    When I set rail to disabled
    When I set regional bus to disabled
    Then I get the desired vehicle types

    # Itt most bizonytalan vagyok,hogy melyik a célravezetőbb.

  Scenario: Deselect the unwanted vehicles types
    Given all types are selected
    When I deselect vehicles type
      | subway           |
      | suburban railway |
      | ferry            |
      | tram             |
      | trolleybus       |
      | bus              |
      | rail             |
      | regional bus     |
    Then I get the desired vehicle types