package generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utility.ExcelHelper;
import utility.Utility;

public class BaseTest extends Pojo {

	HashMap<String, String> objHashmap;
	ConfigReader objConfig;
	String currentLine;

	public void setUpEnvironment(String excelFileName) {
		System.out.println("****");
		objConfig = new ConfigReader();
		Properties prop = objConfig.readConfig();
		this.setConfig(objConfig);
		BrowserFactory objBrowserFactory = BrowserFactory.getInstance();
		InitiaseWebDriver objInitiaseWebDriver = new InitiaseWebDriver();
		if (this.getConfig().getPropValue("Execution_Mode").equalsIgnoreCase("remote")) {

			URL url = null;
			try {
				url = new URL(objConfig.getPropValue("REMOTE_URL"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			objBrowserFactory.setDriver(objInitiaseWebDriver.getRemoteDriver(objConfig.getPropValue("BROWSER"), url));
		} else {
			objBrowserFactory.setDriver(objInitiaseWebDriver.getDriver(objConfig.getPropValue("BROWSER")));
		}

		this.setDriver(objBrowserFactory.getDriver());
		this.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(objConfig.getPropValue("URL"));
		this.getDriver().get(objConfig.getPropValue("URL"));
		Utility objUtility = new Utility(this);
		objUtility.setLog();
		this.setObjUtility(objUtility);
		WrapperFunctions objWrapperFunctions = new WrapperFunctions(this);
		this.setWrapperFunctions(objWrapperFunctions);
		ExcelHelper objExcelHelper = new ExcelHelper(this);
		this.setObjExcelHelper(objExcelHelper);
		this.getObjExcelHelper().loadExcelHelper(excelFileName);

	}

	public void loadTestData(String tc_id) {
		objHashmap = this.getObjExcelHelper().loadTestData(tc_id);
	}

	public String dpString(String keyName) {

		return this.getObjExcelHelper().dpString(keyName);

	}

	public void closeDrivers() {
		this.getDriver().close();
	}

	@BeforeTest
	public void dockerComposeUP() {
		System.out.println("Before Test");
	
		objConfig = new ConfigReader();
		Properties prop = objConfig.readConfig();
		this.setConfig(objConfig);
		if (objConfig.getPropValue("Execution_Mode").equalsIgnoreCase("remote")) {

			boolean flag = false;
			try {
				flag = Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\dockerlogs.txt"));
				System.out.println("docker logs file is deleted");
			} catch (IOException e2) {
				System.out.println("Docker File Not deleted, deleting it forcefully");
				// TODO Auto-generated catch block
				e2.printStackTrace();
				File file = new File(System.getProperty("user.dir") + "\\dockerlogs.txt");
				try {
					FileUtils.forceDelete(file);
					System.out.println("docker logs are deleted Forcefully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				System.out.println("dockerComposeUP.bat");
				Runtime.getRuntime().exec("dockerComposeUP.bat");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String dockerLogs = "dockerlogs.txt";
			try {
				Thread.sleep(Duration.ofSeconds(15)); // necessaary for log files
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader objBufferedReader = null;
			try {
				objBufferedReader = new BufferedReader(new FileReader(dockerLogs));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				currentLine = objBufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (currentLine != null) {
				try {
					
					currentLine = objBufferedReader.readLine();
					System.out.println(currentLine);
					if (currentLine.contains("Node has been added")) {
						System.out.println("Docker is up");
						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@AfterTest
	public void dockerComposeDown() {
		System.out.println("Inside After test");
		if (objConfig.getPropValue("Execution_Mode").equalsIgnoreCase("remote")) {
			
			try {
				Runtime.getRuntime().exec("dockerComposeDown.bat");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
