package assignment01.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterUser extends BasePage{

	public RegisterUser(WebDriver driver) {
		
    	super(driver);
	}
	
	@FindBy(id ="auth-create-account-link")
	WebElement createNewAccount;
	
	@FindBy(id = "ap_customer_name")
	WebElement custName;

	@FindBy(id ="ap_email")
	WebElement custEmail;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement custPswd;
	
	@FindBy(id = "ap_password_check")
	WebElement checkPswd;
	
	@FindBy(xpath ="//input[@id='continue']")
	WebElement submit;
	
	
	public void createNewAcc() {
		
		wait.until(ExpectedConditions.elementToBeClickable(createNewAccount));
		createNewAccount.click();	
	}
	
	public void enterName(String fullName) {
		
		wait.until(ExpectedConditions.visibilityOf(custName));
		custName.sendKeys(fullName);
	}
	
	public void enterEmail(String email) {
		
		wait.until(ExpectedConditions.visibilityOf(custEmail));
		custEmail.sendKeys(email);
	}
	
	public void enterPswd(String password) {
		
		custPswd.sendKeys(password);
	}
	
	public void reEnterPswd(String rePassword) {
		
		checkPswd.sendKeys(rePassword);
	}
	public void sumbitButton() {
		
		submit.click();
	}
}
