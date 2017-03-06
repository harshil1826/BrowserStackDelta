package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Delta_HotelResultsPage 
{

	
	WebDriver driver;
	
	public Delta_HotelResultsPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//a[text()='No, thanks']") @CacheLookup 
	WebElement feedBackPopUp;
	
	@FindBy(name="passwd") WebElement password;

	@FindBy(xpath="//input[@value='Sign In']") WebElement signUpButton;
	
	
	By signout= By.xpath("//div[@class='pre-header']//a[text()='Sign Out']");
	
	
	public void popUpHanding()
	{
		
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='No, thanks']")));
			
			feedBackPopUp.click();
		
		} catch (Exception e) {
			
		}
	
	}
	
	public void verifySignOutLink()
	{
		
	}
	
	
}
