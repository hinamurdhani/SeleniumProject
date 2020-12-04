package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.LocatorsANDUrl;


public class CheckFunctionalityPageObject{
	

	WebDriver driver;
	String accountno;
	public CheckFunctionalityPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name = LocatorsANDUrl.USERNAME) 
	 private WebElement username;
	
	@FindBy(name = LocatorsANDUrl.PASSWORD) 
	 private WebElement password;
	
	@FindBy(id = LocatorsANDUrl.LOGINBUTTON) 
	 private WebElement loginbutton;
	
	@FindBy(xpath = LocatorsANDUrl.ACCOUNTS) 
	 private WebElement accounts;
	
	@FindBy(xpath = LocatorsANDUrl.CUSTOMERS) 
	 private WebElement customer;
	
	@FindBy(xpath = LocatorsANDUrl.CHILD_CUSTOMER) 
	 private WebElement childcustomer;
	
	@FindBy(xpath = LocatorsANDUrl.IMPORT_CUSTOMERS) 
	 private WebElement importcustomer;
	
	@FindBy(xpath = LocatorsANDUrl.SELECT_FILE) 
	 private WebElement selectfile;
	
	@FindBy(xpath = LocatorsANDUrl.IMPORT) 
	 private WebElement importbutton;
	
	@FindBy(xpath = LocatorsANDUrl.PROCESS) 
	 private WebElement process;
	
	@FindBy(xpath = LocatorsANDUrl.BACK_BUTTON) 
	 private WebElement backbutton;
	
	@FindBy(className = LocatorsANDUrl.ADMINISTRATOR_ADMIN) 
	 private WebElement admin;
	
	@FindBy(xpath = LocatorsANDUrl.LOGOUT) 
	 private WebElement logout;
	
	public void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", ele);
	}
	
	public void loginToPortal(String uname,String pass) throws InterruptedException {
		
		Thread.sleep(2000);
		highlight(username);
		Thread.sleep(2000);
		username.sendKeys(uname);
		Thread.sleep(2000);
		highlight(password);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		highlight(loginbutton);
		Thread.sleep(2000);
		loginbutton.click();
		
	}
	public void clickAccounts() throws InterruptedException {
		Thread.sleep(2000);
		highlight(accounts);
		Thread.sleep(2000);
		accounts.click();
		Thread.sleep(2000);
		
	}
	public void clickCustomers() throws InterruptedException {
		Thread.sleep(2000);
		highlight(customer);
		Thread.sleep(2000);
		customer.click();
		Thread.sleep(2000);
		highlight(childcustomer);
		Thread.sleep(2000);
		childcustomer.click();
		Thread.sleep(2000);
	
	}
	public void clickImportCustomers() throws InterruptedException {
		Thread.sleep(2000);
		highlight(importcustomer);
		Thread.sleep(2000);
		importcustomer.click();
		Thread.sleep(2000);
		
		
	}
	public void clickProcessButton() throws InterruptedException {
		Thread.sleep(2000);
		highlight(process);
		Thread.sleep(2000);
		process.click();
		Thread.sleep(2000);
		
	}
	public void getAccountNo() throws InterruptedException {
		WebElement acno = driver.findElement(By.xpath("(//td[@class='portlet-content'])[1]"));
		Thread.sleep(2000);
		accountno = acno.getText();
		Thread.sleep(2000);
		highlight(acno);
		
	}
	public void uploadFile(String file) throws InterruptedException, AWTException {
		
		Thread.sleep(2000);
		highlight(selectfile);
		selectfile.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
        Thread.sleep(3000);
		StringSelection stringSelection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(3000);
		// press CTRL+V
		robot.setAutoDelay(1000);
		//press CTRL+C
		robot.setAutoDelay(1000);
		robot.setAutoDelay(1000);
		//press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		//	press ENTER and Release ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(2000);
		Thread.sleep(2000);
		highlight(importbutton);
		Thread.sleep(2000);
		importbutton.click();
		Thread.sleep(2000);
		
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		highlight(admin);
		Thread.sleep(2000);
		admin.click();
		Thread.sleep(2000);
		highlight(logout);
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(2000);
		
	}
	public void checkForSuccessOrFailure() throws InterruptedException {
		
		String SuccessFailure = driver.findElement(By.xpath("//div[contains(text(),'Records imported successfully.')]")).getText();         
		
		//check for the success or failure
		
		//restricted for one data in file
		if(SuccessFailure.contains("Records imported successfully. : 1")){
			
			//if success then click on back and highlight the imported record
			System.out.println("success");
			Thread.sleep(2000);
			highlight(backbutton);
			Thread.sleep(2000);
			backbutton.click();
			Thread.sleep(2000);
			WebElement accountn = driver.findElement(By.xpath("//span[contains(text(),'"+accountno+"')]"));
			highlight(accountn);
			Thread.sleep(2000);
		}else {
			
			//if fails then print fail in console
			Thread.sleep(2000);
			System.out.println("fail");
		}
		
	}
	

}
