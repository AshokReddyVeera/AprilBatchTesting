package com.seleniumautomation.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin12345678");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String pageurl=driver.getCurrentUrl();
		
		String expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		                  //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		if(pageurl.equals(expectedurl)) { // true or false
			System.out.println("Successfully logged into application"); //true area
		}
		else {
			System.out.println("Login failed"); //false area
		}
		
		driver.close();
	}

}
