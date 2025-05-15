package pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;
//import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@Slf4j
public class BasePage {

	private WebDriver driver;

	public BasePage (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementDisplay(WebElement element){
		return element.isDisplayed();
	}

	public JSONObject getJsonObject(String path) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(path)));
		return new JSONObject(content);

	}

	public String generateFiveRandomDigits(){
		Random random = new Random();
		StringBuilder digits = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			digits.append(random.nextInt(10)); // Генерує число від 0 до 9
		}
		return digits.toString();
	}

	public boolean isElementVisible(By by){
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element.isDisplayed();
		} catch (RuntimeException e) {
			return false;
		}

	}

	public void waitPageLoaded(By by){
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//			log.info("The page with selector {} is loaded", by.toString());
		} catch (RuntimeException e) {
			throw new RuntimeException(String.format("The page with %s selector DIDN'T loaded during %s seconds timeout", by, 10));
		}

	}

	public void reloadPage(WebDriver driver){
		driver.navigate().refresh();
	}


	public void checkElementDisplayed(WebElement element) {
		if (!element.isDisplayed()) {
			throw new AssertionError("Element is not displayed!");
		}
	}

	public void checkElementClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			throw new AssertionError("Element is not clickable!");
		}
	}

	public void checkElementText(WebElement element, String expectedText) {
		String actualText = element.getText().trim();
		if (!actualText.equals(expectedText.trim())) {
			throw new AssertionError("Text mismatch! Expected: '" + expectedText + "', but was: '" + actualText + "'");
		}
	}

    // screen shot
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	// deep dive TestNG





}
