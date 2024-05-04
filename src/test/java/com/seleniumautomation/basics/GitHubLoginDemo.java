package com.seleniumautomation.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubLoginDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignin");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // 1,2[box visible]
		
		WebElement username=driver.findElement(By.id("login_field"));
	
		username.sendKeys("test@gmail.com");
	
		username.clear();
		
		username.sendKeys("java@gmail.com");
	}
}
