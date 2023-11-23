@Runner1
Feature: Cookies can be accepted

  Background:
    Given I open BudapestGO


  Scenario: Accept cookies
    When I accept cookies
    Then cookie window disappears

