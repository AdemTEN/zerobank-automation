Feature: user is on the Pay Bills page


  Background:
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user click on "Pay Bills" page
    Then the page title should be "Zero - Pay Bills"


  @pay_bills
  Scenario: user should be able to complete pay operation

    Then user should be able to complete payment
    Then the message "The payment was successfully submitted." should be displayed


  Scenario Outline: user should  enter  any amount in amount box and date in date box <input>

    Then the user try to make payment without "<input>"
    Then the warning message "<message>" in the the "<box name>" should be displayed

    Examples:
      | input  | message                     | box name   |
      | amount | Please fill out this field. | Amount Box |
      | date   | Please fill out this field. | Date Box   |


  Scenario Outline: user should  enter only numbers  in amount and date input box <input>

    #THERE IS A BUG IN FIRST SCENARIO===> AMOUNT BOX ACCEPT ALPHABETICAL AND SPECIAL CHARACTER
    Then the user enter special or alphabetical character as "<input>"
    Then the "<box name>" should not accept any character without numbers

    Examples:
      | input  | box name   |
      | amount | Amount Box |
      | date   | Date Box   |















