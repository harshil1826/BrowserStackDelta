package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Delta_FlightResultsPage;
import Pages.Delta_HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.Helper;

public class Verify_FlightDetails {

WebDriver driver;
	

	@BeforeMethod
	@Parameters({"browser.name","browser.version","os.version"})
	public void setUP(String browserName, String browserVersion, String osVersion)
	{
		Reporter.log("*****Waiting for Browser to launch*****",true);
		 driver=new BrowserFactory().getBrowser(browserName, browserVersion, osVersion);
		 Reporter.log("*****Browser started*****");
	}
	
	
	@Test
	public void testHomePage() throws InterruptedException
	{
		
		 Reporter.log("*****Test started*****");
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		
		Delta_HomePage homepage = PageFactory.initElements(driver, Delta_HomePage.class);
	 
		homepage.clickOnOneWay();
	 
		homepage.originCityCode();
	 
		homepage.destinationCityCode();
	 
		homepage.departureDate(9);
	 
		homepage.clickOnFindFlights();
	 
		Helper.NoOfFlightResults(driver);
		
		Delta_FlightResultsPage resultPage = PageFactory.initElements(driver, Delta_FlightResultsPage.class);
		
		resultPage.resultSelection();
		
		resultPage.verifyTripDetails();
		
		Reporter.log("*****Test completed*****");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		 BrowserFactory.closeBrowser(driver);
		 
		 Reporter.log("*****Session Ended*****");
	}
	
}
