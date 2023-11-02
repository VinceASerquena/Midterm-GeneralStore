package scripts;

import java.net.MalformedURLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseClass;
import locator.ProductsPageLoc;
import pageMethods.HomePage;
import pageMethods.ProductsPage;

public class TC2_ProductsAndCart extends BaseClass {
	
	@Test
	@Parameters({"Country", "Name"})
	public void validateProductsNavigation(String country, String name) throws MalformedURLException {
		HomePage hpMethods = new HomePage(driver);
		ProductsPage ppPage = new ProductsPage(driver);

		hpMethods.createAccount(country, name);	
		ppPage.validateProducts(ProductsPageLoc.Product_Name_Text);
	}
	
	@Test
	@Parameters({"ProductName"})
	public void addToCartByProductName(String name) throws MalformedURLException {
		ProductsPage ppPage = new ProductsPage(driver);
		
		ppPage.addToCartProduct(name);
		
	}
	
}
