package actitimegeneric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonMethods {
	public static void enterText(WebElement object, String data) {
		object.sendKeys(data);
	}
	
	public static void click(WebElement object) {
		object.click();
	}
	
	public static void verifyTitle(WebDriver driver, String expTitle) {
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	public static void compareTexts(String actText, String expText) {
		Assert.assertEquals(actText, expText);
	}

}
