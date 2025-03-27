package pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
