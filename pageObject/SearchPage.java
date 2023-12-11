package assignment01.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
	 	super(driver);
		
	}
	
	@FindBy(id ="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement submitButton;
	
	@FindBy(xpath ="//span[contains(text(),'Apple iPhone SE (64GB)')]")
	WebElement selectIphone; 
	
	public void searchphone(String phone) {
		
		searchBox.sendKeys(phone);
		submitButton.click();
	}
	
	public void selectIphoneNum() {
        
		scrollDown.executeScript("window.scrollBy(0,400)");	
		wait.until(ExpectedConditions.elementToBeClickable(selectIphone));
		selectIphone.click();
	
		
		
	}
}
