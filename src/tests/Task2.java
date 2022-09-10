package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.HomePage;
import methods.Method;

public class Task2 {
	/*
	The user wants to go from Budapest to Belgrade by car, but he wants to skip the
	highways. Define the longest route from the offered routes. Test should check if
	the “direction” feature works properly in this situation. At the end, test should
	check if distance and time duration are present on the details page.
	*/	
	
		private static WebDriver driver;

		@BeforeClass
		public void createDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_103\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		@Test
		public static void FindRoute() throws InterruptedException {
			Method.goToURL(driver); //1.open Google maps
			Method.typeInEndPoint(driver, HomePage.EndPointString);// 2.enter end point
			Method.clickDirections(driver);// 3.click directions
			Method.typeInStartPoint(driver, HomePage.StartPointString); // 4.enter start point
			Method.clickOptions(driver);// 5. click options
			Method.clickTravelModeDriving(driver); // 6. click Travel Mode Car icon
			Method.avoidHighways(driver); //7.select option Avoid Highways
			Method.chooseLongestRoute(driver); // 8. click longest route,click details
			Method.travelDistance(driver); // read the distance
			Method.travelTime(driver); // read the time

			boolean DistancePresent = driver.findElement(HomePage.Distance).isDisplayed();// actual
			boolean TimePresent = driver.findElement(HomePage.Time).isDisplayed();// actual
			boolean expectedTrue = true;// expected

			SoftAssert sa = new SoftAssert();
			sa.assertEquals(DistancePresent, expectedTrue);
			sa.assertEquals(TimePresent, expectedTrue);
			sa.assertAll();

			System.out.println("Time and distance of the travel route are displayed on the screen");

		}

		@AfterClass
		public void close() throws Exception {
			Thread.sleep(200);
			driver.quit();
		}
}
