package com.absolutedata.AbsoluteData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPlaceOrderPage {
	
	public WebDriver driver;
	
	public CartPlaceOrderPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id='root']/div1/div/div/div/button")
	WebElement placeOrderBtn;
	
	public void placeOrder(){
		placeOrderBtn.click();
	}
	

}
