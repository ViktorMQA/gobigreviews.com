package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

	private WebDriver driver;

	public SignInPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitPageLoaded(By.xpath(signInPageSelector));

	}

	String signInPageSelector = "//h1[contains(., 'Sign In')]";

	@FindBy(css = ".link-primary.fw-semibold")
	private WebElement signUpLink;


	public SignUpPage getSignUpPage(WebDriver driver){
		signUpLink.click();
		return new SignUpPage(driver);
	}

}
