package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage{

	private WebDriver driver;

	public SignUpPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	private WebElement nameInputField;
	@FindBy(css = "input[name='email']")
	private WebElement emailInputField;
	@FindBy(css = "input[name='password']")
	private WebElement passwordInputField;
	@FindBy(css = "input[name='confirm-password']")
	private WebElement confirmPasswordInputField;
	@FindBy(css = "input[name='toc']")
	private WebElement acceptTermsCheckbox;
	@FindBy(css = "input.form-check-input.font-weight-light")
	private WebElement subscribeForNewsletterCheckbox;
	@FindBy(css = "button.btn.btn-primary")
	private WebElement signUpButton;

	public void fillSignUpFields(String name){
		nameInputField.sendKeys(name);
	}



}
