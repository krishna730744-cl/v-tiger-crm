package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Screenshot {
	WebDriver driver;
	public Screenshot(WebDriver driver) {
	    this.driver = driver;
	}
	public String getScreenshot(String testCaseName) throws IOException
	{
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File folder = new File(System.getProperty("user.dir") + "//reports");

	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    File file = new File(folder, testCaseName + ".png");

	    FileUtils.copyFile(source, file);

//	    File file = new File(
//	        System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"
//	    );
//
//	    FileUtils.copyFile(source, file);

	    return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
}
