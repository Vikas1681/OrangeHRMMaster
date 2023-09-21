package pageObjects;

import org.openqa.selenium.By;

import generic.Pojo;

public class LoginPage {

	Pojo objPojo;

	public LoginPage(Pojo objPojo) {
		this.objPojo = objPojo;

	}

	// locators
	By header = By.xpath("//div[@class='orangehrm-login-branding']");
	By inpUsername = By.xpath("//input[@name='username']");
	By inpPassword = By.xpath("//input[@name='password']");
	By btnSubmit = By.xpath("//button[@type='submit']");
	By hdrDashboard = By.xpath("//h6[text()='Dashboard']");

	public void verifyLoginPageDisplayed() {
		objPojo.getObjUtility().logReporter("verify Login Page displayed",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(header));
	}

	public void enterLoginPageUsername(String strUsername) { 
		objPojo.getObjUtility().logReporter("entering username " + strUsername + "",
				objPojo.getObjWrapperFunctions().sendKeys(inpUsername, strUsername));
	}

	public void enterLoginPagePassword(String strPassword) {
		objPojo.getObjUtility().logReporter("entering strPassword " + strPassword + "",
				objPojo.getObjWrapperFunctions().sendKeys(inpPassword, strPassword));
	}

	public void clickLoginPageSubmitButton() {
		objPojo.getObjUtility().logReporter("click on submit button",
				objPojo.getObjWrapperFunctions().click(btnSubmit));
	}

	public void verifyDashboardPageDisplayed() {
		objPojo.getObjUtility().logReporter("verify Dashboard Page displayed",
				objPojo.getObjWrapperFunctions().verifyElementDisplayed(hdrDashboard));

	}

}
