package com.seleniumautomation.alerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementDemo {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://omayo.blogspot.com/");
		
		List<WebElement> buttons=driver.findElements(By.xpath("//button"));
		
		for(WebElement button:buttons) {
			System.out.println(button.getText());
		}
		
		driver.close();
	}

}
