package utility;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import generic.Pojo;

public class Utility {

	Pojo objPojo;
	Logger log;

	public Utility(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public void setLog() {
		log = Logger.getLogger(Utility.class);
	}

	public void logReporter(String step, boolean result) {
		Assert.assertTrue(result);
		log.info(step);
	}

	public int generateRandomInt(int size) {
		Random rand = new Random();
		return rand.nextInt(size);

	}

}
