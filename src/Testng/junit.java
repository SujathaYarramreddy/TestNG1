package Testng;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class junit {
WebDriver driver;
	
	@Test
	public void sutest() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Before
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "./driver/chromedrivernew.exe");
			driver = new ChromeDriver();
			driver.get("www.opensource-demo.orangehrmlive.com/");
	  }

	  @After
	  public void afterTest() {
		  System.out.println("After Test");
		  driver.close();
		  
	  }

}
