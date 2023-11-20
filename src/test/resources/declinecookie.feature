Feature: Cookies can be declined

  Background:
    Given I open BudapestGO
    Given the cookie popup window is active

  Scenario: Decline cookies

    When I click on details
    And I click on decline
    Then cookie window disappears
