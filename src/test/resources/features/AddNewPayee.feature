@smoke
Feature: Add new payee under pay bills

  @add_new_payee
  Scenario Outline: Add a new payee

    Given the user is on the login page
    And the user logs in with valid credentials
    When the user click on "Pay Bills" page
    Then click on "Add New Payee" tab
    And creates new payee using following information
      | Payee Name    | <name>    |
      | Payee Address | <address> |
      | Account       | <account> |
      | Payee details | <details> |
    Then message The new payee "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

    Examples:
      | name                                     | address                          | account  | details     |
      | The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001 | Checking | XYZ account |