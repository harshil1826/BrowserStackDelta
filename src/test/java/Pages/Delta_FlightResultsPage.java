package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Delta_FlightResultsPage {

	
	WebDriver driver;
	
	@FindBy(xpath="//*[text()='Book a trip']") WebElement bookAtrip;
	@FindBy(xpath="//*[text()='Price per Passenger']") WebElement pricePerpassenger;
	@FindBy(xpath="//*[text()='Proceed to Checkout']") WebElement ProceedToCheckout;
	
	public Delta_FlightResultsPage(WebDriver ldriver) {
		 
		this.driver = ldriver;
		
	}
	
	public void resultSelection()
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='select']")));
		driver.findElements(By.xpath("//button[text()='select']")).get(0).click();
		
	}
	
	public void verifyTripDetails(){
		
		new WebDriverWait(driver,30).until(ExpectedConditions.titleContains("Trip Summary"));
		Assert.assertTrue(bookAtrip.isDisplayed());
		Assert.assertTrue(pricePerpassenger.isDisplayed());
		
	}
	
}
