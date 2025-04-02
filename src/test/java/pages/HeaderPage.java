package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage{

	private WebDriver driver;
	public HeaderPage (WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitPageLoaded(By.cssSelector(hederPageSelector));
	}

	String hederPageSelector = "header.foxapp-header";

	@FindBy(css = "#main_menu a[href='#slide']")
	public WebElement homeLink;
	@FindBy(css = "#main_menu a[href='#about']")
	public WebElement aboutLink;
	@FindBy (css = "#main_menu a[href='#main_features']")
	public WebElement howItWorksLink;
	@FindBy (css = "#main_menu a[href='#prices']")
	public WebElement pricingLink;
	@FindBy (css = "#main_menu a[href='#git_in_touch']")
	public WebElement contactLink;
	@FindBy (css = "#main_menu a[href='/register']")
	public WebElement tryForFreeLink;
	@FindBy (css = "#main_menu a[href='/login']")
	public WebElement signInLink;
	@FindBy(css = "button.btn.btn-user")
	public WebElement profileButton;

	public SignInPage getSignInPage(WebDriver driver){
		signInLink.click();
		return new SignInPage(driver);
	}

	public boolean isRegistrationSuccessful(){
		return profileButton.isDisplayed();
	}





}
