@smoke
Feature: Account activity page

  @account_activity
  Scenario: user should be able to enter Account Activity page
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user click on "Account Activity" page
    Then the page title should be "Zero - Account Activity"
    Then verify Account dropdown default option should be "Savings"
    Then Account dropdown should have following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transactions table should have column names:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
