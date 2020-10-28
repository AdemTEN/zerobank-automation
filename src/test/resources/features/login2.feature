Feature:

	Background:
		Given the user is on the login page
	
	@EUG12-280
	Scenario: Test-AsiyaClass

		    When the user logs in with valid credentials
		    Then "Account Summary" page should be displayed
		