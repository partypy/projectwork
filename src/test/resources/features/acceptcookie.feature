Feature: Cookies can be accepted

  Background:
    Given I open BudapestGO
    And the cookie accept button is presented

  Scenario: Accept cookies

    When I accept cookies
    Then cookie window disappears

