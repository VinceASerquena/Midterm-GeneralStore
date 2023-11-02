package scripts;

import java.net.MalformedURLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseClass;
import locator.HomePageLoc;
import pageMethods.HomePage;

public class TC1_CreateAccount extends BaseClass {
	
	@Test
	public void validateHomePage() throws MalformedURLException {
		HomePage hpMethods = new HomePage(driver);	
		hpMethods.validateHomePageElements();
	}
	
	@Test
	@Parameters({"Country", "Name"})
	public void createAccount(String country, String name) throws MalformedURLException {
		HomePage hpMethods = new HomePage(driver);
		hpMethods.createAccount(country, name);
	}
	
	@Test
	public void invalidAccount() throws MalformedURLException {
		HomePage hpMethods = new HomePage(driver);
		hpMethods.clickElement(HomePageLoc.Shop_Button);
		hpMethods.validateToast("Please enter your name");
	}

		
}
