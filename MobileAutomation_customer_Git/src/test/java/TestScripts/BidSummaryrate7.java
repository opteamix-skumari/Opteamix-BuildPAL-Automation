package TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;
import io.appium.java_client.ios.IOSElement;

public class BidSummaryrate7 extends Baseclass {

	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");

	public static String Email = inputarr[3][7];
	public static String Password = inputarr[4][1];

	public static String IRJobName = inputarr[0][7];
	public static String IRPincode = inputarr[1][7];

	public static String IRWorkTypeJobName = inputarr[2][7];

	@Test
	public static void BidSummaryrate() throws InterruptedException, IOException {

		Thread.sleep(3000);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "BidSummaryrate";

		ExtentTest test = extent.startTest(currentTCName,"BidSummaryrate");

		if(pr.path.contains("IOS"))
		{
			try{
				Alert al=driver.switchTo().alert();
				al.accept();
				Thread.sleep(1000);
				Alert al1=driver.switchTo().alert();
				al1.accept();
			}
			catch(Exception e){
				System.out.println("alert pop not displayed");
			}

		}

		Thread.sleep(2000);
		project.checklogin(Email, Password);
		Thread.sleep(2000);
		System.out.println("####BidSummary#####");

		results = gm.click(pr.getlocator("Hammericon"));
		Mobilewriteresults(results, driver, "Click on Hammericon", test,currentTCName);
	    Thread.sleep(2000);
		
		results = gm.click(pr.getlocator("RATEWORKTYPE"));
		Mobilewriteresults(results, driver, "Click on RATEWORKTYPE", test,currentTCName);
	    Thread.sleep(2000);
		  
	    results = gm.sendkeys(pr.getlocator("reasoning"), "reasoning");
		Mobilewriteresults(results, driver, "Entered reasoning", test,currentTCName);
	    Thread.sleep(2000); 
	    
	    results = gm.click(pr.getlocator("quality"));
		Mobilewriteresults(results, driver, "Click on quality rating", test,currentTCName);
	    Thread.sleep(2000);
	    
	    results = gm.click(pr.getlocator("cost"));
		Mobilewriteresults(results, driver, "Click on cost rating", test,currentTCName);
	    Thread.sleep(2000);
	    
	    results = gm.click(pr.getlocator("ApSubmit"));
		Mobilewriteresults(results, driver, "Click on Submit", test,currentTCName);
	    Thread.sleep(2000);
	    
		extent.endTest(test);
		
		

	}

}
