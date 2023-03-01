package stepdef;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import util.PropertyFileHandler;

public class Hooks {
	public static Properties oConfig = null, oLocators = null;
	public  static PropertyFileHandler oPropertyFileHandler = null;
	public static WebDriver oWebdriver = null;
	public static int iScreenshotCounter =0; 
	
	@BeforeAll
	public static void beforeAll() {
	 oPropertyFileHandler= new PropertyFileHandler("src/test/resources/config.properties");
	 oConfig= oPropertyFileHandler.LoadProperties();
//	 oPropertyFileHandler= new PropertyFileHandler("src/test/resources/locators.properties");
//	 oLocators= oPropertyFileHandler.LoadProperties();
	 System.out.println("Properties intialized");
	 Base.initializeDriver( oConfig.getProperty("BROWSER_NAME"),oConfig.getProperty("WebDriverManager_Flag"));
	
	}
	
	@AfterAll
	public static void afterAll() {
		Base.quitWebdriverInstance();
	}
	
	
	@AfterStep
	public static void captureScreenshot(Scenario oScenario) {
		oScenario.attach(getByteScreenshot(), "image/png", "Screen"+iScreenshotCounter);
		iScreenshotCounter++;
	}
	
	private static byte[] getByteScreenshot() 
	{
	    File src = ((TakesScreenshot) Base.oWebdriver).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent =null;
		try {
			fileContent = FileUtils.readFileToByteArray(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return fileContent;
	}

}
