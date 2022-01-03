package com.RapidInnovation.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void Config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Automation results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit");
	}


	@Test
	public void initialDemo () 
	{
		extent.createTest("initialDemo");	
		System.setProperty("webdriver.chrome.driver", "D:\\ROHIT\\Softwares\\chromedriver.exe\\");	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://main.d1wxtput80cmif.amplifyapp.com/");
		driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.close();
		extent.flush();	
	}

}
