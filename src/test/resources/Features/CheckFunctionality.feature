Feature: Testing the admin portal


Scenario: Check the functionality
	Given open the browser and open the login page
	Then I login to the portal
	|Username|admin|
	|Password|admin|
	Then I click on Accounts
	Then I click on Customers in Customer tab
	Then I click on Import customer
	Then I upload the file And Click on Import
	|file|C:\\Users\\hina.murdhani\\Downloads\\samplefile.csv|
	Then I get the accountNumber of uploaded data
	Then I click on process button
	Then I check for success or failure
	Then I logout from the portal 
	Then I close the driver