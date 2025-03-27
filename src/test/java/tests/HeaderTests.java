package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;

public class HeaderTests extends BaseTest {

	@BeforeMethod
	public void precondition(){
		setUp();
	}

	@AfterMethod
	public void driverClose(){
		quit();
	}

	@Test
	public void checkingDisplayingAllHeaderElements () {
		HeaderPage header = new HeaderPage(driver);
		Assert.assertTrue(header.isElementDisplay(header.homeLink), "The element " + header.homeLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.aboutLink), "The element " + header.aboutLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.howItWorksLink), "The element " + header.howItWorksLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.contactLink), "The element " + header.contactLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.tryForFreeLink), "The element " + header.tryForFreeLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.pricingLink), "The element " + header.pricingLink + " ISN'T displayed");
		Assert.assertTrue(header.isElementDisplay(header.signInLink), "The element " + header.signInLink + " ISN'T displayed");

	}

}
