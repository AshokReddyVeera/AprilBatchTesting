package com.seleniumautomation.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyBoard {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/key_presses");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.CONTROL).perform();
		
		Thread.sleep(2000);
		
		action.sendKeys(Keys.TAB).perform();
		
		Thread.sleep(2000);
		
		action.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(2000);
		
		action.sendKeys(Keys.ESCAPE).perform();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
