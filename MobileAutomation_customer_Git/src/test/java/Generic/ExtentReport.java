package Generic;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport extends Baseclass{
	
	 static String reportLocation = System.getProperty("user.dir")+"\\src\\test\\java\\Reports\\";
	 static String imageLocation = "images/";
	//public static  ExtentReports extent = new ExtentReports(reportLocation+"Report.html", true);

//	 //This method for Extent report creation of mobile
public static ExtentReports MobilestartReport(){
		
     		
      ExtentReports extent = new ExtentReports(reportLocation+DeviceType+"Report.html", true);
			
		return extent;
	}
	

	//Take scrennshot
	public static String createScreenshot(WebDriver driver) {
	   	 
        UUID uuid = UUID.randomUUID();
     
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            FileUtils.copyFile(scrFile, new File(Constants.Imagepath+ uuid + ".png"));
            
        } catch (Exception e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return Constants.Imagepath + uuid + ".png";
    }
}
