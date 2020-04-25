package com.absolutedata.AbsoluteData;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartLandingPage{
	
	public WebDriver driver;
	
	public CartLandingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id='root']/div/header/div/div[2]/form/input")
	WebElement searchBox;
	
	@FindBy (xpath="//*[@id='root']/div/div[1]/div/div/h4")
	WebElement productName;
	
	@FindBy (xpath="//*[@id='root']/div/div[1]/div/div/div[2]/a[2]")
	WebElement incrementProduct;
	
	@FindBy (xpath="//*[@id='root']/div/div[1]/div/div/div[3]/button")
	WebElement addToCart;
	
	@FindBy (xpath="//*[@id='root']/div/header/div/div[3]/a[4]/img")
	WebElement cartIcon;
	
	@FindBy (xpath="//*[@id='root']/div/header/div/div[3]/div[2]/div[2]/button")
	WebElement proceedToCheckout;
	
	public void searchProduct(String searchText){
		searchBox.sendKeys(searchText);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public String getSearchProductName(){
		return productName.getText();
	}
	
	public void incrementProductQuantity(int incrementValue){
		for(int i=0;i<incrementValue;i++){
		incrementProduct.click();
		}
	}
	
	public void addProductToCart(){
		addToCart.click();
	}
	
	public CartPlaceOrderPage proceedToCheckout(){
		cartIcon.click();
		proceedToCheckout.click();
		return new CartPlaceOrderPage(driver);
	}

}
