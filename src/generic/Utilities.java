package generic;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Utilities {
	
	// This method is to fetch the value from the config.properties file.
	public static String getPropertyValue(String path, String key) {
		String propVal="";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			propVal = p.getProperty(key); 
		}
		catch(Exception e) {
			Reporter.log("Exception occured while acccessing properties file", true);
			Assert.fail();
		}
		return propVal;
	}
	
	// This method is to generate a random number
	public static int generateRandomNum() {
		int randomNum=0;
		Random r = new Random();
		randomNum = r.nextInt(100000000);
		return randomNum;
	}
	
	// This method is to fetch the latest date-time stamp
	public static String generateTimeStamp() {
		SimpleDateFormat sDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String dateTimeStamp = sDate.format(new Date());
		return dateTimeStamp;		
	}
	
	// This method is to generate the Image File Name for screenshots; can be used for other
	// purpose as well.
	public static String generateImageName() {
		String imgName = generateTimeStamp()+".png"; 
		return imgName;
	}
	
	// This method is to take the screenshot.
	public static void takeScreenshot (WebDriver driver, String destFile) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File printScreen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(printScreen, new File(destFile));
		}
		catch(Exception e) {
			Reporter.log("Exception while taking the screenshot", true);
		}
	}
	
	

}
