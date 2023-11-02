package locator;

public class ProductsPageLoc {
	
	public static final String[] Products_Header = {"Products Header", "id", "com.androidsample.generalstore:id/toolbar_title"};
	
	public static final String[] Product_Name_Text = {"Product Name Text", "id", "com.androidsample.generalstore:id/productName"};
	public static final String[] Product_Price_Text = {"Product Price Text", "xpath", "//*[@text = '{value}']/following-sibling::android.widget.LinearLayout[2]/android.widget.TextView[1]"};

	public static final String[] Product_Add_To_Cart = {"Product Add To Cart Button", "xpath", "//*[@text = '{value}']/following-sibling::android.widget.LinearLayout[2]/*[@text = 'ADD TO CART']"};
	public static final String[] Product_Added_To_Cart = {"Product Added To Cart Text", "xpath", "//*[@text = '{value}']/following-sibling::android.widget.LinearLayout[2]/*[@text = 'ADDED TO CART']"};
	
	public static final String[] Product_Cart_Icon = {"Product Cart Icon", "id", "com.androidsample.generalstore:id/appbar_btn_cart"};
	public static final String[] Product_Cart_Count = {"Product Cart Count", "id", "com.androidsample.generalstore:id/counterText"};
	
	public static final String[] Cart_ProductName_Text = {"Cart Product Name Texr", "id", "com.androidsample.generalstore:id/productName"};
	
}
