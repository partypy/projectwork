Feature: Cookies can be accepted or declined

  Background:
    Given I open BudapestGO
    Given the cookie popup window is active

  Scenario: Accept cookies

    When I click on accept button
    Then cookie window disappears

  Scenario: Decline cookies

    When I click on details
    And I click on decline
    Then cookie window disappears
