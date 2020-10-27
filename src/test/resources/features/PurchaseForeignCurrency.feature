Feature: Purchase Foreign Currency


  Background:
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user click on "Pay Bills" page
    Then click on "Purchase Foreign Currency" tab


  @available_currencies
  Scenario: Available currencies

    Then following currencies should be available
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



  @wip
  Scenario Outline: Error message for not selecting currency or entering value
    When user tries to calculate cost without enter a "<Currency or Amount>" and click on purchase button
    Then error message on popup "<Error Message>" should be displayed

    Examples:

      | Currency or Amount | Error Message                                                                  |
      | Currency           | Please, ensure that you have filled all the required fields with valid values. |
      | Amount             | Please, ensure that you have filled all the required fields with valid values. |

