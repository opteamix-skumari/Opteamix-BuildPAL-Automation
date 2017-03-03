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

public class Customer_invitation extends Baseclass {

	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");

	public static String Email = inputarr[3][7];
	public static String Password = inputarr[4][1];

	public static String IRJobName = inputarr[0][7];
	public static String IRPincode = inputarr[1][7];

	public static String IRWorkTypeJobName = inputarr[2][7];

	@Test
	public static void Customer_invitation() throws InterruptedException, IOException {

		Thread.sleep(3000);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "Customer_invitation";

		ExtentTest test = extent.startTest(currentTCName,"Customer_invitation");

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
		System.out.println("####Customer_invitation#####");
		Thread.sleep(4000);



		results=project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results,driver,"click on menu button",test,currentTCName);

		Thread.sleep(2000);
		results = gm.click(pr.getlocator("Invitation"));
		Mobilewriteresults(results, driver, "Click on Invitation button", test,currentTCName);

		Thread.sleep(1000);


		if(negativescenarios.contains("yes"))
		{
			Thread.sleep(1000);
			results = gm.click(pr.getlocator("ivSubmit"));
			Mobilewriteresults(results, driver, "Click on Submit button", test,currentTCName);
			Thread.sleep(1000);
			project.alertcheck("okButton-id","okButton-id",test);
			Thread.sleep(1000);
		}
		results=gm.sendkeys(pr.getlocator("ivFirstName"), "FirstName");
		Mobilewriteresults(results,driver,"Entered FirstName:",test,currentTCName);

		results=gm.sendkeys(pr.getlocator("ivLastName"), "LastName");
		Mobilewriteresults(results,driver,"Entered LastName:",test,currentTCName);

		if(negativescenarios.contains("yes"))
		{
			results=gm.sendkeys(pr.getlocator("ivEmailid"), "Emailidgm.c");
			Mobilewriteresults(results,driver,"Entered Emailid:",test,currentTCName);
			Thread.sleep(1000);
			results = gm.click(pr.getlocator("ivSubmit"));
			Mobilewriteresults(results, driver, "Click on Submit button", test,currentTCName);
			Thread.sleep(1000);
			project.alertcheck("okButton-id","okButton-id",test);
			Thread.sleep(2000);
		}

		results=gm.sendkeys(pr.getlocator("ivEmailid"), "Emailid@gmail.com");
		Mobilewriteresults(results,driver,"Entered Emailid:",test,currentTCName);

		Thread.sleep(1000);
		results = gm.click(pr.getlocator("ivcustomer"));
		Mobilewriteresults(results, driver, "Click on customer checkbox", test,currentTCName);

		results = gm.click(pr.getlocator("ivSubmit"));
		Mobilewriteresults(results, driver, "Click on Submit button", test,currentTCName);

		try{
			if(DeviceType.contains("IOS"))
			{
				Thread.sleep(5000);
				Alert al=driver.switchTo().alert();
				System.out.println(al.getText());
			}
			else
			{
				System.out.println("Android");
			}
		}
		catch(Exception e)
		{
			System.out.println("enter");
		}

		Thread.sleep(1000);
		results = gm.click(pr.getlocator("okButton-id"));
		Mobilewriteresults(results, driver, "Click on Dismiss button", test,currentTCName);

	    
		 // clicking on back arrow
	        results = project.menuIcon(pr.getlocator("menuIcon-id"));
	        Mobilewriteresults(results, driver, "click on menu button", test,
	                    currentTCName);
	        Thread.sleep(3000);

	        // clicking on back arrow
	        
	        try{
		    	if(DeviceType.contains("Android"))
		    	{
		    		 results = project.menuIcon(pr.getlocator("menuIcon-id"));
		    	}
		    	else
		    	{
		    		System.out.println("ios");
		    	}
		    }
		    catch(Exception e)
		    {
		    	System.out.println("enter");
		    }
	        
	        
	        
	       
	        
	        
	        Thread.sleep(2000);
	       
	        results = project.logout(pr.getlocator("logout"));
	        Mobilewriteresults(results, driver, "click on logout button", test,
	                    currentTCName);
	        Thread.sleep(2000);
	        
			 extent.endTest(test);



	}

}
