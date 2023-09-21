package generic;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {
	Pojo objPojo;
	WebElement element;

	public WrapperFunctions(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public boolean click(By locator) {
		try {
			try {
				element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			element.click();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickUsingActionClass(By locator) {
		try {
			try {
				element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			Actions objActions = new Actions(objPojo.getDriver());
			objActions.moveToElement(element).click().perform();
//			element.click();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sendKeys(By locator, String textToEnter) {

		try {
			try {
				element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			element.sendKeys(textToEnter);
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WebDriverWait getExplicitWait() {
		WebDriverWait wait = new WebDriverWait(objPojo.getDriver(), 15);
		return wait;
	}

	public boolean verifyElementDisplayed(By locator) {
		try {
			element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void waitAfterEachClick() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitFor(int time) {
		try {
			Thread.sleep(Duration.ofSeconds(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean sendKeyboardKeys(String strKeyName, By locator) {

		try {
			try {
				element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));

			} catch (NoSuchElementException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

			if (strKeyName.equalsIgnoreCase("DOWN")) {

				element.sendKeys(Keys.DOWN);
			}
			if (strKeyName.equalsIgnoreCase("ENTER")) {

				element.sendKeys(Keys.ENTER);
			}
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean verifyContentInTable(By locator) {
		try {
			element = this.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
