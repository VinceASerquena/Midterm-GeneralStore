package pageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.BaseMethods;
import io.appium.java_client.android.AndroidDriver;
import locator.HomePageLoc;
import utils.ExtentReportsUtil;

public class HomePage extends BaseMethods{
	
	public HomePage(AndroidDriver driver) {
		super(driver);
	}
	
	public void validateHomePageElements() {
		assertElementDisplayed(HomePageLoc.Country_Select_Label);
		assertElementDisplayed(HomePageLoc.Country_Select_Dropdown);

		assertElementDisplayed(HomePageLoc.Name_Label);
		assertElementDisplayed(HomePageLoc.Name_Textbox);

		assertElementDisplayed(HomePageLoc.Gender_Label);
		assertElementDisplayed(HomePageLoc.Gender_Male_Checkbox);
		assertElementDisplayed(HomePageLoc.Gender_Female_Checkbox);
		
		assertElementDisplayed(HomePageLoc.Shop_Button);
	}
	
	public void createAccount(String country, String name) {
		clickElement(HomePageLoc.Country_Select_Dropdown);
		scrollToText(country);
		clickOnText(country);

		sendTextToElement(HomePageLoc.Name_Textbox, name);
		
		clickElement(HomePageLoc.Gender_Female_Checkbox);
		clickElement(HomePageLoc.Gender_Male_Checkbox);

		clickElement(HomePageLoc.Shop_Button);

		assertElementDisplayed(HomePageLoc.Products_Header);
		assertElementText(HomePageLoc.Products_Header, "Products");
	}
	
	//insert methods for homepage
	public void validateToast(String toast) {
		WebElement toastEle = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		try {
			String toastValue = toastEle.getText();
			Assert.assertTrue(toastValue.contentEquals(toast));
			System.out.println("Error Toast Message is Displayed: '" + toast +"'");
			ExtentReportsUtil.pass("Error Toast Message is Displayed: '" + toast +"'");
		} catch (StaleElementReferenceException e) {
			toastEle = driver.findElement(By.xpath("//android.widget.Toast[1]"));
			String toastValue = toastEle.getText();
			Assert.assertTrue(toastValue.contentEquals(toast));
			System.out.println("Error Toast Message is Displayed: '" + toast +"'");
			ExtentReportsUtil.pass("Error Toast Message is Displayed: '" + toast +"'");
		}
		
	}
}
