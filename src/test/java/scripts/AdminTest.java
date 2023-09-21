package scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generic.BaseTest;
import views.AdminView;
import views.CommonView;
import views.LoginView;

public class AdminTest extends BaseTest {

	LoginView objLoginView;
	CommonView objCommonView;
	AdminView objAdminView;

	public void initialseViewsAndPages() {
		objLoginView = new LoginView(this);
		objCommonView = new CommonView(this);
		objAdminView = new AdminView(this);
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
	public void TC_01_Admin_CreateNewUser() {
		this.loadTestData("100");
		objLoginView.doLoginWithValidCredentials();
		objCommonView.commonGoToAdminPage();
		String strUsername = objAdminView.addNewUser();
		objAdminView.verifyNewUserAddedSuccessfully(strUsername);

	}
	
	

}
