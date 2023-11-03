package pageMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import common.BaseMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import locator.ProductsPageLoc;
import utils.ExtentReportsUtil;

public class ProductsPage extends BaseMethods{
	
	public ProductsPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void validateProducts(String[] elm) throws StaleElementReferenceException{
	
		List<String> products = new ArrayList<>();
		List<WebElement> listOfElements;
		listOfElements = new ArrayList<>();
		
		
		listOfElements = driver.findElements(AppiumBy.id(elm[2]));
		for(WebElement element: listOfElements){
		    products.add(element.getText());
		}
		
		scrollToText("Converse All Star");
		listOfElements = driver.findElements(AppiumBy.id(elm[2]));
		for(WebElement element: listOfElements){
		    products.add(element.getText());
		}
		
		scrollToText("Jordan Lift Off");
		listOfElements = driver.findElements(AppiumBy.id(elm[2]));
		for(WebElement element: listOfElements){
		    products.add(element.getText());
		}
		
		scrollToText("Nike SFB Jungle");
		listOfElements = driver.findElements(AppiumBy.id(elm[2]));
		for(WebElement element: listOfElements){
		    products.add(element.getText());
		}
		
		SortedSet<String> s = new TreeSet<String>();
		for(int i=0; i<products.size(); i++) {
		      s.add(products.get(i));
		}
				
		System.out.println("Sorted Product List: ");
		ExtentReportsUtil.info("Sorted Product List: ");
		int ctr = 1;
		for (String str : s) {
			System.out.println(ctr + ". " + str);
			ExtentReportsUtil.info(ctr + ". " + str);
			ctr++;
		}	
				
	}
	
	public void addToCartProduct(String productName) {
		scrollToText(productName);
		
		String[] addToCart = ProductsPageLoc.Product_Add_To_Cart;
		addToCart[2] = addToCart[2].replace("{value}", productName);
		clickElement(addToCart);
		
		String[] addedToCart = ProductsPageLoc.Product_Added_To_Cart;
		addedToCart[2] = addedToCart[2].replace("{value}", productName);
		assertElementDisplayed(addedToCart);
	
		
		assertElementDisplayed(ProductsPageLoc.Product_Cart_Icon);
		assertElementText(ProductsPageLoc.Product_Cart_Count, "1");
		clickElement(ProductsPageLoc.Product_Cart_Icon);
		
		assertElementDisplayed(ProductsPageLoc.Cart_ProductName_Text);
		assertElementText(ProductsPageLoc.Cart_ProductName_Text, productName);
	}
}
