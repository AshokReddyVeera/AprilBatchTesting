package com.seleniumautomation.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://facebook.com/");
		
		System.out.println("Opened page title is::"+driver.getTitle());
		
		driver.navigate().to("https://google.com");
		
		driver.manage().window().maximize();
		
		String pagetitle =driver.getTitle();// Google
		System.out.println("Opened page title is::"+pagetitle);
		
		String pageurl=driver.getCurrentUrl(); //https:faceboook.com/signup
		System.out.println("Opened page url is:: "+pageurl);
		
		driver.navigate().back();
		
		System.out.println("Back url is "+driver.getTitle());
		
		driver.navigate().forward();
		
		System.out.println("Forword url is "+driver.getTitle());
		
		
		
		driver.close(); // This method will close current active browser
	}

}
