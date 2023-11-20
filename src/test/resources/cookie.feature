Feature: Cookies can be accepted or declined

  Background:
    Given I open BudapestGO

  Scenario: Accept cookies
    Given the cookie popup window
    When I click on accept button
    Then cookie window disappears

  Scenario: Decline cookies
    Given the cookie popup window
    When I click on details
    When I click on decline
    Then cookie window disappears
