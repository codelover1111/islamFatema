package waltDisney.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Disney {
	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "/Users/fatemaislam/Downloads/chromedriver");
	        driver = new ChromeDriver();
	       
	       driver.get(" https://disneyworld.disney.go.com/");
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       String logo=driver.findElement(By.xpath("//a[text()='Walt Disney World Logo']")).getText();
	       System.out.println("Logo is " +logo);
      
	       //validation
           String Expected="Walt Disney World Logo";
           Assert.assertEquals(logo,Expected );
	       System.out.println("Verify completed");
	       //verification
	       if(driver.getTitle().equalsIgnoreCase("Walt Disney World Resort in Orlando, Florida")) {
    	   System.out.println("Test passed and page title: "+driver.getTitle());
       }
       else {System.out.println("Test fail page title is "+driver.getTitle());
	       }
	       //Click on sign in
	      

	       WebElement element=driver.findElement(By.xpath("//a[text()='Sign In or Create Account']"));
     
           Actions actions = new Actions(driver);
          actions.moveToElement(element).click().build().perform();   
		           

	       
	       //Enter email id
           driver.findElement(By.xpath("//input[@type='email'][@name='username']")).sendKeys("chamok@gmail.com");
         
		           
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      
	   
	       
	       //Enter Password
	     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("chamok123");
	       
	      
	    
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	       WebElement clickbtn=driver.findElement(By.xpath("//span[text()='Sign In']"));
	       
	       clickbtn.click();
	   
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
}
}