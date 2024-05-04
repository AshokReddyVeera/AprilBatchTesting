package com.seleniumautomation.webtabledemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttendanceTest {

	public void studentAttendance(String slname) { //Man //Raj 
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("simpletable")));
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='simpletable']//tbody/tr"));
		
	
		
		for(int i=0;i<rows.size();i++) {
			List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<columns.size();j++) { //1/ 0,1
				//String lname=columns.get(1).getText();
				    WebElement colum=columns.get(j);
				     String lname= colum.getText();
				if(lname.equals(slname)) { //false //Man //Raj
					columns.get(3).findElement(By.tagName("input")).click();
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		AttendanceTest tet= new AttendanceTest();
		tet.studentAttendance("Chatterjee");
		
		
	}

}
