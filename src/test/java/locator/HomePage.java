package locator;

public class HomePage {

	public static final String[] Country_Select_Label = {"Country Select Label", "xpath", "//android.widget.TextView[@text = 'Select the country where you want to shop']"};
	public static final String[] Country_Select_Dropdown = {"Country Select Dropdown", "id", "com.androidsample.generalstore:id/spinnerCountry"};
	
	public static final String[] Name_Label = {"Name Label", "xpath", "//android.widget.TextView[@text = 'Your Name']"};
	public static final String[] Name_Textbox = {"Name Textbox", "id", "com.androidsample.generalstore:id/nameField"};
	
	public static final String[] Gender_Label = {"Gender Label", "xpath", "//android.widget.TextView[@text = 'Gender']"};
	public static final String[] Gender_Male_Checkbox = {"Gender-Male Checkbox", "id", "com.androidsample.generalstore:id/radioMale"};
	public static final String[] Gender_Female_Checkbox = {"Gender-Female Checkbox", "id", "com.androidsample.generalstore:id/radioFemale"};
	
	public static final String[] Shop_Button = {"Shop Button", "id", "com.androidsample.generalstore:id/btnLetsShop"};
	
	public static final String[] Products_Header = {"Products Header", "id", "com.androidsample.generalstore:id/toolbar_title"};
	
	public static final String[] Toast_Error_Message = {"Toast Error Message", "xpath", "//android.widget.Toast[@text, 'Please enter your name']"};
	
}
