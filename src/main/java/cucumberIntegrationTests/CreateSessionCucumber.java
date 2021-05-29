package cucumberIntegrationTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;


/**
 * contains all the methods to create a new session and destroy the 
 * session after the test(s) execution is over. Each test extends
 *  this class.
 */
public class CreateSessionCucumber {

	public WebDriver driver = null;
	Properties configFile ;
	protected static Properties lobConfigProp = new Properties();
	public static Properties localeConfigProp = new Properties();
	protected FileInputStream configFis, lobConfigFis, localeConfigFis;	
	public Properties testDataFile;
	private final String CONFIG_FILE_PATH="//src//main//java//config//config.properties";
	protected File file = new File("");
	Properties configProp = new Properties();
	String OS;


	/** 
	 * this method creates the driver depending upon the passed parameter (android or iOS)
	 *  and loads the properties files (config and test data properties files).
	 * @throws Exception issue while loading properties files or creation of driver.
	 */
	//@Parameters({"os"})
	//@BeforeMethod
	public  void createDriver() throws Exception{

		propertiesFileLoad("android");

		File propertiesFile = new File(file.getAbsoluteFile() + "//src//main//java//log4j.properties");
		PropertyConfigurator.configure(propertiesFile.toString());
		Log.info("--------------------------------------");
		androidDriver();
		Log.info("Android driver created");
	}

	/** 
	 * this method quit the driver after the execution of test(s) 
	 */
	//@AfterMethod
	public void teardown(){
		Log.info("Shutting down driver");
		driver.quit();
	}

	/** 
	 *  this method creates the android driver
	 * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
	 */
	public synchronized void androidDriver() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Lingu");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","8.1.0");
		capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
		capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		capabilities.setCapability("name", "SauceLabs");
		capabilities.setCapability("app", "C:\\Users\\lingu\\Downloads\\Saucelabs.apk");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability("automationName", "UiAutomator2");
		driver = new AndroidDriver( new URL("http://localhost:4723/wd/hub"), capabilities);
	}

	/** 
	 *  this method loads properties files config and file having test data.
	 * @param platform android or ios, to load specific test data file.
	 * @throws Exception property files are not loaded successfully
	 */
	public void propertiesFileLoad(String platform) throws Exception{
		configFis = new FileInputStream(file.getAbsoluteFile()
				+ CONFIG_FILE_PATH);
		configProp .load(configFis);

		File f = new File(file.getAbsoluteFile() + "//src//main//java//config//" + platform
				+ "_config.properties");

		if (f.exists() && !f.isDirectory()) {
			lobConfigFis = new FileInputStream(file.getAbsoluteFile()
					+ "/src//main//java//config//" + platform + "_config.properties");
			lobConfigProp.load(lobConfigFis);

			String locale = lobConfigProp.getProperty("LOCALE");

			localeConfigFis = new FileInputStream(file.getAbsoluteFile()
					+ "//src//main//java//testData//" + locale + "_" + platform  + ".properties");
			localeConfigProp.load(localeConfigFis);
		} 
		else {
			throw new Exception("Properties files loading failed ");
		}}

	public String choosebuild(String invokeDriver){
		String appPath = null;
		if(invokeDriver.equals("android")){
			appPath = configProp.getProperty("AndroidAppPath");
			return appPath;
		}
		else if(invokeDriver.equals("iOS")){
			appPath = configProp.getProperty("iOSAppPath");
			return appPath;
		}

		return appPath;
	}

	public WebDriver getWebDriver(){
		return this.driver;
	}
}

