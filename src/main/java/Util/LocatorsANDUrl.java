package Util;

public class LocatorsANDUrl {

	//URL
	public static final String LOGIN_URL = "https://latest.astppbilling.org";
	
	//Locators
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String LOGINBUTTON = "save_button";
	public static final String ACCOUNTS = "//a[contains(text(),'Accounts')]";
	public static final String CUSTOMERS = "//a//child::span[contains(text(),'Customers')]";
	public static final String CHILD_CUSTOMER = "(//a[contains(text(),'Customers')])[1]";
	public static final String IMPORT_CUSTOMERS = "//span[contains(text(),'Import Customers')]";
	public static final String SELECT_FILE = "//input[@id = 'customer_import_mapper']";
	public static final String IMPORT = "//button[contains(text(),'Import')]";
	public static final String PROCESS = "//input[@id='Process']";
	public static final String BACK_BUTTON = "//input[@value='Back']";
	public static final String ADMINISTRATOR_ADMIN = "profile_name";
	public static final String LOGOUT = "//a[contains(text(),'Log out')]";
	
	
	
}
