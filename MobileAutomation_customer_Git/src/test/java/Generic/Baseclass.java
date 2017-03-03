package Generic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Baseclass {
@SuppressWarnings("rawtypes")
public static AppiumDriver driver=null;

static Excelreader er=new Excelreader();


//public static String DeviceType=er.getExcelCellValue(Constants.xlpath,"Datasheet",23,0);
public static String DeviceType=GenericMethods.getstring("ostype");
public static String negativescenarios=GenericMethods.getstring("negativescenarios");
static Property_Reader pr=new Property_Reader();


public static ExtentReports extent =null;

@BeforeTest
public static void initialize() throws MalformedURLException
{
	System.out.println(DeviceType);
	extent = new ExtentReports(Constants.Reportpath+DeviceType+".html", false);

	DesiredCapabilities caps = new DesiredCapabilities();
	if(DeviceType.contains("Android"))
	{	
		File app=new File(pr.getstring("Apk_file"));
    	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, pr.getstring("Android_Platform_Name"));
    	caps.setCapability(MobileCapabilityType.DEVICE_NAME, pr.getstring("Android_Device_Name"));
    	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, pr.getstring("Android_Platform_Version"));
        caps.setCapability("autoAcceptAlerts","true");
    	caps.setCapability("waitforAppScript","true");
      //  caps.setCapability("noReset", true);
        caps.setCapability(MobileCapabilityType.APP,app);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), caps);
        System.out.println(driver.toString());
	}
	else 
	{
/*		
		File app=new File(pr.getstring("ipa_file"));
	    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, pr.getstring("Iphone_Automation_Name"));
       caps.setCapability(MobileCapabilityType.APP, app);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OPT-BNG-IT-VA-0228");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3.5");
		//caps.setCapability(MobileCapabilityType.PLATFORM_NAME, pr.getstring("Iphone_Platform_Name"));
		caps.setCapability("device", "iPhone 5s");
		caps.setCapability(CapabilityType.PLATFORM, pr.getstring("Iphone_Platform"));
		caps.setCapability("udid","745bcaaf7eaf0704fe080d79285025f6a1c64def");
		caps.setCapability("autoAcceptAlerts", "true");
		caps.setCapability("waitforAppScript", "true");
		caps.setCapability("noReset", true);	
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.resetApp();*/
		
		
		
		
		File app=new File(pr.getstring("ipa_file"));
	     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, pr.getstring("Iphone_Automation_Name"));
        caps.setCapability(MobileCapabilityType.APP, app);
        caps.setCapability("device", "iPhone Simulator");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, pr.getstring("Iphone_Device_Name"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, pr.getstring("Iphone_Platform_Version"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, pr.getstring("Iphone_Platform_Name"));
		caps.setCapability(CapabilityType.PLATFORM, pr.getstring("Iphone_Platform"));
		caps.setCapability("autoAcceptAlerts", "true");
		caps.setCapability("waitforAppScript", "true");
		caps.setCapability("noReset", true);
		
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		 System.out.println(driver.toString());
		 
		 
	}
	
	
}



@AfterTest
public static void close()
{
	extent.flush();
}

public static void Mobilewriteresults(String Results, AppiumDriver driver,
		String desc, ExtentTest test, String currentTCName) {

     if (Results.equalsIgnoreCase("Pass")) {
		test.log(LogStatus.PASS, desc);
		System.out.println(desc);
			}
	else 
	{
 // String imagePath = ExtentReport.createScreenshot(driver);	
 // String img = test.addScreenCapture(imagePath);
  test.log(LogStatus.FAIL,desc);
  System.out.println("fail:::"+desc);
		

		
	}
}
}
