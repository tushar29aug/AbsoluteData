package com.absolutedata.AbsoluteData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.absolute.base.Base;

public class CartTest extends Base {
	public WebDriver driver;
	CartLandingPage cartLand;
	CartPlaceOrderPage cartPlaceOrder;
	
	@BeforeTest
	public void setUp() throws IOException{
		driver = initialization();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		cartLand = new CartLandingPage(driver);
	}
	
	@Test
	public void verifyAddedProductName() throws InterruptedException{	
		cartLand.searchProduct("Cucumber");
		Thread.sleep(2000);
		System.out.println(cartLand.getSearchProductName());
		Assert.assertEquals("Cucumber - 1 Kg", cartLand.getSearchProductName());
	}
	
	@Test
	public void verifyCartFlow(){
		cartLand.incrementProductQuantity(2);
		cartLand.addProductToCart();
		cartPlaceOrder = cartLand.proceedToCheckout();
		cartPlaceOrder.placeOrder();
	}
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
