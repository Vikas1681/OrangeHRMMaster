package pageObjects;

import org.openqa.selenium.By;

import generic.Pojo;

public class HomePage {

	Pojo objPojo;

	public HomePage(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public void clickLHSLinks(String strLinkName) {
		By lnkLHS = By.xpath("//span[text()='" + strLinkName + "']");
		objPojo.getObjUtility().logReporter("click on " + strLinkName + " link",
				objPojo.getObjWrapperFunctions().click(lnkLHS));
	}

}
