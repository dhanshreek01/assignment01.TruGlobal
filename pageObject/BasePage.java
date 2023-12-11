package assignment01.pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor scrollDown;
	 
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		this.wait =  new WebDriverWait(driver,Duration.ofSeconds(20));
		this.scrollDown = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void openUrl(String Url) {
		
		driver.get(Url);
	}


}
