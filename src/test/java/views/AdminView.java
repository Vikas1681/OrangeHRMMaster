package views;

import generic.Pojo;
import pageObjects.AdminPage;

public class AdminView {

	Pojo objPojo;
	AdminPage objAdminPage;
	String strTestData;
	String strTestData1;
	int intTestData;

	public AdminView(Pojo objPojo) {
		this.objPojo = objPojo;
		objAdminPage = new AdminPage(objPojo);
	}

	public String addNewUser() {
		objAdminPage.verifyAdminPageDisplayed();
		objAdminPage.clickAdminPageAddButton();
		strTestData1 = objPojo.getObjExcelHelper().dpString("Username")
				+ objPojo.getObjUtility().generateRandomInt(5000);
		System.out.println(strTestData1);
		if (strTestData1 != null) {
			objAdminPage.enterAdminPageUserName(strTestData1);
		}
		strTestData = objPojo.getObjExcelHelper().dpString("User_Role");
		if (strTestData != null) {
			objAdminPage.selectAdminPageUserRole(strTestData);
		}
		strTestData = objPojo.getObjExcelHelper().dpString("Status");
		if (strTestData != null) {
			objAdminPage.selectAdminPageStatus(strTestData);
		}
		strTestData = objPojo.getObjExcelHelper().dpString("Emp_Name");
		if (strTestData != null) {
			objAdminPage.enterAdminPageEmployeeName(strTestData);
		}

		strTestData = objPojo.getObjExcelHelper().dpString("PASS");
		if (strTestData != null) {
			objAdminPage.enterAdminPagePassword(strTestData);
		}
		strTestData = objPojo.getObjExcelHelper().dpString("PASS");
		if (strTestData != null) {
			objAdminPage.enterAdminPageConfirmPassword(strTestData);
		}

		objAdminPage.clickAdminPageSaveButton();
		return strTestData1;
	}

	public void verifyNewUserAddedSuccessfully(String inpUsername) {
		objAdminPage.verifyAdminPageDisplayed();
		objAdminPage.waitAdminPageSearchBoxToAppear();
		objAdminPage.enterAdminPageSearchByUsername(inpUsername);
		objAdminPage.clickAdminPageSearchButton();
		objAdminPage.verifyAdminPageUserName(inpUsername);
	}

}
