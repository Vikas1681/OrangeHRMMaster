package generic;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

	// Singleton Design Pattern
	private static BrowserFactory instance = new BrowserFactory();

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		return instance;

	}

	// factory Design pattern
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void setDriver(WebDriver strDriverName) {
		driver.set(strDriverName);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
