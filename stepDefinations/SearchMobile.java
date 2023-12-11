package assignment01.stepDefinations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import assignment01.pageObject.ApplyFilters;
import assignment01.pageObject.BasePage;
import assignment01.pageObject.CartPage;
import assignment01.pageObject.ProductDetails;
import assignment01.pageObject.RegisterUser;
import assignment01.pageObject.SearchPage;
import assignment01.reusableCode.DriverInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchMobile {

	WebDriver driver;
	BasePage basepage;
	SearchPage Search;
	ProductDetails details;
	CartPage cart;
	RegisterUser register;
	ApplyFilters apply;
	
	@Given("User navigate to website")
	public void user_navigate_to_the_amazon_website() {
	    
	    driver= DriverInit.getDriver();
	    basepage= new BasePage(driver) ;
	    basepage.openUrl("https://www.amazon.com/");
	}

	@When("User searches for {string}")
	public void user_searches_for(String productName) {
		 
		 Search = new SearchPage(driver); 
		 Search.searchphone(productName);
	}

	@And("User selects an iPhone from the search results")
	public void user_selects_an_i_phone_from_the_search_results() {
		
	    Search.selectIphoneNum();
	}

	@And("User goes to the product details page And adds the product to the cart")
	public void user_goes_to_the_product_details_page(){
	   
	 details = new ProductDetails(driver); 
	 
	 String proName =details.getProductName();
	 System.out.println(proName);
	 String proPrice =details.getProductPrice();
	 System.out.println(proPrice);
	 
	 details.addToCart();
	 details.goToCart(); 
	}

	@Then("User verifies the product, stores the price And procced to checkout")
	public void User_verifies_the_product_stores_the_price_And_procced_to_checkout() {

		cart = new CartPage(driver);
		
		String actulProName=
		driver.findElement(By.xpath("//li[contains(@class,'a-spacing-mini sc-item-product-title-cont')]")).getText();
        assertEquals(actulProName, cart.getProdTitle());
	    
		System.out.println("price in variable >> 7");
		cart.getFinalPrice();
		
		System.out.println("price in variable >> 8");
		cart.proccedToCheckOut();

	}
		@Then("register the user")
		public void register_the_user() {
		  
			System.out.println("User registered");
			
			register = new RegisterUser(driver);
			
			register.createNewAcc();
			register.enterName("Dhanshree Kokate");
			register.enterEmail("dhanshree@cucumber.com");
			register.enterPswd("Happy@1234");
			register.reEnterPswd("Happy@1234");
			
			register.sumbitButton();
			
	      }
		
		//**************************************
		
		@And("User applies filters for {string}, {string} and {string}")
		public void user_applies_filters_for_and(String brand, String memory, String price ) {
		    
			System.out.println("filetr>>");
			
			apply = new ApplyFilters(driver);
			
			apply.selectBrand("Google");
			apply.selectMemory("64");
			apply.selectPriceRange("150");
				
		}
		@Then("User validates the filtered phone list")
		public void user_validates_the_filtered_phone_list() {
		  
			System.out.println("validate>>");
			
			apply = new ApplyFilters(driver);
			apply.validateFilteredList("Google");
 		}
}

