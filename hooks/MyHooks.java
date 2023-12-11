package assignment01.hooks;

import org.openqa.selenium.WebDriver;

import assignment01.reusableCode.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks { 

	private WebDriver driver;
	
	@Before
	public void before() {
		
		driver = DriverInit.initilizeDriver();
	}
	
	@After
	public void after() {
		
    driver.quit();
	}
}
