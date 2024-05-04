package com.seleniumautomation.readdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMProperitesLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String location = System.getProperty("user.dir");

		System.out.println(location);

		// C:\Users\ADMIN\OneDrive\Desktop\Java Practice\SeleniumAutomation

		File file = new File(location + "\\Credentails.properties");

		BufferedReader reader = new BufferedReader(new FileReader(file));// this read the file

		Properties pr = new Properties(); // creating object for properties class
		
		pr.load(reader); // read entire data from above sheet and store into properties class
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String url=pr.getProperty("url"); //url
		String username= pr.getProperty("username");
		String password=pr.getProperty("password");
		
		System.out.println(pr.getProperty("environment"));
		
		driver.get(url);
		
		driver.findElement(By.name("username")).sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
		

	}

}
