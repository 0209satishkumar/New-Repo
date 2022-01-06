package RapidInnovation;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pageObjects.LandingPage;
import resources.base;

public class homepage extends base{
	static ExtentReports report;
	static  ExtentTest test;
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

		driver=initializeDriver();
		driver.get("https://main.d1wxtput80cmif.amplifyapp.com/");


	}


	@Test
	public void basePageNavigation() throws IOException 
	{
		/*Two ways to access methods of other class
		1) By Inheritance(e.g. extends base)
		2) Creating object to that class and invoke methods of it*/
		extent.createTest("initialDemo");
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();                                        //which is similar to driver.Findelement(By.css....) 



		//		LoginPage lp = new LoginPage(driver);
		//		lp.getEmail().sendKeys("Rohit");
		//		lp.getPassword().sendKeys("123");
		//		lp.getLogin().click();
	}

	@Test
	public void getTitle() throws InterruptedException 
	{
        extent.createTest("secondTest");     
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

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
