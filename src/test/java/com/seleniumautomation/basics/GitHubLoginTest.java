package com.seleniumautomation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubLoginTest {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignin");
		
		String pagetitle=driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(pagetitle);
		
		driver.close();
	}

}
