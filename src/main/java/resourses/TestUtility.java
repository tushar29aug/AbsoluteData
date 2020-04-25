package resourses;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.absolute.base.Base;

@Test
public class TestUtility extends Base {
	
	public static String fileName;
	
	
	public static void captureScreenshot() throws IOException{
		
		Date d = new Date();		
		fileName = d.toString().replace(" ", "_").replace(":", "_");
		
		//File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C://"+fileName+".jpg"));
	}

}
