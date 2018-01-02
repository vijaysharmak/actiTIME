package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPageObjects {
	
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutActiTime;
	
	@FindBy(xpath="//span[starts-with(text(),'actiTIME')]")
	private WebElement version;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closePopup;
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	
	public EnterTimeTrackPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
