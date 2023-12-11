package assignment01.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplyFilters extends BasePage{
	
	public ApplyFilters(WebDriver driver) {
		
		super(driver);
	}
	
	//brandFilter
	@FindBy(xpath = "//div[@id='brandsRefinements']//descendant::span[contains(text(),'See more')]")
	WebElement seeMoreOption;
	
	@FindBy (xpath = "//li[contains(@id,'p_89')]/span/a")		
	List<WebElement> brands;
	
	//memoryFilter
	@FindBy (xpath = "//li[contains(@id,'p_n_feature_thirty-two_browse-bin')]/span/a")
	List<WebElement> memorySizes;
	
	//priceFilter
	@FindBy(xpath = "//li[contains(@id,'p_36')]/span/a")
	List<WebElement> prices;
	
	//validateFilter
	@FindBy(xpath = "//div[@class='puisg-col-inner']//div[@data-cy='title-recipe']//span")
	List<WebElement> listOfPhones;
	
	public void selectBrand(String brandName) {
		
		seeMoreOption.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(brands));
		scrollDown.executeScript("window.scrollBy(0,200)");	
		for(WebElement brand : brands)
		{
			String bName =brand.getText();
			if(bName.contains(brandName))
			{
	 			brand.click();
				break;
			}	
		}
	}
	
    public void selectMemory(String getMemory) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(memorySizes));
		scrollDown.executeScript("window.scrollBy(0,500)");
		for(int i=0; i< memorySizes.size(); i++)
		{
			String memory = memorySizes.get(i).getText();
			
			if(memory.contains(getMemory))
			{
				memorySizes.get(i).click();
				break;
			}
		}
	}
	
	public void selectPriceRange(String priceRange) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(prices));
		scrollDown.executeScript("window.scrollBy(0,400)");	
		for(WebElement price : prices) 
		{	
			String range = price.getText();
			
			if(range.contains(priceRange))
			{
				price.click();
				break;
			}
		}	
	}
	
	public void validateFilteredList(String brandName) {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfPhones));
		for(WebElement phone : listOfPhones )
		{
			String pName =phone.getText();
			wait.until(ExpectedConditions.textToBePresentInElement(phone, pName));
			assertTrue(pName.contains(brandName), "Phone name: " + pName + " does not contain brand: " + brandName);
		}
}
}
