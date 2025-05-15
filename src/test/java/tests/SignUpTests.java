package tests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import java.io.IOException;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HeaderPage;
import pages.SignInPage;
import pages.SignUpPage;
import utils.DataGenerator;

@Epic("User registration")
@Feature("Registration Page")
public class SignUpTests extends BaseTest {

	private String name;
	private String email;
	private String email2 = "email@email.com";
	private String password;
	private String confirmPassword;



	@BeforeMethod
	@Step("Setup test precondition")
	public void precondition() throws IOException {
		setUp();
		HeaderPage header = new HeaderPage(driver);
		SignInPage signIn = header.getSignInPage(driver);
		SignUpPage signUp = signIn.getSignUpPage(driver);


		JSONObject jsonObject = signUp.getJsonObject("src/test/resources/signUpData.json");
		JSONObject signUpData = jsonObject.getJSONObject("signUp");
		name = signUpData.getString("name");
		email = signUpData.getString("email");
		password = signUpData.getString("password");
		confirmPassword = signUpData.getString("confirmPassword");


	}


	@AfterMethod(alwaysRun = true)
	@Step("Clear test in the end")
	public void driverClose(){
		quit();
	}


	@Test(description = "checking successful registration")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Implement registration form")
	public void checkingSignUpRegistration() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		SignUpPage signUp = new SignUpPage(driver);
		String generatedEmail = email + "+" + signUp.generateFiveRandomDigits() + "@email.net";
		softAssert.assertTrue(signUp.doRegistration(driver, name, generatedEmail,
				password, confirmPassword).isRegistrationSuccessful(), "The registration is unsuccessful. profile element ISN'T visible after registration"
		);
		System.out.println(name + " " + generatedEmail + " " + password + " " + confirmPassword);
		softAssert.assertAll();
	}

	@Test(description = "checking required fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Implement registration form")
	public void checkingSignUpFieldsIsRequired() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		SignUpPage signUp = new SignUpPage(driver);
		softAssert.assertFalse(signUp.isNameFieldRequired(email2, password, confirmPassword),
				"The NAME field ISN'T required because the sign Up button is enabled");
		signUp.reloadPage(driver);
		softAssert.assertFalse(signUp.isEmailFieldRequired(name,	password, confirmPassword),
				"The EMAIL field ISN'T required because the sign Up button is enabled");
		signUp.reloadPage(driver);
		softAssert.assertFalse(signUp.isPassFieldRequired(name, email2, confirmPassword),
				"The PASS field ISN'T required because the sign Up button is enabled");
		signUp.reloadPage(driver);
			softAssert.assertFalse(signUp.isConfirmPassFieldRequired(name, email2, password),
				"The CONFIRM PASS field ISN'T required because the sign Up button is enabled");
		signUp.reloadPage(driver);
		softAssert.assertFalse(signUp.isTermsCheckboxRequired(name, email2, password, confirmPassword),
				"The TERMS checkbox field ISN'T required because the sign Up button is enabled");
		softAssert.assertAll();
	}

}
