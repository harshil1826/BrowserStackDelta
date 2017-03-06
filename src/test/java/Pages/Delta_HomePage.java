package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utility.Helper;


public class Delta_HomePage {
	
	
	WebDriver driver;
	
	public Delta_HomePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//*[text()='One Way']") WebElement oneWay;
	
	@FindBy(xpath="//*[@id='originCity']") WebElement originCity;
	
	@FindBy(xpath="//*[@id='destinationCity']") WebElement destinationCity;
	
	@FindBy(xpath="//*[@id='depDateCalIcon']") WebElement departureCalendarControl;
	
	@FindBy(xpath="//label[text()='Depart Date']/following::input[1]") WebElement departureDate;
	
	@FindBy(xpath="//*[@id='findFlightsSubmit']") WebElement findFlights;
	
	@FindBy(xpath="//a[text()='Hotel']") WebElement hotelsLink;
	
	@FindBy(id="hotelLocation") WebElement hotelLocation;
	
	@FindBy(name="checkInDate") WebElement checkInDate;
	
	@FindBy(name="checkOutDate") WebElement checkOutDate;
	
	@FindBy(name="hotelTripSubmit") WebElement findHotels;
	
	
	
	public void clickOnOneWay() 
	{
		oneWay.click();
	}
	
	public void originCityCode()
	{
		originCity.sendKeys("SFO");;
	}
	
	public void destinationCityCode()
	{
		destinationCity.sendKeys("BOM");
	}
	
	public void clickOnDepartureCalendar()
	{	
		departureCalendarControl.click();
	}
	
	public void departureDate(int d) throws InterruptedException
	{
		 departureDate.sendKeys(Helper.provideDate(d));
	}
	
	public void clickOnFindFlights()
	{
		 findFlights.click();
	}
	
	public void clickOnHotelsLink()
	{
		 hotelsLink.click();
	}
	
	public void hotelLocationCode() throws InterruptedException
	{
		 hotelLocation.sendKeys("BOM");
		 Thread.sleep(2000);
		 new Actions(driver).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void checkInDate(int days) throws InterruptedException
	{
		 checkInDate.sendKeys(Helper.provideDate(days));
	}
	
	public void checkOutDate(int days) throws InterruptedException
	{
		 checkOutDate.sendKeys(Helper.provideDate(days));
	}
	
	public void clickOnFindHotels()
	{
		 findHotels.click();
	}
	
}
