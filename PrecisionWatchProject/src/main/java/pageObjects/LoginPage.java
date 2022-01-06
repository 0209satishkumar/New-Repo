package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

public WebDriver driver;
	
	By email = By.xpath("//*[@id=\"email\"]");                          //object created for email
    By passwd = By.xpath("//*[@id=\"password\"]");
    By login = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/form/button");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getEmail()                                                 
	{
		return driver.findElement(email);                                         //method created for email objects 
	}
	
	public WebElement getPassword()                                                 
	{
		return driver.findElement(passwd);                                         
	}
	
	public WebElement getLogin()                                                 
	{
		return driver.findElement(login);                                        
	}
	
	
	
}
