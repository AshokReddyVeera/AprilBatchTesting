package com.seleniumautomation.radiocheckboxhandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRadio {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.letskodeit.com/practice");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("hondaradio")).click();
		
		//Checkbox selection using click approach
		driver.findElement(By.id("bmwcheck")).click();
		
		driver.findElement(By.id("benzcheck")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
