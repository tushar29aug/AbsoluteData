package com.absolutedata.AbsoluteData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators {
	
	public WebDriver driver;
	
	public HomePageLocators(WebDriver driver){
		this.driver=driver;
	}
	
	By loginIcon = By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a/span");
	
	public LoginPage clickOnLoginIcon(){
		driver.findElement(loginIcon).click();
		return new LoginPage(driver);
	}
	
	

}
