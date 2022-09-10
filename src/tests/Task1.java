package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.HomePage;
import methods.Method;

public class Task1 { //The first step in auto test should be fast checking if maps.google.com is up
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_103\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	public static void ElementsPresentWhenMapsAreUp() {
		Method.goToURL(driver);
		boolean searchFieldEnabled = driver.findElement(HomePage.SearchField).isEnabled(); // actual
		boolean searchFieldDisplayed = driver.findElement(HomePage.SearchField).isDisplayed();// actual
		boolean expectedTrue = true;// expected

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(searchFieldEnabled, expectedTrue);
		sa.assertEquals(searchFieldDisplayed, expectedTrue);
		sa.assertAll();

		System.out.println("Google Maps is up");
	}

	@Test (priority=2)
	public static void ElementsPresentWhenMapsAreDown() {
		Method.goToURL(driver);
		try {
			WebElement TryAgain = driver.findElement(HomePage.TryAgainButton);
			System.out.println("No interenet connection, please try again");
		} catch (NoSuchElementException ex) {
			System.out.println("Google Maps are not down");
		}

	}

	@AfterClass
	public void close() throws Exception {
		Thread.sleep(200);
		driver.quit();
	}
}
