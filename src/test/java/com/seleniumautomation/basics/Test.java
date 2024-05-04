package com.seleniumautomation.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.name("username"));

		WebElement password = driver.findElement(By.name("password"));

		WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].value='Admin';", username);

		js.executeScript("arguments[0].value='admin123';", password);

		js.executeScript("arguments[0].click();", loginbutton);

	}

}
