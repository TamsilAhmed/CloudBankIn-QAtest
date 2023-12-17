package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.UtilityClass;

public class SiteOpen extends UtilityClass{
	
	
	
	
	@BeforeMethod
	public void BrowserStart() {
		
		WebDriverManager.firefoxdriver().setup();
		
	    driver=new FirefoxDriver();
		
		driver.get("https://qatest.uat.cloudbankin.com/#/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	}
	@AfterMethod
	public void BrowserClose() {
		driver.quit();
	}

}
