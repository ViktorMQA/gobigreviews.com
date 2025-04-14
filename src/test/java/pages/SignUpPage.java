package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
		waitPageLoaded(By.xpath(signUpPageSelector));
	}

	String signUpPageSelector = "//h1[contains(., 'Sign Up')]";

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

	public void fillNameField(String name){
		nameInputField.sendKeys(name);
	}

	public void fillEmailField(String email){
		emailInputField.sendKeys(email);
	}

	public void fillPassField(String pass){
		passwordInputField.sendKeys(pass);
	}

	public void fillConfirmPassField(String confirmPass){
		confirmPasswordInputField.sendKeys(confirmPass);
	}

	public void selectTermsCheckbox(){
		acceptTermsCheckbox.click();;
	}

	public SignUpPage fillAllRegistrationFields(String name, String email, String pass, String confirmPass){
		fillNameField(name);
		fillEmailField(email);
		fillPassField(pass);
		fillConfirmPassField(confirmPass);
		selectTermsCheckbox();
		return this;
	}

	public SignUpPage clickSignUpButton(){
		signUpButton.click();
		return this;
	}

	public HeaderPage doRegistration(WebDriver driver, String name, String email, String pass, String confirmPass){
		fillAllRegistrationFields(name, email, pass, confirmPass)
				.clickSignUpButton();
		return new HeaderPage(driver);
	}

	public boolean isNameFieldRequired(String email, String pass, String confirmPass){
		fillEmailField(email);
		fillPassField(pass);
		fillConfirmPassField(confirmPass);
		selectTermsCheckbox();
		return signUpButton.isEnabled();
	}

	public boolean isEmailFieldRequired(String name, String pass, String confirmPass){
		fillNameField(name);
		fillPassField(pass);
		fillConfirmPassField(confirmPass);
		selectTermsCheckbox();
		return signUpButton.isEnabled();
	}

	public boolean isPassFieldRequired(String name, String email,String confirmPass){
		fillNameField(name);
		fillEmailField(email);
		fillConfirmPassField(confirmPass);
		selectTermsCheckbox();
		return signUpButton.isEnabled();
	}

//    @Step("Check if the confirm field is required")
	public boolean isConfirmPassFieldRequired(String name, String email, String pass){
		fillNameField(name);
		fillEmailField(email);
		fillPassField(pass);
		selectTermsCheckbox();
		return signUpButton.isEnabled();
	}

	public boolean isTermsCheckboxRequired(String name, String email, String pass, String confirmPass){
		fillNameField(name);
		fillEmailField(email);
		fillPassField(pass);
		fillConfirmPassField(confirmPass);
		return signUpButton.isEnabled();
	}

	public void clearForm(){
		nameInputField.clear();
		emailInputField.clear();
		passwordInputField.clear();
		confirmPasswordInputField.clear();
		if (acceptTermsCheckbox.isSelected()){
			acceptTermsCheckbox.click();
		}
	}

}
