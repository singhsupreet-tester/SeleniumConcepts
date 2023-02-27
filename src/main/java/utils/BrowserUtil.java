package utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	
		
		WebDriver driver;
		
		
		public void launchBrowser(String browser) throws Exception
		{
			
			
			switch(browser.toLowerCase())
			{
			case  "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
				
			case  "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
				
			case  "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
				
				
			default:
				System.out.println("Plz pass the right browser");
				throw new Exception("WRONGBROWSER");
				
			}
		
		}
		
		
		public void launchUrl(String url) throws Exception
		{
			if(url == null)
			{
				System.out.println("Url is Null");
				throw new Exception("URLISNULL");
			}
			
			if(url.length() == 0)
			{
				System.out.println("Url is blank");
				throw new Exception("URLBLANKEXCEPTION");
			}
			
			if(url.indexOf("http")!=0 || url.indexOf("https")!=0)
			{
				System.out.println("Http(s) is missing in Url");
				throw new Exception("HTTP(s)MISSINGEXCEPTION");
			}
			
			driver.get(url);
		}
		
		
		
		public void launchUrl(URL url) throws Exception
		{
			String newURL = String.valueOf(url);
			
			if(newURL == null)
			{
				System.out.println("Url is Null");
				throw new Exception("URLISNULL");
			}
			
			if(newURL.length() == 0)
			{
				System.out.println("Url is blank");
				throw new Exception("URLBLANKEXCEPTION");
			}
			
			if(newURL.indexOf("http")!=0 || newURL.indexOf("https")!=0)
			{
				System.out.println("Http(s) is missing in Url");
				throw new Exception("HTTP(s)MISSINGEXCEPTION");
			}
			
			driver.navigate().to(newURL);
		}
		
	
		public String getPageTitle()
		{
			String title = driver.getTitle();
			System.out.println("Page Title:" + title);
			
			if(title!=null)
			{
				return title;
			}
			else
			{
				System.out.println("Getting Null Title");
				return null;
			}
		}
		

		public String getPageUrl()
		{
			String currentURL = driver.getCurrentUrl();
			System.out.println("Current Url: " + currentURL);
			
			if(currentURL!=null)
			{
				return currentURL;
			}
			else
			{
				System.out.println("Getting Null Title.....");
				return null;
			}	
		}
		
		
		public void closeBrowser()
		{
			if(driver!=null)
			{
				driver.close();
				System.out.println("Browser is closed....");
			}
		}
		
		
		public void quitBrowser()
		{
			if(driver!=null)
			{
				driver.quit();
				System.out.println("Quit the Browser....");
			}
		}
		
}
