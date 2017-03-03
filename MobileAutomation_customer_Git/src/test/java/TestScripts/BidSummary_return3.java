package TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BidSummary_return3 extends Baseclass {

	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");

	public static String Email = inputarr[3][7];
	public static String Password = inputarr[4][1];

	public static String IRJobName = inputarr[0][7];
	public static String IRPincode = inputarr[1][7];

	public static String IRWorkTypeJobName = inputarr[2][7];

	@Test
	public static void BidSummary1() throws InterruptedException, IOException {

		Thread.sleep(3000);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "BidSummary";

		ExtentTest test = extent.startTest(currentTCName,"BidSummary Awarded");

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
		Thread.sleep(4000);
		System.out.println("####BidSummary#####");	
		
		results = gm.click(pr.getlocator("Hammericon"));
		Mobilewriteresults(results, driver, "Click on Hammericon", test,currentTCName);
		Thread.sleep(4000);
		
		try
		{
			if(DeviceType.contains("Android")){
				// Bid Summary Page
				List<WebElement> bidSummary = driver
						.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
				bidSummary.get(1).click();
				System.out.println("Click on Pending");
				Thread.sleep(2000);
			}
			else
			{
				results = gm.click(pr.getlocator("Pending"));
				Mobilewriteresults(results, driver, "Click on Pending", test,currentTCName);
			    Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			System.out.println("Enter");
		}
	    
	    Thread.sleep(1000);
		results = gm.click(pr.getlocator("ReturntoVendor"));
		Mobilewriteresults(results, driver, "Click on Return", test,currentTCName);
	    Thread.sleep(2000);
		
		//Return Bid
	    results = gm.sendkeys(pr.getlocator("Commentgoeshere"), "text");
		Mobilewriteresults(results, driver, "Entered First Name:", test,
				currentTCName);
		 Thread.sleep(3000);
		 
		 results = gm.click(pr.getlocator("okButton-id"));
			Mobilewriteresults(results, driver, "Click on okButton", test,currentTCName);
		    Thread.sleep(4000);
		    
		    results = gm.click(pr.getlocator("okButton-id"));
			Mobilewriteresults(results, driver, "Click on okButton", test,currentTCName);
		    Thread.sleep(2000);
		    
		    if(DeviceType.contains("Android"))
		    {
		    	// Clicking on Returned
				Dimension size = driver.manage().window().getSize();
				System.out.println(size);

				int Startx = (int) (size.width * 0.90);
				System.out.println("Startx is  " + Startx);

				int Endx = (int) (size.width * 0.10);
				System.out.println("Endx is " + Endx);

				int Starty = (int) (size.height * 0.50);
				System.out.println("Starty is " + Starty);

				driver.swipe(Startx, Starty, Endx, Starty, 1000);
				Thread.sleep(4000);

				driver.swipe(Startx, Starty, Endx, Starty, 1000);
				Thread.sleep(4000);

				driver.swipe(Startx, Starty, Endx, Starty, 1000);
				Thread.sleep(4000);

		    }
		    else
		    {
		    	System.out.println("Ios");
		    }
		    
		    results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,
					currentTCName);
			Thread.sleep(2000);
			
			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,
					currentTCName);
			Thread.sleep(2000);

			// Logout

			System.out.println("Logout");
			results = project.logout(pr.getlocator("logout"));
			Mobilewriteresults(results, driver, "click on logout button", test,
					currentTCName);

			Thread.sleep(5000);
		    extent.endTest(test);
		
		

	}

}
