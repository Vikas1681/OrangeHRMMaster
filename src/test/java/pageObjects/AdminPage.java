package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import generic.Pojo;

public class AdminPage {

	Pojo objPojo;
	int testData;

	public AdminPage(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	By hdrAdmin = By.xpath("//h6[text()='Admin']");
	By btnAdd = By.xpath("//button[text()=' Add ']");
	By drpSelectUserRole = By.xpath(
			"//label[text()='User Role']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[text()='-- Select --']");
	By drpStatus = By.xpath(
			"//label[text()='Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[text()='-- Select --']");
	By drpUserRoleListBox = By.xpath("//div[@role='listbox']");
	By inpEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
	By inpUsername = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
	By inpPassword = By.xpath("//input[@type='password']");
	By inpConfirmPassword = By.xpath("//label[text()='Confirm Password']/following::input[@type='password']");
	By btnSave = By.xpath("//button[@type='submit'][text()=' Save ']");
	By hdrSearchBox = By.xpath("//h5[text()='System Users']");
	By inpSearchUsername = By.xpath(
			"//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='Username']/parent::div/following-sibling::div/input");
	By btnSearch = By.xpath("//button[@type='submit'][normalize-space()='Search']");

	public void verifyAdminPageDisplayed() {
		objPojo.getObjUtility().logReporter("verify Admin page displayed",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(hdrAdmin));
	}

	public void clickAdminPageAddButton() {
		objPojo.getObjUtility().logReporter("click on Add button of Admin Page ",
				objPojo.getObjWrapperFunctions().click(btnAdd));
	}

	public void selectAdminPageUserRole(String strUserRole) {
		objPojo.getObjUtility().logReporter("click on --Select-- under User Role",
				objPojo.getObjWrapperFunctions().click(drpSelectUserRole));
		objPojo.getObjUtility().logReporter("wait for list box to appear",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(drpUserRoleListBox));
		if (strUserRole.equalsIgnoreCase("Admin")) {
			By liUserRole = By.xpath("//div[@role='listbox']//div[@role='option']//span[text()='Admin']");
			objPojo.getObjUtility().logReporter("Select Admin from the list",
					objPojo.getObjWrapperFunctions().click(liUserRole));
		}
		if (strUserRole.equalsIgnoreCase("ESS")) {
			By liUserRole = By.xpath("//div[@role='listbox']//div[@role='option']//span[text()='ESS']");
			objPojo.getObjUtility().logReporter("Select ESS from the list",
					objPojo.getObjWrapperFunctions().click(liUserRole));
		}
	}

	public void selectAdminPageStatus(String status) {
		objPojo.getObjUtility().logReporter("click on --Select-- under status",
				objPojo.getObjWrapperFunctions().click(drpStatus));
		objPojo.getObjUtility().logReporter("wait for list box to appear",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(drpUserRoleListBox));
		if (status.equalsIgnoreCase("Enabled")) {
			By liUserRole = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
			objPojo.getObjUtility().logReporter("Select Enabled from the list",
					objPojo.getObjWrapperFunctions().click(liUserRole));
		}
		if (status.equalsIgnoreCase("Disabled")) {
			By liUserRole = By.xpath("//div[@role='listbox']//span[text()='Disabled']");
			objPojo.getObjUtility().logReporter("Select Disabled from the list",
					objPojo.getObjWrapperFunctions().click(liUserRole));
		}
	}

	public void enterAdminPageEmployeeName(String strEmpName) {
		objPojo.getObjUtility().logReporter("enter employee name",
				objPojo.getObjWrapperFunctions().sendKeys(inpEmployeeName, strEmpName));
		By empName = By.xpath("//div[@role='option']//span[text()='" + strEmpName + "']");
		objPojo.getObjWrapperFunctions().waitFor(5);
		objPojo.getObjUtility().logReporter("Sending keyboard keys",
				objPojo.getObjWrapperFunctions().sendKeyboardKeys("DOWN", inpEmployeeName));
		objPojo.getObjUtility().logReporter("Sending keyboard keys",
				objPojo.getObjWrapperFunctions().sendKeyboardKeys("ENTER", inpEmployeeName));

	}

	public void enterAdminPageUserName(String strUserName) {
		System.out.println("@@@@" + strUserName);
		objPojo.getObjUtility().logReporter("enter User name",
				objPojo.getObjWrapperFunctions().sendKeys(inpUsername, strUserName));
	}

	public void enterAdminPagePassword(String strPassword) {
		objPojo.getObjUtility().logReporter("enter Password",
				objPojo.getObjWrapperFunctions().sendKeys(inpPassword, strPassword));
	}

	public void enterAdminPageConfirmPassword(String strPassword) {
		objPojo.getObjUtility().logReporter("Confirm Password",
				objPojo.getObjWrapperFunctions().sendKeys(inpConfirmPassword, strPassword));
	}

	public void clickAdminPageSaveButton() {
		objPojo.getObjUtility().logReporter("click on save button", objPojo.getObjWrapperFunctions().click(btnSave));
	}

	public void enterAdminPageSearchByUsername(String strUserName) {
		objPojo.getObjUtility().logReporter("search by " + strUserName + "",
				objPojo.getObjWrapperFunctions().sendKeys(inpSearchUsername, strUserName));
	}

	public void clickAdminPageSearchButton() {
		objPojo.getObjUtility().logReporter("click on Search button",
				objPojo.getObjWrapperFunctions().click(btnSearch));
	}

	public void verifyAdminPageUserName(String strUsername) {
		By tblUsername = By
				.xpath("//div[@class='oxd-table']//div[@class='oxd-table-body']//div[text()='" + strUsername + "']");
		objPojo.getObjUtility().logReporter("verify new user " + strUsername + " added",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(tblUsername));
	}
	
	public void waitAdminPageSearchBoxToAppear() {
		objPojo.getObjUtility().logReporter("verify Search Box Displayed",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(hdrSearchBox));
	}
}
