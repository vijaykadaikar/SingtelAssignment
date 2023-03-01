package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver oWebdriver = null;
	
	public static void initializeDriver(String sBrowser, String sFlag) {
		if(sFlag.equalsIgnoreCase("true"))
		oWebdriver = getWebdriverViaWdm(sBrowser);
		else
		oWebdriver = getWebdriverViaBinary(sBrowser);	
		
	}

	private static WebDriver getWebdriverViaWdm(String sBrowser) {
		if (oWebdriver == null) {
			switch (sBrowser) {
			case "chrome": {
				WebDriverManager.chromedriver().setup();
//				ChromeOptions options = new ChromeOptions();
//				if(true) {
//					
//					options.addArguments("--headless=new");
//				}				
//				oWebdriver = new ChromeDriver(options);
				oWebdriver = new ChromeDriver();
				System.out.println("chrome driver initialized");
				break;
			}
			case "edge": {
				WebDriverManager.edgedriver().setup();
				oWebdriver = new EdgeDriver();
				break;
			}

			default: {

				System.out.print("driver not found");
			}

			}

		}
		return oWebdriver;
	}
	
	private static WebDriver getWebdriverViaBinary(String sBrowser) {
		if (oWebdriver == null) {
			switch (sBrowser) {
			case "chrome": {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
				oWebdriver = new ChromeDriver();
				System.out.println("chrome driver initialized");
				break;
			}
			case "edge": {
				System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
				oWebdriver = new EdgeDriver();
				break;
			}

			default: {

				System.out.print("driver not found");
			}

			}

		}
		return oWebdriver;
	}
	
	public static void quitWebdriverInstance() {
		oWebdriver.quit();
	}
	
	
	

}
