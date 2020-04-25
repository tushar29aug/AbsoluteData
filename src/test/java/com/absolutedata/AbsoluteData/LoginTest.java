package com.absolutedata.AbsoluteData;

import java.io.IOException;
import org.testng.annotations.Test;
import com.absolute.base.Base;

public class LoginTest extends Base{
	
	@Test
	public void getLogin() throws IOException{
		driver = initialization();
		driver.get(prop.getProperty("url"));
		HomePageLocators home = new HomePageLocators(driver);
		LoginPage login = home.clickOnLoginIcon();
	}

}
