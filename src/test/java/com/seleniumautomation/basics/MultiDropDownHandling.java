package com.seleniumautomation.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiDropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement fruits = driver.findElement(By.id("multiple-select-example"));

		Select fruitselect = new Select(fruits);

		fruitselect.selectByIndex(0);
		fruitselect.selectByIndex(1);
		fruitselect.selectByVisibleText("Peach"); // 3 fruits selected

		List<WebElement> selectfruits = fruitselect.getAllSelectedOptions();

		for (WebElement fruit : selectfruits) {
			System.out.println(fruit.getText());
		}

		fruitselect.deselectByIndex(0);

		Thread.sleep(4000);
		
		System.out.println("After deselect fruits list");

		List<WebElement> selectfruits1 = fruitselect.getAllSelectedOptions();

		for (WebElement fruit : selectfruits1) {
			System.out.println(fruit.getText());
		}
		
		Thread.sleep(4000);

		driver.close();

		/*
		 * List<WebElement> allselectedfruits=fruitselect.getAllSelectedOptions();
		 * 
		 * for(WebElement fruit:allselectedfruits) {
		 * System.out.println(fruit.getText()); }
		 */
	}

}
