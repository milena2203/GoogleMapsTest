package constants;

import org.openqa.selenium.By;

public class HomePage {

	public static final String URL="https://www.google.com/maps/";
	public static final By SearchField = By.id("searchboxinput");
	public static final By LayersIcon= By.id("widget-minimap-caption");
	public static final By MenuIcon= By.className("bDDiq");
	public static final By ZoomIn= By.className("widget-zoom-in");
	public static final By ZoomOut= By.className("widget-zoom-out");
	
	//when maps are down
	public static final By NoInternetIcon = By.xpath("/html/body/div[1]/img");
	public static final By TryAgainButton = By.xpath("//*[@id='z5Sio']");
	public static final By TryAgainString = By.cssSelector("#z5Siod");
	
	
	

	public static final By SearchBoxInput = By.id("searchboxinput");
	public static final By DirectionsButton= By.id("hArJGc"); 
	public static final By TravelModeDriving = By.xpath("//*[@id=\"omnibox-directions\"]/div/div[2]/div/div/div/div[2]/button/img");
	public static final By StartPointFieldId= By.xpath("//*[@id='sb_ifc51']/input");
	public static final By EndPointFieldId= By.id("sb_ifc52");
	
	public static String StartPointString = "Budapest, Hungary";
	public static String EndPointString = "Belgrade, Serbia";
	
	public static final By Options = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/button[2]/span[1]");
	public static final By Highways = By.xpath("//*[@id=\"QA0Szd\"]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/label");
	public static final By CloseOptions = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/button[2]/span[2]");
	
	public static final By Route1 = By.xpath("//*[@id='section-directions-trip-0']/div[1]/div[1]/div[1]/div[2]/div");
	public static final By Route2 = By.xpath("//*[@id='section-directions-trip-1']/div[1]/div[1]/div[1]/div[2]/div");
	public static final By Route3 = By.xpath("//*[@id='section-directions-trip-2']/div[1]/div[1]/div[1]/div[2]/div");
	
	
	public static final By Time = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[1]/h1/span[1]/span[1]");
	public static final By Distance = By.xpath("//*[@id='QA0Szd']/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[1]/h1/span[1]/span[2]/span");
	
}