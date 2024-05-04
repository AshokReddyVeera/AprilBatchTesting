package com.seleniumautomation.testngconcepts;

import org.testng.annotations.Test;

public class TestGmail {
	
	@Test(priority = 1)
	public void launchBrowser() {
		System.out.println("Chrome Browser launched successfully");
	}
	
	@Test(priority = 2)
	public void launchURL() {
		System.out.println("Gmail url launched");
	} 
	
	@Test(priority = 3)
	public void gmailLogin() {
		System.out.println("Gmail login successfullly");
	}
	
	@Test(priority = 4)
	public void inboxTest() {
		System.out.println("Gmail Inbox items validated");
	}
	
	@Test(priority = 5, enabled= false)
	public void sendBoxTest() {
		System.out.println("Gmail Send items validated");
	}
	
	@Test(priority = 6, enabled= false)
	public void spamboxTest() {
		System.out.println("Gmail Spam items validated");
	}
	
	@Test(priority = 7)
	public void gmailLogOut() {
		System.out.println("Gmail logout successfully");
	}
	
	@Test(priority = 8)
	public void closeBrowser() {
		System.out.println("Brower closed sucesfully");
	}

}
