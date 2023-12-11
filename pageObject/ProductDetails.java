package assignment01.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetails extends BasePage{

	public ProductDetails(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "productTitle")
	WebElement prodTitle; 

	@FindBy(xpath = "//span[@class='a-price-whole']")
	WebElement price;
	
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	@FindBy(xpath = "//span[@id='sw-gtc']//a[contains(text(),'Go to Cart')]")
	WebElement goToCartButton;
	
	public String getProductName() {
	
		wait.until(ExpectedConditions.visibilityOf(prodTitle));
		String	prodName = prodTitle.getText();
		return prodName;
		
	}
	
	public String getProductPrice() {
	 	
		wait.until(ExpectedConditions.visibilityOf(price));
		String priceDetails = price.getText();
		return priceDetails;
	}
	
	public void addToCart() {
		
		addToCartButton.click();
	}
	
	public void goToCart() {
		
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		goToCartButton.click();
	}
	
}
