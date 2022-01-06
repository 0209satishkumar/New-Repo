package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	By signin=By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/a/button");        //object created
    
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getLogin()                                                 
	{
		return driver.findElement(signin);                                         //method created
	}
	
	
}
