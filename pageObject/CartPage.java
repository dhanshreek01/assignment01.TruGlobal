package assignment01.pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[contains(@class,'a-spacing-mini sc-item-product-title-cont')]")
	WebElement prodTitleInCart;
	
	@FindBy(xpath = "//div[@class='sc-badge-price-to-pay']")
	WebElement finalPrice;
	
	@FindBy(xpath ="//input[@name='proceedToRetailCheckout']")
	WebElement checkOutButton;
	
	public String getProdTitle() { 
	 	
		String titleOfProdInCart =
		wait.until(ExpectedConditions.visibilityOf(prodTitleInCart)).getText();
		return titleOfProdInCart;
	}
	
	public void verifyProductTitle() {
		
	String actulProName=
	driver.findElement(By.xpath("//li[contains(@class,'a-spacing-mini sc-item-product-title-cont')]")).getText();
    assertEquals(actulProName, getProdTitle());
    
	}
	
	public String getFinalPrice() {
		
		//wait.until(ExpectedConditions.visibilityOf(finalPrice));
		String finalPriceOfProduct = finalPrice.getText();
		return finalPriceOfProduct;
	}
	
	public void proccedToCheckOut() {
		
		checkOutButton.click();
	}
}
