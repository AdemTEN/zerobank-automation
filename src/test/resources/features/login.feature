@login
Feature: user should be able to login

  Background:
    Given the user is on the login page

    @valid_credentials
  Scenario: user should be able to login with valid credentials
    When the user logs in with valid credentials
    Then "Account Summary" page should be displayed

   @wrong_credentials
  Scenario: user shouldn't be able to login with wrong username credentials
    When user enter "hello" as username and "password" as password
    Then error message "Login and/or password are wrong." should be displayed

   @wrong_password
  Scenario: user shouldn't be able to login with wrong password credentials
    When user enter "username" as username and "hiiii" as password
    Then error message "Login and/or password are wrong." should be displayed

   @blank_password
  Scenario: user shouldn't be able to login with blank password credentials
    When user enter "username" as username and "" as password
    Then error message "Login and/or password are wrong." should be displayed

   @blank_username
  Scenario: user shouldn't be able to login with blank username credentials
    When user enter "" as username and "password" as password
    Then error message "Login and/or password are wrong." should be displayed

  @login @wrong_credential
  Scenario Outline: user shouldn't be able to login with wrong  credentials <username>
    When user enter "<username>" as username and "<password>" as password
    Then error message "<message>" should be displayed

    Examples:
      | username | password | message                          |
      | xxxxx    | password | Login and/or password are wrong. |
      | username | xxxxx    | Login and/or password are wrong. |
      | xxxxx    | xxxxx    | Login and/or password are wrong. |
      |          | password | Login and/or password are wrong. |
      | username |          | Login and/or password are wrong. |
      |          |          | Login and/or password are wrong. |
