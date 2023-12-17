package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class UtilityClass {
	
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void mouseOver(WebElement ele) {
		
		Actions action = new Actions(driver);


		action.moveToElement(ele).build().perform();
		
		
	}
	
public boolean switchTab() {
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String>windowhandles = driver.getWindowHandles();
		
		
		for(String address:windowhandles) {
			if(!address.contentEquals(parentwindow)) {
				System.out.println("The child window address is :" +address );
				driver.switchTo().window(address);
				break;
			}
		}
		return false;
	}

public void waitforme(WebElement element) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(element));
    driver.manage().logs();
}

public void TitleCheck() throws Exception {
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Title Check", "Visibility Check");
	
	test.log(LogStatus.INFO, "Checking for the Title");
	
	driver.getTitle();
	
	if(driver.getTitle()!= null) {
	
	test.log(LogStatus.PASS, "The Title is Shown");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/Title.png"));
	String img = test.addScreenCapture("./screenshot/Title.png");
	}
	
	else {
	test.log(LogStatus.FAIL, "The Title is not Shown"); 
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
	String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
}
	extent.endTest(test);

	extent.flush();
}

public void confirmation(WebElement ele) throws Exception {
	
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Loan Amount", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = ele.getText();
	
	
	System.out.println(title);
	
	if(title.contentEquals(title)) {
		test.log(LogStatus.PASS, "Loan Amount Approved");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/AmountDetails.png"));
		String img = test.addScreenCapture("./screenshot/AmountDetails.png");
	}else {
		test.log(LogStatus.FAIL, "Loan Amount Approve Pending"); 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/PendingStatus.png"));
		String img = test.addScreenCapture("./screenshot/PendingStatus.png");
	}
		extent.endTest(test);

		extent.flush();
	
	
}

public void ScrollDown() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)", "");
}

public void ScrollDown1(WebElement Element) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",Element );
}

public void ScrollDown2() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
}
public void Dropdown(WebElement ele) {
	
	Select sel = new Select(ele);
	
	sel.selectByIndex(7);
}
public void Dropdown1(WebElement ele) {
	
	Select sel = new Select(ele);
	
	sel.selectByIndex(0);
}
public void Dropdown2(WebElement ele) {
	
	Select sel = new Select(ele);
	
	sel.selectByIndex(3);
}

public void Person() throws Exception {
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Client Creation", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = driver.findElement(By.xpath("//strong[@class='fs-3 ng-binding']")).getText();
	
	
	System.out.println(title);
	
	if(title.contentEquals(title)) {
		test.log(LogStatus.PASS, "Client Is created Successfully");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Person.png"));
		String img = test.addScreenCapture("./screenshot/Person.png");
	}else {
		test.log(LogStatus.FAIL, "Client Creation is Failed"); 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Error.png"));
		String img = test.addScreenCapture("./screenshot/Error.png");
	}
		extent.endTest(test);

		extent.flush();
	
	

}	
}

