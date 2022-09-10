package methods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.HomePage;

public class Method {

	private static final String Actions = null;

	// 1. open Google maps
	public static void goToURL(WebDriver driver) {
		driver.get(HomePage.URL);
		driver.manage().window().maximize();
	}

	// 2.type in end point
	public static void typeInEndPoint(WebDriver driver, String EndPoint) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.SearchBoxInput));
		driver.findElement(HomePage.SearchBoxInput).clear();
		driver.findElement(HomePage.SearchBoxInput).sendKeys(EndPoint);
	}

	// 3.click directions
	public static void clickDirections(WebDriver driver) {
		WebElement DirectionDugme = driver.findElement(HomePage.DirectionsButton);
		DirectionDugme.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(DirectionDugme));

	}

	//4.type in start point
	public static void typeInStartPoint(WebDriver driver, String StartPoint) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.StartPointFieldId));
		driver.findElement(HomePage.StartPointFieldId).clear();
		driver.findElement(HomePage.StartPointFieldId).sendKeys(StartPoint, Keys.ENTER);
	}

	// 5. click options
	public static void clickOptions(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.Options));
		driver.findElement(HomePage.Options).click();
	}

	// 6.click Travel Mode Car icon

	public static void clickTravelModeDriving(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div/div[2]/button/img")));
		WebElement TravelModeDriving = driver.findElement(HomePage.TravelModeDriving);
		TravelModeDriving.click();

	}

	// 7.choose avoid highways
	public static void avoidHighways(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.Highways));
		WebElement HighWaysCheckbox = driver.findElement(HomePage.Highways);

		boolean selektovano = driver.findElement(HomePage.Highways).isSelected();
		if (selektovano = true) {
			HighWaysCheckbox.click();
		} else {
		}
		WebElement CloseOptions = driver.findElement(HomePage.CloseOptions);
		CloseOptions.click();

	}

	// removing " km" from string
	public static String removeKm(String str, int n) {
		return str.substring(0, str.length() - n);
	}

	// find the largest number
	public static int getLargest(int[] a, int total) {

		int temp = a[0];
		for (int i = 0; i < total; i++) {
			if (a[i] > temp) {
				temp = a[i];
			}
		}
		return temp;
	}

	// 8.choose longest route,click details
	public static void chooseLongestRoute(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@id,'section-directions-trip')]")));

		// reading route1 length as string, parsing it into int
		WebElement Route1 = driver.findElement(HomePage.Route1);
		Actions actions = new Actions(driver);
		actions.moveToElement(Route1).perform();
		String route1 = Route1.getText();
		String r1 = removeKm(route1, 3);
		int route1number = Integer.parseInt(r1);

		// reading route2 length as string, parsing it into int
		WebElement Route2 = driver.findElement(HomePage.Route2);
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(Route2);
		actions2.perform();
		String route2 = Route2.getText();
		String r2 = removeKm(route2, 3);
		int route2number = Integer.parseInt(r2);

		// reading route3 length as string, parsing it into int
		WebElement Route3 = driver.findElement(HomePage.Route3);
		Actions actions3 = new Actions(driver);
		actions3.moveToElement(Route3);
		actions3.perform();
		String route3 = Route3.getText();
		String r3 = removeKm(route3, 3);
		int route3number = Integer.parseInt(r3);

		// make a list from routes length
		int a[] = { route1number, route2number, route3number };
		int total = a.length;

		// find longest route
		int temp = (int) getLargest(a, total);

		// click on longest route, then click on details
		if (temp == route2number) {
			WebElement Route2a = driver
					.findElement(By.xpath("//*[@id='section-directions-trip-1']/div[1]/div[1]/div[1]/div[2]/div"));
			Route2a.click();
			Robot robot;
			try {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Robot robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_DOWN);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			WebElement n = driver.findElement(By.xpath("//*[contains(@id,'section-directions-trip-details')]"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", n);
		}
		if (temp == route1number) {
			WebElement Route1a = driver
					.findElement(By.xpath("//*[@id='section-directions-trip-0']/div[1]/div[1]/div[1]/div[2]/div"));
			Route1a.click();
			Robot robot;
			try {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Robot robot2 = new Robot();
				robot2.keyPress(KeyEvent.VK_DOWN);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			WebElement l = driver.findElement(By.xpath("//*[contains(@id,'section-directions-trip-details')]"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", l);

		} else {
			WebElement Route3a = driver
					.findElement(By.xpath("//*[@id='section-directions-trip-2']/div[1]/div[1]/div[1]/div[2]/div"));
			Route3a.click();
			Robot robot;
			try {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Robot robot3 = new Robot();
				robot3.keyPress(KeyEvent.VK_DOWN);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			WebElement m = driver.findElement(By.xpath("//*[contains(@id,'section-directions-trip-details-msg-2')]"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", m);
		}

	}

	// read travelDistance
	public static void travelDistance(WebDriver driver) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement Distance = driver.findElement(HomePage.Distance);
		Actions actions = new Actions(driver);
		actions.moveToElement(Distance).perform();
		String distance = Distance.getText();
		String distanceNumberAsString = removeKm(distance, 3);
		int distanceNumber = Integer.parseInt(distanceNumberAsString);
		// System.out.println(distanceNumber);

	}

	// read travelTime
	public static void travelTime(WebDriver driver) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement Time = driver.findElement(HomePage.Time);
		Actions actions = new Actions(driver);
		actions.moveToElement(Time).perform();
		String travelTime = Time.getText();
		// System.out.println(travelTime);
	}

}

