package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;

public class VendorGroups extends Baseclass{

	static Excelreader er=new Excelreader();
	static ProjectSpecific project=new ProjectSpecific();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");
	public static String email = inputarr[3][1];
	public static String password = inputarr[4][1];
	public static String groupname = inputarr[0][5];
	public static String vendorsearch = inputarr[1][5];

	@Test 
	public static void VendorGroup() throws InterruptedException, IOException

	{
		Thread.sleep(5000);
		String results;
		GenericMethods gm=new GenericMethods();
		Property_Reader pr=new Property_Reader();

		String currentTCName="VendorGroup";

		ExtentTest test = extent.startTest(currentTCName, "VendorGroup add and search");
		
		Thread.sleep(2000);
		project.checklogin(email, password);
		Thread.sleep(3000);

		System.out.println("####VendorGroup#####");
		
		try {
			if (DeviceType.contains("Android")) {
				results = project.menuIcon(pr.getlocator("menuIcon-id"));
				Mobilewriteresults(results, driver, "click on menu button",
						test, currentTCName);
				Thread.sleep(2000);

				results = project.menuIcon(pr.getlocator("Dashboard"));
				Mobilewriteresults(results, driver,
						"click on Dashboard button", test, currentTCName);
				Thread.sleep(2000);
			} else {
				System.out.println("test");
			}
		} catch (Exception e) {
			System.out.println("enter");
		}

		results=project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results,driver,"click on menu button",test,currentTCName);

		Thread.sleep(3000);
		System.out.println("Vendor");
		results = gm.click(pr.getlocator("VendorGroup"));
		Mobilewriteresults(results, driver, "Click on VendorGroup button", test,currentTCName);

		Thread.sleep(2000);
		results = gm.click(pr.getlocator("MechanicalVendorGroup"));
		Mobilewriteresults(results, driver, "Click on Mechanical VendorGroup button", test,currentTCName);

		results = gm.click(pr.getlocator("vgplusbutton"));
		Mobilewriteresults(results, driver, "Click on plus button", test,currentTCName);

		// Enter team name
		Thread.sleep(2000);
		results = gm.sendkeysalert(pr.getlocator("vgCreateSubGroup"), groupname);
		Mobilewriteresults(results, driver, "Enter the SubGroup:"+groupname, test, currentTCName);

		Thread.sleep(2000);
		results = gm.click(pr.getlocator("vgSubmit"));
		Mobilewriteresults(results, driver, "click on Submit button", test,currentTCName);
		Thread.sleep(2000); 
		
		if(negativescenarios.contains("yes"))
		{
			System.out.println("################Negativescenario1:vendorgroup1###################");
			// Enter team name
			results = gm.click(pr.getlocator("vgplusbutton"));
			Mobilewriteresults(results, driver, "Click on plus button", test,currentTCName);
			Thread.sleep(2000);
			results = gm.sendkeysalert(pr.getlocator("vgCreateSubGroup"), groupname);
			Mobilewriteresults(results, driver, "Enter the SubGroup:"+groupname, test, currentTCName);

			Thread.sleep(2000);
			results = gm.click(pr.getlocator("vgSubmit"));
			Mobilewriteresults(results, driver, "click on Submit button", test,currentTCName);
			Thread.sleep(3000); 

			///	/////Verification
			System.out.println("click");
			Thread.sleep(1000);
			project.alertcheck1("okButton-id","okButton-id1",test);
			Thread.sleep(3000);
		
		}
		

		try{
			if(DeviceType.contains("Android"))
			{
				driver.findElementByXPath("//android.widget.TextView[contains(@text,'"+groupname+"')]").click();
				test.log(LogStatus.PASS, "clicked on groupname");
			}
			else
			{
				driver.findElement(By.id(groupname)).click();;
				test.log(LogStatus.PASS, "clicked on groupname");
			}
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "unable to click on groupname");

		}

		
		results = gm.click(pr.getlocator("vgplusbutton"));
		Mobilewriteresults(results, driver, "click on plusbutton button", test,currentTCName);

		Thread.sleep(2000);



		if(negativescenarios.contains("yes"))
		{
			System.out.println("################Negativescenario2:vendorgroup1###################");
			results = gm.sendkeysalert(pr.getlocator("vgSearch"), "");
			Mobilewriteresults(results, driver, "Enter the vendor name to Search", test,currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("DoneButton-id"));
			Mobilewriteresults(results, driver, "click on done button", test,currentTCName);
			Thread.sleep(1000);
			if(DeviceType.contains("IOS")){
				results = gm.click(pr.getlocator("vgselect"));
				Mobilewriteresults(results, driver, "click search button ", test,currentTCName);
			}


			///	/////Verification
			Thread.sleep(2000);
			project.alertcheck("okButton-id","okButton-id",test);

		}


		Thread.sleep(1000);
		results = gm.sendkeysalert(pr.getlocator("vgSearch"), vendorsearch);
		Mobilewriteresults(results, driver, "Enter the vendor name to Search:"+vendorsearch, test,currentTCName);

		Thread.sleep(3000);

		results = gm.click(pr.getlocator("DoneButton-id"));
		Mobilewriteresults(results, driver, "click on done button", test,currentTCName);

		Thread.sleep(2000);    
		results = gm.click(pr.getlocator("vgselect"));
		Mobilewriteresults(results, driver, "Selected the vendor", test,currentTCName);
		Thread.sleep(2000);

		////////////////// 
		if(DeviceType.contains("Android")){
			//android
			results = gm.click(pr.getlocator("DoneButton-id"));
			Mobilewriteresults(results, driver, "Click on Done button", test,currentTCName);
			Thread.sleep(2000);   
			System.out.println("Test group name is:" + pr.getlocator("vendorName").getText());

			//Mechanical vendor group verification
			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "Click on menu button", test,
					currentTCName);
			Thread.sleep(1000);

			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "Click on menu button", test,
					currentTCName);
			Thread.sleep(2000);

			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "Click on menu button", test,
					currentTCName);
			Thread.sleep(2000);


		}

		else
		{
			System.out.println("####ios#####");
			results = gm.click(pr.getlocator("vgselectname"));
			Mobilewriteresults(results, driver, "Click on Vendor2", test,currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("DoneButton-id"));
			Mobilewriteresults(results, driver, "Click on Done button", test,currentTCName);
			Thread.sleep(5000);

			results = gm.click(pr.getlocator("BackToLogin-id"));
			Mobilewriteresults(results, driver, "Click on back button", test,currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("BackToLogin-id"));
			Mobilewriteresults(results, driver, "Click on back button", test,currentTCName);
			Thread.sleep(2000);
		}


		//Mechanical vendor group verification


		results = project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results, driver, "Click on menu button", test,
				currentTCName);
		Thread.sleep(2000);



		results=project.logout(pr.getlocator("logout"));
		Mobilewriteresults(results,driver,"Click on logout button",test,currentTCName);

		extent.endTest(test);


	} 

}
