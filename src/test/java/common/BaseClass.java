package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.ExtentReportsUtil;
import utils.Logger;

public class BaseClass {
	AppiumDriverLocalService service;
	protected AndroidDriver driver;
	public static ITestResult result;
	
	@BeforeSuite
	public void setupReport() {
		ExtentReportsUtil.startExtentReport("\\Reports\\Test.html");
	}
	
	@BeforeTest
	public void startServerwithApp() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String portNo=prop.getProperty("port");
		String deviceName=prop.getProperty("AndroidDeviceName");
		
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\COLLABERA.DIGITAL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(Integer.parseInt(portNo)).build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(deviceName);		
		options.setApp(System.getProperty("user.dir")+"\\src\\main\\resources\\appUsed\\General-Store.apk");
		options.setCapability("appium:autoGrantPermissions", true);
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		ExtentReportsUtil.getExtentResult(result);
		Logger.log("Results Retrieved");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		service.stop();
		Logger.log("End Test");
	}
	
	@AfterSuite
	public void endTest() {
		ExtentReportsUtil.flushExtentReport();
		ExtentReportsUtil.closeExtentReport();
		Logger.log("End Report");
	}
}
