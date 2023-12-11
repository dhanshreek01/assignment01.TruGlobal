package assignment01.reusableCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInit {

	private static WebDriver driver;
	
	public static WebDriver initilizeDriver() {
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
