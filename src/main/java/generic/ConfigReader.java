package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	FileInputStream fileInputStream;

	public Properties readConfig() {
		File source = new File("./Configurations/Config.properties");
		try {
			fileInputStream = new FileInputStream(source);
			prop = new Properties();
			prop.load(fileInputStream);
		} catch (FileNotFoundException fne) {
			System.out.println(fne.getMessage());
		} catch (IOException io) {
			io.getMessage();
		}
		return prop;

	}

	public String getPropValue(String propName) {
		this.readConfig();
		return this.prop.getProperty(propName);
	}
//	public static void main(String[] args) {
//		ConfigReader objConfig = new ConfigReader();
//		objConfig.readConfig();
//		System.out.println(objConfig.getPropValue());
//	}

}
