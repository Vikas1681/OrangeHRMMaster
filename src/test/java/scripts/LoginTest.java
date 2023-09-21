package scripts;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generic.BaseTest;
import views.LoginView;

public class LoginTest extends BaseTest {

	LoginView objLoginView;

	public void initialseViewsAndPages() {
		objLoginView = new LoginView(this);
	}

	@BeforeClass
	public void initialiseSetup() {
		this.setUpEnvironment("Test");
		this.initialseViewsAndPages();
	}

	@AfterClass
	public void setupDown() {
		this.closeDrivers();
	}

	@Test
	public void TC_01_LoginTest() throws InterruptedException {
		loadTestData("100");
		Thread.sleep(Duration.ofSeconds(15));
		objLoginView.doLoginWithValidCredentials();
	}

}
