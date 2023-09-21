package views;

import generic.Pojo;
import pageObjects.LoginPage;

public class LoginView {

	Pojo objPojo;
	LoginPage objLoginPage;

	public LoginView(Pojo objPojo) {
		this.objPojo = objPojo;
		this.objLoginPage = new LoginPage(objPojo);
	}

	public void doLoginWithValidCredentials() {
		objLoginPage.verifyLoginPageDisplayed();
		if (objPojo.getObjExcelHelper().dpString("USERNAME") != null) {
			objLoginPage.enterLoginPageUsername("Admin");
		}
		if (objPojo.getObjExcelHelper().dpString("PASS") != null) {
			objLoginPage.enterLoginPagePassword("admin123");
		}

		objLoginPage.clickLoginPageSubmitButton();
		objLoginPage.verifyDashboardPageDisplayed();
	}

}
