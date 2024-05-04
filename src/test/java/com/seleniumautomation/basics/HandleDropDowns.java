package com.seleniumautomation.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();// This two steps initialize an empty browser with out launching any url

		driver.get("https://www.letskodeit.com/practice");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement carslist = driver.findElement(By.id("carselect"));

		Select carsselect = new Select(carslist);
		//carsselect.selectByVisibleText("Honda");
		carsselect.selectByValue("benz");
		
		WebElement selectedCar=carsselect.getFirstSelectedOption();
		
		System.out.println("Selected Car is "+selectedCar.getText());

		Thread.sleep(10000);

		driver.close();
	}

}
