package com.seleniumautomation.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubLogin {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignin");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //1,2[box visible]
		
		driver.findElement(By.id("login_field")).sendKeys("Test@gmail.com");//1 or 2
		
		driver.findElement(By.id("password")).sendKeys("Test!234");
		
		driver.findElement(By.xpath("//input[@data-signin-label='Sign in']")).click();
		
		driver.close();
		
	}

}
