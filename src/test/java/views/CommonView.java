package views;

import generic.Pojo;
import pageObjects.AdminPage;
import pageObjects.HomePage;

public class CommonView {

	Pojo objPojo;
	HomePage objHomePage;
	AdminPage objAdminPage;

	public CommonView(Pojo objPojo) {
		this.objPojo = objPojo;
		objHomePage = new HomePage(objPojo);
		objAdminPage = new AdminPage(objPojo);
	}

	public void commonGoToAdminPage() {
		objHomePage.clickLHSLinks("Admin");
		objAdminPage.verifyAdminPageDisplayed();
	}

}
