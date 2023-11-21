Feature: Languages can be changed on BudapestGO

  Background:
    Given I open BudapestGO website
    And I accept cookies

  Scenario Outline: Change language
    Given the languages is set to "<defaultLanguage>"
    When I change the language to "<newLanguage>"
    Then language is changed to "<newLanguage>"
    Examples:
      | defaultLanguage | newLanguage |
      | hungarian       | english     |
      | english         | hungarian   |
