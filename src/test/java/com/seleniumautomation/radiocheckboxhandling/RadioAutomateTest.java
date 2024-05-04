package com.seleniumautomation.radiocheckboxhandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioAutomateTest {
	WebDriver driver;
	
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.letskodeit.com/practice");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
	}
	
	public void selectRadio(String carselect) {
		List<WebElement> cars=driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(WebElement car:cars) {
			if(car.getAttribute("id").equals(carselect)) {//false //false true
				car.click();
			}
		}
	}
	
	public void selectCheckBox(String carcheck, String carcheck1) {
		List<WebElement> checkcars=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkcar:checkcars) {
			if(checkcar.getAttribute("value").equals(carcheck)) {
				checkcar.click();
			}
			if(checkcar.getAttribute("value").equals(carcheck1)) {
				checkcar.click();
			}
		}
	}
	
	public void selectDropDown(String visibleText) {
		WebElement car=driver.findElement(By.id("carselect"));
		
		Select select= new Select(car);
		select.selectByVisibleText(visibleText);
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	public static void main(String[] args) throws Exception {
		RadioAutomateTest test= new RadioAutomateTest();
		test.launchUrl();
		test.selectRadio("bmwradio");
		test.selectCheckBox("bmw","honda");
		test.selectDropDown("BMW");
		test.closeBrowser();
	}

}
