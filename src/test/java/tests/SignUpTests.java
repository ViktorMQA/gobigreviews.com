package tests;

import base.BaseTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTests extends BaseTest {

	private String name;
	private String name2 = "jgjgghghg";

	private String email;
	private String password;
	private String confirmPassword;

	@BeforeMethod
	public void precondition() throws IOException {
		setUp();
		HeaderPage header = new HeaderPage(driver);
		SignInPage signIn = header.getSignInPage();
		SignUpPage signUp = signIn.getSignUpPage();

		JSONObject jsonObject = signUp.getJsonObject("src/test/resources/signUpData.json");
		JSONObject signUpData = jsonObject.getJSONObject("signUp");
		name = signUpData.getString("name");
		email = signUpData.getString("email");
		password = signUpData.getString("password");
		confirmPassword = signUpData.getString("confirmPassword");

		System.out.println(name + " " + email + " " + password + " " + confirmPassword);

	}

	@AfterClass
	public void driverClose(){
		quit();
	}

	@Test
	public void checkingSignUp() throws InterruptedException {
		SignUpPage signUp = new SignUpPage(driver);
		signUp.fillSignUpFields(name);
		//Thread.sleep(3000);

//		System.out.println(name + " " + email + " " + password + " " + confirmPassword+ "test");
	}




}
