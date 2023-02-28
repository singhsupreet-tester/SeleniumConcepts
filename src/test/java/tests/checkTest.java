package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BrowserUtil;
import utils.ElementUtil;

public class checkTest {

	public static void main(String[] args) throws Exception {
		
		String browser = "chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browser);
		
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = brUtil.getPageTitle();
		System.out.println("Title" + title);
		if(title.contains("Account"))
		{
			System.out.println("Correct Title ---- PASS");
			
		}
		else
		{
			System.out.println("Incorrect Title ---- FAIL");
		}
		
		brUtil.getPageUrl();
		brUtil.getPageTitle();
		
		
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "sam29sept@gmail.com");
		eleUtil.doSendKeys(password, "samhans");
		
		brUtil.closeBrowser();
	}

}
