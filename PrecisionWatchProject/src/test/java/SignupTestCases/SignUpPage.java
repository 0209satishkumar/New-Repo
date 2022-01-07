package SignupTestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SignUpPage {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	static ExtentReports extent;



	@BeforeClass
	public static ExtentReports startTest()
	{
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Automation results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit");
		return extent; 
	}

	@BeforeTest
	public void start() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\CodeZero2Pi\\Automation\\PrecisionWatchProject\\metamask.com.crx"));
		driver = new ChromeDriver(options);
		driver.get("https://main.d1wxtput80cmif.amplifyapp.com/signup");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void EnterName() throws IOException 
	{
		extent.createTest("Test case 1 = Enter your name");
		WebElement Name=driver.findElement(By.id("name"));
		Name.sendKeys("Rohit Punekar");
	}

	@Test
	public void EnterAddress() throws InterruptedException 
	{
		extent.createTest("Test Case 2 = Enter your address");     
		WebElement Addr=driver.findElement(By.id("address"));
		Addr.sendKeys("Hadapsar,Pune,Maharashtra-411028");
	}

	@Test
	public void EnterMobile() throws InterruptedException 
	{
		extent.createTest("Test Case 3 = Enter your mobile number");     
		WebElement mbl=driver.findElement(By.id("mobile"));
		mbl.sendKeys("Hadapsar,Pune,Maharashtra-411028");
	}

	@AfterTest
	public void close()
	{
		driver.quit();
	}

	@AfterClass
	public static void endTest()
	{

		extent.flush();
	}

}
