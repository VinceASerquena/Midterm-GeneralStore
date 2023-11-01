package pageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.BaseMethods;
import io.appium.java_client.android.AndroidDriver;

public class HomePageMethods extends BaseMethods{
	
	public HomePageMethods(AndroidDriver driver) {
		super(driver);
	}
	
	//insert methods for homepage
	public void validateToast(String toast) {
		WebElement toastEle = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		try {
			String toastValue = toastEle.getText();
			Assert.assertTrue(toastValue.contentEquals(toast));
			System.out.println("Error Toast Message is Displayed: '" + toast +"'");
		} catch (StaleElementReferenceException e) {
			toastEle = driver.findElement(By.xpath("//android.widget.Toast[1]"));
			String toastValue = toastEle.getText();
			Assert.assertTrue(toastValue.contentEquals(toast));
			System.out.println("Error Toast Message is Displayed: '" + toast +"'");
		}
		
	}
}
