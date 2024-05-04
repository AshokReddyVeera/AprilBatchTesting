package com.seleniumautomation.sycronization;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://letcode.in/waits");
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("accept")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alert.getText());
		
		//Alert alert=driver.switchTo().alert();
		alert.accept();
	}

}
