Feature: 

	


		Background:
		    Given the user is on the login page
		
		    @valid_credentials  @EUG12-280
		  Scenario: user should be able to login with valid credentials
		    When the user logs in with valid credentials
		    Then "Account Summary" page should be displayed
		