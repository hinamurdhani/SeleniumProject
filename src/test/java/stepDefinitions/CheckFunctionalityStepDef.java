package stepDefinitions;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CheckFunctionalityPageObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class CheckFunctionalityStepDef {
	
	
	WebDriver driver;
	
	CheckFunctionalityPageObject object;

	@Given("^open the browser and open the login page$")
	public void openLoginPageInBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://latest.astppbilling.org");
	}
	@Then("^I login to the portal$")
	public void loginToPortal(DataTable details) throws InterruptedException {
		List<List<String>> data = details.raw();
		String uname = data.get(0).get(1);
		String pass = data.get(1).get(1);
		object = new CheckFunctionalityPageObject(driver);
		object.loginToPortal(uname,pass);
	}
	@Then("^I click on Accounts$")
	public void clickAccounts() throws InterruptedException {
		object.clickAccounts();
	}
	@Then("^I click on Customers in Customer tab$")
	public void clickCustomers() throws InterruptedException {
		object.clickCustomers();
	}

	@Then("^I click on Import customer$")
	public void clickImportCustomers() throws InterruptedException { 
		object.clickImportCustomers();
	}
	@Then("^I upload the file And Click on Import$")
	public void uploadFile(DataTable details) throws InterruptedException, AWTException { 
		List<List<String>> data = details.raw();
		String File = data.get(0).get(1);
		object.uploadFile(File);
	}
	@Then("^I logout from the portal$")
	public void logout() throws InterruptedException {
		object.logout();
	}
	@Then("^I get the accountNumber of uploaded data$")
	public void getAccountNo() throws InterruptedException {
		object.getAccountNo();
	}
	@Then("^I click on process button$")
	public void clickProcessButton() throws InterruptedException {
		object.clickProcessButton();
	}
	@Then("^I check for success or failure$")
	public void checkForSuccessOrFailure() throws InterruptedException {
		object.checkForSuccessOrFailure();
	}
	@Then("^I close the driver$")
	public void closeDriver() throws InterruptedException {
		driver.close();
	}
	
}
