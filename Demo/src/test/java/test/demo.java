package test;

import Browser.browser;
import Page.page1;
import Page.page2;
import Screenshot.capture;
//import ScreenShot.capture;

class Demo {
	public static void main(String[] args) throws Exception {
		
		browser.openBrowser();
		browser.navigate("Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");	
		Thread.sleep(2000);
		capture.screenShot("Home Page");
		if(page1.title().contains("Rediff.com"))
			 System.out.println("Title verification Pass"); 
		 else 
		     System.out.println("Title verification Fail");
		
		page1.click("Create Account");
		if(page2.url().endsWith("FormName=user_detail"))
			 System.out.println("URL verification Pass"); 
		 else 
		     System.out.println("URL verification Fail");
		
		page2.fullName("Soumyajit");
		page2.mailId("thisisavalidemail");
		page2.checkAvailability();
		if(page2.message().equals("Yippie! The ID you've chosen is available."))
			 System.out.println("Id available Pass"); 
		 else 
		     System.out.println("Id available Fail");
		capture.screenShot("Message");
		browser.closeBrowser();
	}
}

