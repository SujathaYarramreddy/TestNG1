package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver; 
	
	@Test(priority=1)
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivernew.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String Expectedtitle = "Sujatha";
		String Actualtitle = driver.getTitle();
		Assert.assertEquals(Actualtitle, Expectedtitle); //in this case if this method fails, remaining method will execute.
		
	}
	

	//--if we keep dependsOnMethods option then based on method execution remaining methods will execute
	@Test(dependsOnMethods= {"launch"},alwaysRun=true ,priority=2)
	public void testcase() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		  Thread.sleep(3000);
		
	}
	
	@Test(dependsOnMethods= {"testcase"}, priority=3)
	public void end() {
		driver.close();
		
	}
}
