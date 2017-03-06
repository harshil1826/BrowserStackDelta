package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class BrowserFactory 
{

	
	 WebDriver driver;
	public static final String URL = "https://" + DataProviderFactory.getConfig().getUSERNAME() + ":" + DataProviderFactory.getConfig().getAUTOMATE_KEY() + "@hub-cloud.browserstack.com/wd/hub";
	
	public  WebDriver getBrowser(String browserName, String browserVersion, String osVersion)
	{
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", browserName);                 //  Firefox, IE, Chrome
			caps.setCapability("browser_version", browserVersion);
			caps.setCapability("os", "Windows"); //Windows
			caps.setCapability("os_version", osVersion);
			caps.setCapability("browserstack.debug", "true");
			
			driver = new RemoteWebDriver(new URL(URL), caps);
			
			} catch (MalformedURLException e) {
			 Reporter.log("Browser session couldn't started--> "+e.getMessage(),true);
		    	
			}
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}
	
	
}
