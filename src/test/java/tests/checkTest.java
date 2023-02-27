package tests;

import utils.BrowserUtil;

public class checkTest {

	public static void main(String[] args) throws Exception {
		
		String browser = "chrome";
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browser);
		
		brUtil.launchUrl("https://www.amazon.com");
		
		String title = brUtil.getPageTitle();
		if(title.contains("Amazon"))
		{
			System.out.println("Correct Title ---- PASS");
			
		}
		else
		{
			System.out.println("Incorrect Title ---- FAIL");
		}
		
		brUtil.getPageUrl();
		brUtil.closeBrowser();
		
		
		
	}

}
