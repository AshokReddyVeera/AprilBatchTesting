package com.seleniumautomation.jsexamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmLogin {

	
	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement username=driver.findElement(By.name("username"));
		
		WebElement password=driver.findElement(By.name("password"));
		
		WebElement loginbtn=driver.findElement(By.xpath("//button[@type='submit']"));
		
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].value='admin';",username);
		
		js.executeScript("arguments[0].value='Admin123';", password);
		
		js.executeScript("arguments[0].click();", loginbtn);
	}
}
