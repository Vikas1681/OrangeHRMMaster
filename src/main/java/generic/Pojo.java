package generic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utility.ExcelHelper;
import utility.Utility;

public class Pojo {
	WebDriver driver;
	Utility objUtility;
	WrapperFunctions objWrapperFunctions;
	ExcelHelper objExcelHelper;
	ConfigReader obConfigReader;

	public void setDriver(WebDriver driver) {
		this.driver = driver;

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setObjUtility(Utility objUtility) {
		this.objUtility = objUtility;
	}

	public Utility getObjUtility() {
		return this.objUtility;
	}

	public void setWrapperFunctions(WrapperFunctions objWrapperFunctions) {
		this.objWrapperFunctions = objWrapperFunctions;
	}

	public WrapperFunctions getObjWrapperFunctions() {
		return this.objWrapperFunctions;
	}

	public void setObjExcelHelper(ExcelHelper objExcelHelper) {
		this.objExcelHelper = objExcelHelper;
	}

	public ExcelHelper getObjExcelHelper() {
		return this.objExcelHelper;
	}

	public void setConfig(ConfigReader obConfigReader) {
		this.obConfigReader = obConfigReader;
	}

	public ConfigReader getConfig() {
		return this.obConfigReader;
	}

}
