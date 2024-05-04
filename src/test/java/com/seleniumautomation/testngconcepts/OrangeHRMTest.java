package com.seleniumautomation.testngconcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OrangeHRMTest {

	WebDriver driver;
	Properties pr;
	
	SoftAssert softasset;

	@BeforeSuite
	public void testDataLoad() throws IOException {
		String location = System.getProperty("user.dir");

		File file = new File(location + "\\Credentails.properties");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		pr = new Properties();
		pr.load(reader);
	}

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@BeforeClass
	public void launchbrowser() {
		String apprul = pr.getProperty("url");
		driver.get(apprul);
	}

	@BeforeMethod
	public void loginApp() {
		String username = pr.getProperty("username");
		String password = pr.getProperty("password");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualURL=driver.getCurrentUrl();
		//Assert.assertEquals(expectedurl, actualURL);// Hard Assertion
		softasset= new SoftAssert();
		softasset.assertEquals(actualURL, expectedurl);
		
		
		
	}

	@Test(priority = 1)
	public void navigateToTime() {
		driver.findElement(By.xpath("//a//span[text()='Time']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input--before']/..//input")).sendKeys("Test");
		driver.findElement(By.xpath("//button[text()=' View ']")).click();
	}
	
	@Test(priority = 2)
	public void navigateToPIM() {
		driver.findElement(By.xpath("//a//span[text()='PIM']")).click();
		String expurl="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployee";
		String acturl=driver.getCurrentUrl();
		//Assert.assertEquals(acturl, expurl);
		driver.findElement(By.xpath("//ul//a[text()='Add Employee']")).click();
	}

	@AfterMethod
	public void logoutApp() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		softasset.assertAll();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@AfterSuite
	public void reportGenerated() {
		System.out.println("Report generated");
	}

}
