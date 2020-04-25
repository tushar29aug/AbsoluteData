package com.absolutedata.AbsoluteData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By loginBtn = By.xpath("//*[@id='new_user']/div[3]/input");
	
	

}
