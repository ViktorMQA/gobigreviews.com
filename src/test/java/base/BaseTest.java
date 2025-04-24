package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	protected WebDriver driver;
	private Dotenv dotenv;


	public  BaseTest(){
		// налаштовуємо роботу з середовищами
		String env = System.getProperty("ENV", "stage");
		dotenv = Dotenv.configure()
				.filename(".env." + env)
				.ignoreIfMissing()
				.load();
	}




	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		this.driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://gobigreviews.com/");

		String browser = dotenv.get("BROWSER", "chrome");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();

		String baseUrl = dotenv.get("BASE_URL");
		if (baseUrl == null) {
			throw new RuntimeException("BASE_URL is not defined in .env." + System.getProperty("ENV", "stage"));
		}
		driver.get(baseUrl);

	}

	public void quit (){

		if (driver != null) {
			driver.quit();
		}

	}

}
