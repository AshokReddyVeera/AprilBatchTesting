package com.seleniumautomation.frames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://letcode.in/frame");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		WebElement frame1=driver.findElement(By.id("firstFr"));
		
		driver.switchTo().frame(frame1);// this line will transfer driver initiation into frame
		
		driver.findElement(By.name("fname")).sendKeys("TextDemo");
		
		WebElement lastname=driver.findElement(By.name("lname"));
		lastname.sendKeys("Demo");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='innerFrame']")));
		
		driver.findElement(By.name("email")).sendKeys("xxx@yyy.zzz");
		
		driver.switchTo().parentFrame();
		
		lastname.clear();
		lastname.sendKeys("DemoFrame");
		
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@data-icon='home']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
