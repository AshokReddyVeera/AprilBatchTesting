package com.seleniumautomation.webtabledemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://letcode.in/table");
		
		WebElement stable=driver.findElement(By.id("simpletable"));
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", stable);
		
		List<WebElement> theaders=stable.findElements(By.tagName("th"));
		
		
		System.out.println("Those are all table headers");
		
		for(WebElement theader:theaders) {
			System.out.println(theader.getText());
		}
		
		Thread.sleep(3000);
		
		driver.close();
	}
	


}
