package com.seleniumautomation.alerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignin");
		
		List<WebElement> alllinks=driver.findElements(By.xpath("//a"));
		
		for(WebElement link:alllinks) {
			System.out.println(link.getText());
		}
	}

}
