package com.seleniumautomation.cssdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitLoginWithCss {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignin");
		
		driver.findElement(By.cssSelector("input#login_field")).sendKeys("test@gmail.com");
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("test@1232");
		
		driver.findElement(By.cssSelector("div>input[value*='Sign']")).click();
	}

}
