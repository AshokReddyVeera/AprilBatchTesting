package com.seleniumautomation.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FruitsDropdown {
	
	public static void carsSelect(String cartype) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.letskodeit.com/practice");
		
		WebElement carslist = driver.findElement(By.id("carselect"));
		
		Select cars= new Select(carslist);
		
		cars.selectByVisibleText(cartype);
		
		System.out.println(cars.getFirstSelectedOption().getText());
		
		driver.close();
	}
	
	public static void fruitSelect(String visiblefruit, String valueFruit) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.letskodeit.com/practice");
		
		WebElement fruitslist = driver.findElement(By.id("multiple-select-example"));
		
		Select fruits= new Select(fruitslist);
		
		fruits.selectByVisibleText(visiblefruit);
		fruits.selectByValue(valueFruit);
		
		  List<WebElement> allselectedfruits=fruits.getAllSelectedOptions();
		  
		  for(WebElement fruitlist:allselectedfruits) {
			  System.out.println(fruitlist.getText());
		  }
		  
		  driver.close();
	}
	
	public static void main(String[] args) {
		fruitSelect("Apple","orange");
		carsSelect("BMW");
	}

}
