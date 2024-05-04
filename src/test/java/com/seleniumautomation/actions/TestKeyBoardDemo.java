package com.seleniumautomation.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyBoardDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://text-compare.com/");
		
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement textarea1=driver.findElement(By.id("inputText1"));
		
		WebElement textarea2=driver.findElement(By.id("inputText2"));
		
		Actions action= new Actions(driver);
		
		textarea1.sendKeys("Welcome to testing world");
		
		//CNTRL+A for text select
		//CNTRL+C for text copy
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		
		action.keyUp(Keys.CONTROL);
		action.perform(); // This will select all entered text
		
		Thread.sleep(2000);
		
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		
		action.keyUp(Keys.CONTROL);
		action.perform();// this will copy entered text
		
		action.sendKeys(Keys.TAB).perform(); // this wil move to next box
		
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		
		action.keyUp(Keys.CONTROL);
		action.perform(); // this will paste copied data
		
	}

}
