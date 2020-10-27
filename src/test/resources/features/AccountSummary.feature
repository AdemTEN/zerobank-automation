Feature: Account Summary Page

  @account_summary
  Scenario: User should be able see headers of Account Summary
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the page title should be "Zero - Account Summary"
    #eksi isareti ile calisti
    Then page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Credit Accounts table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |
