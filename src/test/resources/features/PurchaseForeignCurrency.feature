Feature: Purchase Foreign Currency


  Background:
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user click on "Pay Bills" page
    Then click on "Purchase Foreign Currency" tab


  @available_currencies
  Scenario: Available currencies

    Then following currencies should be available
      | Select One            |
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |


  @errormessage_without_currency
  Scenario: Error message for not selecting currency

    When user tries to calculate cost without selecting a currency and click on purchase button
    Then error message on popup "Please, ensure that you have filled all the required fields with valid values." should be displayed

  @arrormessage_without_value
  Scenario: Error message for not entering value
    And Select "Australia (dollar)" from the currency
    When user tries to calculate cost without entering a value and click on purchase button
    Then error message on popup "Please, ensure that you have filled all the required fields with valid values." should be displayed

