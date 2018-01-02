package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	public WebDriver driver;	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
		System.setProperty(IE_KEY, IE_VALUE);
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("chrome")String browser) {
		switch (browser.toLowerCase())
		{
			case "chrome":
			{
				driver = new ChromeDriver();
				break;
			}				
			case "firefox":
			{
				driver = new FirefoxDriver();
				break;
			}
			case "ie":
			{
				driver = new InternetExplorerDriver();
				break;
			}
			default:
			{
				driver = new ChromeDriver();
				break;
			}			
		}
		// Fetching the value of application URL.
		String autURL= Utilities.getPropertyValue(CONFIG_FILE_PATH, "AUT_URL");
		// Entering the URL in the browser.
		driver.get(autURL);
		// Reading the implicit timeout value from properties file
		// and converting it into long type.
		String strITO = Utilities.getPropertyValue(CONFIG_FILE_PATH, "ITO");
		long ito =Long.parseLong(strITO);
		// Setting the implicit timeout.
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);		
	}
	
	@AfterMethod (alwaysRun=true)
	public void closeApp(WebDriver driver) {
		// closing the browser.
		if(driver!=null) {
			driver.quit();
		}
		
	}

}
