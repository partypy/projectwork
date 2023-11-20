Feature: Cookies can be accepted

  Background:
    Given I open BudapestGO
    Given the cookie popup window is active

  Scenario: Accept cookies

    When I click on accept button
    Then cookie window disappears

