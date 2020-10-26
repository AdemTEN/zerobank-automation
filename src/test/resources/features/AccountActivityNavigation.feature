
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is on the login page
    And the user logs in with valid credentials


  @Savings
  Scenario: Savings account redirect

    When the user clicks on "Savings" link on the Account Summary page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Savings"

  @Brokerage
  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Brokerage"

  @Checking
  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Checking"

  @Credit_Card
  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Credit Card"

  @Loan
  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Loan"

  @AccountActivityNavigation
  Scenario Outline: Accounts Redirect <link>
    When the user clicks on "<link>" link on the Account Summary page
    Then the page title should be "<page title>"
    Then verify Account dropdown default option should be "<account type>"

    Examples:

      | link        | page title              | account type |
      | Savings     | Zero - Account Activity | Savings      |
      | Brokerage   | Zero - Account Activity | Brokerage    |
      | Checking    | Zero - Account Activity | Checking     |
      | Credit Card | Zero - Account Activity | Credit Card  |
      | Loan        | Zero - Account Activity | Loan         |








