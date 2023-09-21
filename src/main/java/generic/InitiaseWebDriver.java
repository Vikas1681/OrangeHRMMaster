package generic;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InitiaseWebDriver {

	public WebDriver getDriver(String strDriverName) {

		WebDriver driver = null;

		if (strDriverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vikas\\eclipse-workspace\\ORANGEHRM\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
		} else if (strDriverName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

		return driver;

	}

	public WebDriver getRemoteDriver(String strDriverName, URL URL) {

		WebDriver driver = null;

		if (strDriverName.equalsIgnoreCase("chrome")) {
			try {
				Runtime.getRuntime().exec("dockerRestartChrome.bat");
				Thread.sleep(Duration.ofSeconds(5));
			} catch (IOException|InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\vikas\\eclipse-workspace\\ORANGEHRM\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			System.out.println(URL);
			driver = new RemoteWebDriver(URL, options);
			System.out.println(driver);
			driver.manage().window().maximize();
		} else if (strDriverName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

		return driver;

	}

}
