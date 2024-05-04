package com.seleniumautomation.windowhandles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.letskodeit.com/practice");
		
		String parentwindow=driver.getWindowHandle();

		driver.findElement(By.id("openwindow")).click();

		Set<String> allwindows = driver.getWindowHandles();

		for (String window : allwindows) {
			driver.switchTo().window(window);// entered into any window
			if (driver.getCurrentUrl().equals("https://www.letskodeit.com/courses")) {// false true

				driver.manage().window().maximize();

				driver.findElement(By.linkText("INTERVIEW")).click();

			}

		}
		
		driver.switchTo().window(parentwindow);

		Thread.sleep(2000);
		
		//driver.close();// This method will close current active window
		
		driver.quit();// This method will close all opened windows
	}

}
