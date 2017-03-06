package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	public static String provideDate(int days) throws InterruptedException {
		Thread.sleep(5000);
		SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yyyy"); // set format
																	// for date
																	// as it
																	// comes
																	// after
																	// selection
																	// of date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); // Now using present date.
		cal.add(Calendar.DATE, days); // Adding no. of days passed as argument
		return obj.format(cal.getTime());
	}

	public static void NoOfFlightResults(WebDriver driver) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("Flight Results"));

		List<WebElement> totalFlights = driver.findElements(
				By.xpath("//a[text()='Main Cabin' and @class='tblHeadBigtext lnkCabinName']/following::table"));
		for (int i = 0; i < totalFlights.size() - 1; i++) {
			Assert.assertTrue(totalFlights.get(i).isDisplayed());

		}

	}

	public static void NoOfHotelResults(WebDriver driver) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("Hotel Search Results"));

		List<WebElement> hotelsList = driver.findElements(By.xpath("//*[@id='hotelList']/li"));
		for (int i = 0; i < hotelsList.size() - 1; i++) {
			Assert.assertTrue(hotelsList.get(i).isDisplayed());

		}

	}

}// .//*[@id='hotelList']/li
