package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Delta_HomePage;
import Pages.Delta_HotelResultsPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.Helper;

public class Verify_HotelSearch {

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
	 
		homepage.clickOnHotelsLink();
	 
		homepage.hotelLocationCode();
	 
		homepage.checkInDate(4);
		
		homepage.checkOutDate(8);
	 
		homepage.clickOnFindHotels();
		
		Delta_HotelResultsPage hotelResultsPage =  PageFactory.initElements(driver, Delta_HotelResultsPage.class);
		
		//hotelResultsPage.popUpHanding();
	 
		Helper.NoOfHotelResults(driver);
		
		
		Reporter.log("*****Test completed*****");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		 BrowserFactory.closeBrowser(driver);
		 
		 Reporter.log("*****Session Ended*****");
	}
	
}
