package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserTesting {
	
	public static WebDriver driver;
	
	@BeforeClass
	//To pass parameter from testng.xml file to this method,we can use
	//the testng annotation @parameters
	@Parameters("browser")
	
	public void setup(String browser) {
		//since we want to test in multiple browsers,we will setup browser
		//for two browsers
		
		if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get("https://tek-retail-ui.azurewebsites.net/selenium/inputs");
		}else if(browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("https://tek-retail-ui.azurewebsites.net/selenium/inputs");
			
			
		}
		
		
		
	}
	
	//we create out tests
	@Test
	public void testScenario1() {
		
		//method implementation here
		driver.findElement(By.id("textInput")).sendKeys("Dragons");
		
	}
	//to create test in testng,we need to use the testng annotation @Test
	
	@Test
	public void testScenario2() {
		//method implementation
		driver.findElement(By.id("emailInput")).sendKeys("dragons@gmail.com");
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	

}
