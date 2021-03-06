package Pages;

import java.awt.RenderingHints.Key;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Library.Base;

public class Greyhound extends Base {

	public void GoToWebsite() {
		driver.get("https://www.greyhound.com/en");
	}

	public void ClickBookATrip() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement TripBanner = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nav-main\"]/ul/li[1]/a")));
		TripBanner.click();
		WebElement BookNowBttn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"collapseBook\"]/p/a[1]")));
		BookNowBttn.click();
	}

	public void EnterFromBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement FromTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//input[@id=\"fromLocation\" or @class=\"form-control non-dynamic-label ui-autocomplete-input\"]")));
		FromTextBox.sendKeys("Washington");
		Thread.sleep(5000);
		FromTextBox.sendKeys(Keys.ARROW_DOWN);
		FromTextBox.sendKeys(Keys.ENTER);
	}

	public void EntertoBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ToTextBox = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='toLocation']")));
		ToTextBox.sendKeys("New York");
		ToTextBox.sendKeys(Keys.ARROW_DOWN);
		ToTextBox.sendKeys(Keys.ENTER);
	}

	public void DepartOn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement CalenderDate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"datepicker-from\"]")));
		CalenderDate.click();
		Thread.sleep(2500);
		WebElement DatetwentyFour = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")));
		DatetwentyFour.click();
	}

	public void ReturnOn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement CalenderDate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"datepicker-to\"]")));
		CalenderDate.click();
		Thread.sleep(2500);
		WebElement DateThirty = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a")));
		DateThirty.click();
	}

	public void PasssengerCount() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement PassengercntBox = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"fare-search\"]/div[2]/div[1]/div[3]")));
		PassengercntBox.click();
		WebElement ChildrenPlusBttn = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"passenger-panel\"]/ul/li[2]/div[1]/div[2]/button[2]")));
		ChildrenPlusBttn.click();
		Thread.sleep(2500);
		ChildrenPlusBttn.click();

	}
	
	public void ClickOnAllDiscountOption() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		Select DiscountBoxselect = new Select(driver.findElement(By.xpath("//select[@id='ff-travel-discountoptions']")));
		DiscountBoxselect.selectByValue("student");
		Thread.sleep(1000);
		DiscountBoxselect.selectByValue("veteran");
		Thread.sleep(1000);
		DiscountBoxselect.selectByValue("no-discount");
		Thread.sleep(1000);	
	}
	public void EnterPromoCodeThenEraseIt() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		 WebElement PromoCodeBox = driver.findElement(By.xpath("//*[@id=\"ff-travel-promocode\"]"));
		PromoCodeBox.sendKeys("Honey2019");
		Thread.sleep(2000);
		PromoCodeBox.clear();
	}
	public void ClickSearchBttn() {
		driver.findElement(By.xpath("//*[@id=\"fare-search-btn\"]")).click();
	}

	@Test
	public void GreyHoundBus() throws InterruptedException {
		GoToWebsite();
		ClickBookATrip();
		EnterFromBox();
	 EntertoBox();
		DepartOn();
		ReturnOn();
		PasssengerCount();
		//ClickOnAllDiscountOption();
		EnterPromoCodeThenEraseIt();
		ClickSearchBttn();
	}
}