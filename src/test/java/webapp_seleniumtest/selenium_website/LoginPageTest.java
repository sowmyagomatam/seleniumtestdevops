package webapp_seleniumtest.selenium_website;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	ChromeDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions chromoptions = new ChromeOptions();
		//chromoptions.addArguments("--headless");
		driver = new ChromeDriver(chromoptions);
		driver.get("http://ec2-3-17-67-208.us-east-2.compute.amazonaws.com:3001/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
	}
	
  @Test
  public void verifyLoginPage() {
	  
	// TODO Auto-generated method stub
			
			WebElement username = driver.findElement(By.name("login"));
			username.sendKeys("devops");
			
			WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
			pwd.sendKeys("test");
			
			driver.findElement(By.name("click")).click();
           
			WebElement loginsuceededElement=  driver.findElement(By.xpath("//*[@id=\"img1\"]/form/div/div/div/div[2]/div/strong"));
			String name= loginsuceededElement.getText();
			
			Assert.assertEquals(name,"Well done!");
  }
  
  @AfterMethod
  public void close()
  {
	  driver.close();
  }
}
