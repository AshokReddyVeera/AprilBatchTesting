package com.seleniumautomation.webtabledemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataOfWebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");

		WebElement stable = driver.findElement(By.id("simpletable"));
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", stable);

		List<WebElement> trows = stable.findElements(By.tagName("tr"));

		for (int i = 0; i < trows.size(); i++) { //trows //0,1,2
			List<WebElement> tcolumns = trows.get(i).findElements(By.tagName("td"));// first row colum
			for (int j = 0; j < tcolumns.size(); j++) { //0,1,2,3  //0,1,2,3 //0,1,2,3
				String data = tcolumns.get(j).getText();

				System.out.println(data);
			}
		}
	}

}
