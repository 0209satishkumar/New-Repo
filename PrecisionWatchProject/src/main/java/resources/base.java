package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public WebDriver driver;


	@SuppressWarnings("deprecation")
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\CodeZero2Pi\\Automation\\PrecisionWatchProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		

		if(browserName.equalsIgnoreCase("chrome")) 
		{
			//execute in Chrome browser
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("D:\\CodeZero2Pi\\Automation\\PrecisionWatchProject\\metamask.com.crx"));
			driver = new ChromeDriver(options);
			
			
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//execute in edge driver
			driver = new EdgeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
}
