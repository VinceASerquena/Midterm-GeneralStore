package common;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BaseMethods {
	protected AndroidDriver driver;
	protected WebDriverWait wait;
	
	public BaseMethods(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void navigateBack() {
		driver.navigate().back();
		System.out.println("Navigated to Previous page");
	}
	
	public void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickOnText(String value) {
		WebElement ele = driver.findElement(AppiumBy.xpath("//*[@text = '"+ value +"']"));
		try {
			ele.click();
			System.out.println("Clicked on text");
		} catch (StaleElementReferenceException e) {
			ele = driver.findElement(AppiumBy.xpath("//*[text() = '"+ value +"']"));
			ele.click();
			System.out.println("Clicked on text");
		}
	}
	
	public void clickElement(String[] element) {
		String locatorBy = element[1];
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				elm.click();
				System.out.println(element[0] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				elm.click();
				System.out.println(element[0] + " was Clicked");
			}	
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				elm.click();
				System.out.println(element[0] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				elm.click();
				System.out.println(element[0] + " was Clicked");
			}	
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				elm.click();
				System.out.println(element[0] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				elm.click();
				System.out.println(element[0] + " was Clicked");
			}	
		}
		
	}
	
	public void sendTextToElement(String[] element, String value) {
		String locatorBy = element[1];
		
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);				
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);
			}

		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);				
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);
			}

		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				elm.sendKeys(value);			
				System.out.println("Send text value to element: " + element[0]);
			}
		}
	}
	
	public void validateIfCorrectText(String[] element, String expectedValue) {
		String locatorBy = element[1];
		String actualValue;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);				
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);
			}

		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);				
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);
			}

		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				actualValue = elm.getText();
				Assert.assertEquals(actualValue,expectedValue);
			}
		}
		
		
	}
	
	public void longPressElement(String[] element) {
		String locatorBy = element[1];
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) elm).getId()
					));
				System.out.println(element[0] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) elm).getId()
					));
				System.out.println(element[0] + " long pressed");
			}
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) elm).getId(), "duration",2000
					));
				System.out.println(element[0] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) elm).getId(), "duration",2000
					));
				System.out.println(element[0] + " long pressed");
			}
		}
		
		
	}
	
	public void assertElementText(String[] element, String expectedValue) {
		String val;
		if (element[1] == "accessibilityId") {
			val=driver.findElement(AppiumBy.accessibilityId(element[2])).getText();
			Assert.assertEquals(val, expectedValue);
			System.out.println(element[0] + ": text is equal to expected Value - " + expectedValue);
		}
		else if (element[1] == "id") {
			val=driver.findElement(AppiumBy.id(element[2])).getText();
			Assert.assertEquals(val, expectedValue);
			System.out.println(element[0] + ": text is equal to expected Value - " + expectedValue);
		}
		
		else if (element[1] == "xpath") {
			val=driver.findElement(AppiumBy.xpath(element[2])).getText();
			Assert.assertEquals(val, expectedValue);
			System.out.println(element[0] + ": text is equal to expected Value - " + expectedValue);
		}
	}
	
	public void assertElementDisplayed(String[] element) {
		
		if (element[1] == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			try {
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);	
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);	
			}
			
		}
		else if (element[1] == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			try {
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);	
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[2]));
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);	
			}
		}
		
		else if (element[1] == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			try {
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[2]));
				Assert.assertTrue(elm.isDisplayed());
				System.out.println("Element is displayed: " + element[0]);
			}
		}
	}
	
	public boolean scrollDownGesture() {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 5, "top", 350, "width", 45, "height", 2850,
			    "direction", "down",
			    "percent", 3.0
			));
		return canScrollMore;
	}
	public void swipeGesture() {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 5, "top", 350, "width", 45, "height", 2850,
			    "direction", "up",
			    "percent", 0.75
			));
	}
	
	public void swipeGesture(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), 
			    "direction", "up",
			    "percent", 0.75
			));
	}
	
	
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));	
	}
	
	public void scrollToElementByUIAutomator(String[] element) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+element[3]+")"));
		
		System.out.println("Scrolled to: " + element[0]);
	}
	
	public boolean flingGesture(String[] element) {
		String locatorBy = element[1];
		boolean canScrollMore = true;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "direction", "down",
				    "speed", 5000
				));
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "direction", "down",
				    "speed", 5000
				));
		}		
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "direction", "down",
				    "speed", 5000
				));	
		}
		
		return canScrollMore;
	}
	
	public void dragGesture(String[] element, int coordinateX, int coordinateY) {
		String locatorBy = element[1];
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[2]));
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "endX", coordinateX,
				    "endY", coordinateY
				));
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[2]));
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "endX", coordinateX,
				    "endY", coordinateY
				));
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[2]));
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) elm).getId(),
				    "endX", coordinateX,
				    "endY", coordinateY
				));
		}
	}
	
	public void getElementsTextByXpath(String locatorByXpath) {
		List<WebElement> elements = driver.findElements(By.xpath(locatorByXpath));
        
		for(WebElement element: elements){
		    System.out.println(element.getText());
		}
	}
	
	public void moveToElement(String[] ele) {
		
		String locatorBy = ele[1];
		
		if (locatorBy == "accessibilityId") {
			WebElement element = driver.findElement(AppiumBy.accessibilityId(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.accessibilityId(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			}
		}
		else if (locatorBy == "id") {
			WebElement element = driver.findElement(AppiumBy.id(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.id(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			}
		}
		else if (locatorBy == "xpath") {
			WebElement element = driver.findElement(AppiumBy.xpath(ele[2]));
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			} catch (StaleElementReferenceException e) {
				element = driver.findElement(AppiumBy.xpath(ele[2]));
				Actions action = new Actions(driver);
				action.moveToElement(element);
				action.perform();	
			}
			
		}
				
	}

}
