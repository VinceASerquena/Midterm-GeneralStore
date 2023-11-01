package scripts;

import java.net.MalformedURLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseClass;
import locator.HomePage;
import pageMethods.HomePageMethods;

public class TC1_CreateAccount extends BaseClass {
	
	@Test
	public void validateHomePage() throws MalformedURLException {
		HomePageMethods hpMethods = new HomePageMethods(driver);	
		hpMethods.assertElementDisplayed(HomePage.Country_Select_Label);
		hpMethods.assertElementDisplayed(HomePage.Country_Select_Dropdown);

		hpMethods.assertElementDisplayed(HomePage.Name_Label);
		hpMethods.assertElementDisplayed(HomePage.Name_Textbox);

		hpMethods.assertElementDisplayed(HomePage.Gender_Label);
		hpMethods.assertElementDisplayed(HomePage.Gender_Male_Checkbox);
		hpMethods.assertElementDisplayed(HomePage.Gender_Female_Checkbox);
		
		hpMethods.assertElementDisplayed(HomePage.Shop_Button);
	}
	
	@Test
	@Parameters({"Country", "Name"})
	public void createAccount(String country, String name) throws MalformedURLException {
		HomePageMethods hpMethods = new HomePageMethods(driver);
		hpMethods.clickElement(HomePage.Country_Select_Dropdown);
		hpMethods.scrollToText(country);
		hpMethods.clickOnText(country);

		hpMethods.sendTextToElement(HomePage.Name_Textbox, name);
		
		hpMethods.clickElement(HomePage.Gender_Female_Checkbox);
		hpMethods.clickElement(HomePage.Gender_Male_Checkbox);

		hpMethods.clickElement(HomePage.Shop_Button);

		hpMethods.assertElementDisplayed(HomePage.Products_Header);
		hpMethods.assertElementText(HomePage.Products_Header, "Products");
	}
	
	@Test
	public void invalidAccount() throws MalformedURLException {
		HomePageMethods hpMethods = new HomePageMethods(driver);
		hpMethods.clickElement(HomePage.Shop_Button);
		
		hpMethods.validateToast("Please enter your name");
	}

		
}
