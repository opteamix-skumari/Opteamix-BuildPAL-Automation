package TestScripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IncidentFormDelegatedCustomerSuperAdmin extends Baseclass {

	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");

	public static String Email = inputarr[5][7];
	public static String Password = inputarr[4][1];
	public static String SuperAdminEmail = inputarr[6][7];

	public static String IRJobName = inputarr[0][7];
	public static String IRPincode = inputarr[1][7];
	public static String  IRCity="maddur";
	public static String IRWorkTypeJobName = inputarr[2][7];
	public static String Startdate = inputarr[7][7];
	public static String completiondate = inputarr[8][7];

	@Test
	public static void IncidentFormDelegatedCustomerSuperAdmin() throws InterruptedException, IOException {
		//
		Thread.sleep(3000);
		System.out.println(Email);
		System.out.println(Password);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "IncidentFormDelegatedCustomerSuperAdmin";

		ExtentTest test = extent.startTest(currentTCName,"IncidentForm CustomerApp");


		if(pr.path.contains("IOS"))
		{
			try{
				Alert al=driver.switchTo().alert();
				al.accept();
				Thread.sleep(1000);
				Alert al1=driver.switchTo().alert();
				al1.accept();

				Thread.sleep(1000);	
			}
			catch(Exception e){
				System.out.println("alert pop not displayed");
			}

		}

		Thread.sleep(2000);
		project.checklogin(Email, Password);
		Thread.sleep(5000);
		System.out.println("####IncidentFormDelegatedCustomerSuperAdmin#####");


		if(DeviceType.contains("IOS"))
		{

			Thread.sleep(3000);
			// Click on Plus Icon
			System.out.println("plus");
			results = gm.click(pr.getlocator("IRPlusbutton"));
			Mobilewriteresults(results, driver, "click on Plus Icon", test,currentTCName);

			System.out.println("IRJobName");
			results = gm.sendkeys(pr.getlocator("IRJobName"), IRJobName);
			Mobilewriteresults(results, driver, "IRJobName", test, currentTCName);
			Thread.sleep(1000);

			System.out.println("IRSiteLocation");
			results = gm.click(pr.getlocator("IRSiteLocation"));
			Mobilewriteresults(results, driver, "click on site location", test,currentTCName);
			Thread.sleep(5000);


			results = gm.click(pr.getlocator("IREdit"));
			Mobilewriteresults(results, driver, "click on  Edit button", test,currentTCName);
			Thread.sleep(2000);

			results = gm.sendkeys(pr.getlocator("IRAddressLine1"), "jpnagar");
			results = gm.sendkeys(pr.getlocator("IRAddressLine2"), "6th phase");
			results = gm.sendkeys(pr.getlocator("IRCity"), IRCity);
			results = gm.sendkeys(pr.getlocator("IRState"), "karnataka");
            results = gm.sendkeys(pr.getlocator("IRPincode"), IRPincode);
			results = gm.sendkeys(pr.getlocator("IRCountry"), "India");


			results = gm.click(pr.getlocator("IRSaveButton"));
			Mobilewriteresults(results, driver, "click on  save button", test,currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("IRTeam"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("IRRole"));
			Mobilewriteresults(results, driver, "click on  Role", test,currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);
			Thread.sleep(1000);

			if(negativescenarios.contains("yes")){
				System.out.println("################Negativescenario1:customerrequestor###################");	

				System.out.println("iosssssss down");
				GenericMethods.scrollios("down");

				Thread.sleep(1000);
				results = gm.click(pr.getlocator("SubmitForApproval"));
				Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
						currentTCName);

				project.alertcheck("okButton-id","okButton-id",test);
				Thread.sleep(2000);
			}



			results = gm.click(pr.getlocator("IRCostType1"));
			Mobilewriteresults(results, driver, "Selecting cost type", test,currentTCName);
			Thread.sleep(1000);


			// Clicking Add Work Type
			results = gm.click(pr.getlocator("IRAddWorkType"));
			Mobilewriteresults(results, driver, "clicking AddWorkType", test,
					currentTCName);
			Thread.sleep(2000);
			
			
			if(negativescenarios.contains("yes")){
				System.out.println("################Negativescenario2:customerrequestor###################");	
				Thread.sleep(1000);
				results = gm.click(pr.getlocator("Icsave"));
				Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
						currentTCName);

				project.alertcheck("okButton-id","okButton-id",test);
				Thread.sleep(2000);
			}

			results = gm.click(pr.getlocator("IRWorkType"));
			Mobilewriteresults(results, driver, "clicking WorkType", test,
					currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);
			Thread.sleep(1000);
			results = gm.sendkeys(pr.getlocator("IRWorkTypeJobName"),IRWorkTypeJobName);
			Mobilewriteresults(results, driver, "IRWorkTypeJobName", test,
					currentTCName);
			Thread.sleep(2000);	



			// Start Date
			results = gm.click(pr.getlocator("IRStartDate"));
			Mobilewriteresults(results, driver, "Clicking on Start Date ", test,
					currentTCName);
			Thread.sleep(2000);

			IOSElement picker= (IOSElement) new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeDatePicker//XCUIElementTypePickerWheel")));
			picker.setValue(Startdate);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);



			// Start Time
			results = gm.click(pr.getlocator("IRStartTime"));
			Mobilewriteresults(results, driver, "Clicking on Start time", test,currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "click on  Team", test,currentTCName);

			// Completion Date
			results = gm.click(pr.getlocator("IRCompletionDate"));
			Mobilewriteresults(results, driver, "Clicking on Completion Date",test, currentTCName);
			Thread.sleep(1000);

			IOSElement picker1= (IOSElement) new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeDatePicker//XCUIElementTypePickerWheel")));
			picker1.setValue(completiondate);
			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,currentTCName);
			Thread.sleep(1000);


			GenericMethods.scrollios("down");
			// Completion Time
			results = gm.click(pr.getlocator("IRCompletionTime"));
			Mobilewriteresults(results, driver, "Clicking on Completion Time",test, currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,currentTCName);
			Thread.sleep(1000);


			// Entering Materials data
			results = gm.click(pr.getlocator("IRMaterialsDropDown"));
			Mobilewriteresults(results, driver, "Clicking on Materials", test,currentTCName);
			Thread.sleep(2000);
			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,currentTCName);
			Thread.sleep(2000);

			// Entering Estimated staff Required
			results = gm.click(pr.getlocator("IREstimatedStaffrequired"));
			Mobilewriteresults(results, driver,
					"Clicking on EstimatedStaffrequired", test, currentTCName);
			Thread.sleep(2000);


			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(1000);

			results = gm.click(pr.getlocator("IREquipmentDropDown"));
			Mobilewriteresults(results, driver, "Clicking on Equipment", test,
					currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("customizeddone"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(1000);


			// Clicking Check box
			results = gm.click(pr.getlocator("CheckboxHazardousMaterials"));
			Mobilewriteresults(results, driver, "Clicking on checkbox", test,
					currentTCName);
			Thread.sleep(2000);


			// Clicking on Tick button
			results = gm.click(pr.getlocator("Icsave"));
			Mobilewriteresults(results, driver, "click on Tick button", test,
					currentTCName);
			GenericMethods.scrollios("down");

			// Submit for Approval
			results = gm.click(pr.getlocator("SubmitForApproval"));
			Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
					currentTCName);
			Thread.sleep(3000);


			results = gm.click(pr.getlocator("AMOK"));
			Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
					currentTCName);
			Thread.sleep(5000);



			// Verification Points
			String allbuttonJobName = pr.getlocator("IncidentJobName").getText();
			System.out.println("Job Name is :"+ allbuttonJobName);
			Thread.sleep(2000);

			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,currentTCName);

			results = project.logout(pr.getlocator("logout"));
			Mobilewriteresults(results, driver, "click on logout button", test,currentTCName);



			project.checklogin(SuperAdminEmail, Password);
			Thread.sleep(2000);

			// Verification Points
			System.out.println("Reading the job name........wait");
			String allbuttonSuperAdminJobName = pr.getlocator("IncidentJobName").getText();
			System.out.println("Job Name is :" + allbuttonSuperAdminJobName);
			Thread.sleep(2000);


			if(allbuttonJobName.contains(allbuttonSuperAdminJobName)){
				test.log(LogStatus.INFO, "Job name matched");
			}
			else{
				test.log(LogStatus.ERROR, "Job name not matched");
			}




			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,currentTCName);
			Thread.sleep(1000);
			results = project.logout(pr.getlocator("logout"));
			Mobilewriteresults(results, driver, "click on logout button", test,currentTCName);
		}
		///////Android/////////////////
		else
		{

			// Click on Plus Icon
			Thread.sleep(5000);
			results = gm.click(pr.getlocator("IRPlusbutton"));
			Mobilewriteresults(results, driver, "click on Plus Icon", test,currentTCName);
			Thread.sleep(4000);
			// Incident Request Form

			results = gm.sendkeys(pr.getlocator("IRJobName"), IRJobName);
			Mobilewriteresults(results, driver, "IRJobName", test, currentTCName);


			results = gm.click(pr.getlocator("IRSiteLocation"));
			Mobilewriteresults(results, driver, "click on site location", test,
					currentTCName);
			Thread.sleep(3000);

			try
			{
				if(DeviceType.contains("Android"))
				{
					Thread.sleep(1000);
					driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
					System.out.println("test");
				}	
			}
			catch(Exception e)

			{		

			}
			Thread.sleep(2000);



			// Clicking on MY Location
			results = gm.click(pr.getlocator("IRMyLocation"));
			Mobilewriteresults(results, driver, "click on  MY Location", test,currentTCName);
			Thread.sleep(2000);

			driver.navigate().back();

			Thread.sleep(2000);
			results = gm.click(pr.getlocator("IRSiteLocation"));
			Thread.sleep(3000);
			
			results = gm.click(pr.getlocator("IRMyLocation"));
			Mobilewriteresults(results, driver, "click on  MY Location", test,currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("IREdit"));
			Mobilewriteresults(results, driver, "click on  Edit button", test,
					currentTCName);
			Thread.sleep(2000);

			// Entering Pincode number
			driver.scrollTo("Pincode").click();
			Thread.sleep(2000);
			pr.getlocator("IRPincode").clear();
			Thread.sleep(2000);
			results = gm.sendkeys(pr.getlocator("IRPincode"), IRPincode);
			Mobilewriteresults(results, driver, "IRPincode", test, currentTCName);
			Thread.sleep(2000);

			// clicking on Save button

			results = gm.click(pr.getlocator("IRSaveButton"));
			Mobilewriteresults(results, driver, "click on  save button", test,
					currentTCName);
			Thread.sleep(2000);

			// Selecting Team Name

			results = gm.click(pr.getlocator("IRTeam"));
			Mobilewriteresults(results, driver, "click on  Team", test,
					currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("IRTeam_Engineering"));
			Mobilewriteresults(results, driver, "Selecting Team Name", test,
					currentTCName);
			Thread.sleep(2000);

			// Selecting Role Name

			results = gm.click(pr.getlocator("IRRole"));
			Mobilewriteresults(results, driver, "click on  Role", test,
					currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("IRRole_superAdmin"));
			Mobilewriteresults(results, driver, "Selecting Role Name", test,
					currentTCName);
			Thread.sleep(2000);

			// Selecting Role Name
			if(negativescenarios.contains("yes")){
				System.out.println("################Negativescenario1:customerrequestor###################");	

				driver.swipe(362, 1000, 362, 600, 1000);

				Thread.sleep(1000);
				results = gm.click(pr.getlocator("SubmitForApproval"));
				Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
						currentTCName);

				project.alertcheck("okButton-id","okButton-id",test);
				Thread.sleep(2000);
			}


			// Select radio button Cost Type
			results = gm.click(pr.getlocator("IRCostType1"));
			Mobilewriteresults(results, driver, "Selecting cost type", test,
					currentTCName);
			Thread.sleep(2000);

			// Select Severity
			results = gm.click(pr.getlocator("IRSeverity"));
			Mobilewriteresults(results, driver, "Selecting Check box Emergency",
					test, currentTCName);
			Thread.sleep(2000);

			// Clicking Add Work Type
			results = gm.click(pr.getlocator("IRAddWorkType"));
			Mobilewriteresults(results, driver, "clicking AddWorkType", test,
					currentTCName);
			Thread.sleep(2000);

			if(negativescenarios.contains("yes")){
				System.out.println("################Negativescenario2:customerrequestor###################");	
				Thread.sleep(1000);
				results = gm.click(pr.getlocator("AMOK"));
				Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
						currentTCName);

				project.alertcheck("okButton-id","okButton-id",test);
				Thread.sleep(2000);
			}
			
			results = gm.click(pr.getlocator("IRWorkType"));
			Mobilewriteresults(results, driver, "clicking WorkType", test,
					currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("IRSelectWorkType_Mechanical"));
			Mobilewriteresults(results, driver, "Selecting WorkType", test,
					currentTCName);
			Thread.sleep(2000);

			results = gm.sendkeys(pr.getlocator("IRWorkTypeJobName"),
					IRWorkTypeJobName);
			Mobilewriteresults(results, driver, "IRWorkTypeJobName", test,
					currentTCName);
			Thread.sleep(4000);

			// Start Date
			results = gm.click(pr.getlocator("IRStartDate"));
			Mobilewriteresults(results, driver, "Clicking on Start Date ", test,
					currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("OKButton"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(3000);

			// Start Time
			results = gm.click(pr.getlocator("IRStartTime"));
			Mobilewriteresults(results, driver, "Clicking on Start time", test,
					currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("OKButton"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(3000);

			// Completion Date
			results = gm.click(pr.getlocator("IRCompletionDate"));
			Mobilewriteresults(results, driver, "Clicking on Completion Date",
					test, currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("OKButton"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(3000);

			// Completion Time
			results = gm.click(pr.getlocator("IRCompletionTime"));
			Mobilewriteresults(results, driver, "Clicking on Completion Time",
					test, currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("OKButton"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(3000);

			// Entering Materials data
			results = gm.click(pr.getlocator("IRMaterialsDropDown"));
			Mobilewriteresults(results, driver, "Clicking on Materials", test,
					currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("IRMaterials_CustomerProvides"));
			Mobilewriteresults(results, driver, "Selecting Data from Drop down",
					test, currentTCName);
			Thread.sleep(3000);
			driver.swipe(362, 1000, 362, 300, 1000);
			Thread.sleep(1000);
			// Entering Estimated staff Required
			results = gm.click(pr.getlocator("IREstimatedStaffrequired"));
			Mobilewriteresults(results, driver,
					"Clicking on EstimatedStaffrequired", test, currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("NumberPicker"));
			Mobilewriteresults(results, driver, "Selecting Data from Drop down",
					test, currentTCName);
			Thread.sleep(3000);

			results = gm.click(pr.getlocator("OKButton"));
			Mobilewriteresults(results, driver, "Clicking on okbutton", test,
					currentTCName);
			Thread.sleep(3000);

			driver.scrollTo("Equipment");
			Thread.sleep(3000);
			// Entering Equipment data
			results = gm.click(pr.getlocator("IREquipmentDropDown"));
			Mobilewriteresults(results, driver, "Clicking on Equipment", test,
					currentTCName);
			Thread.sleep(4000);

			results = gm.click(pr.getlocator("IREquipment_CustomerProvides"));
			Mobilewriteresults(results, driver, "Selecting Data from Drop down",
					test, currentTCName);
			Thread.sleep(3000);

			// Clicking Check box
			results = gm.click(pr.getlocator("CheckboxHazardousMaterials"));
			Mobilewriteresults(results, driver, "Clicking on checkbox", test,
					currentTCName);
			Thread.sleep(3000);

			// Clicking on Tick button
			results = gm.click(pr.getlocator("AMOK"));
			Mobilewriteresults(results, driver, "click on Tick button", test,
					currentTCName);
			Thread.sleep(2000);

			// Scrolling submit for approval
			gm.scrollandroid("SUBMIT FOR APPROVAL");
			Thread.sleep(2000);

			// Submit for Approval
			results = gm.click(pr.getlocator("SubmitForApproval"));
			Mobilewriteresults(results, driver, "click on SubmitForApproval", test,
					currentTCName);
			Thread.sleep(4000);

			// Verification Points
			String allbuttonJobName = pr.getlocator("IncidentJobName").getText();
			System.out.println("Job Name is :" + allbuttonJobName);
			Thread.sleep(3000);
			/*
			// clicking Approved button
			List<WebElement> incidents = driver
					.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
			incidents.get(2).click();
			Thread.sleep(4000);

			// Verification Points
			String ApprovedbuttonJobName = pr.getlocator("IncidentJobName")
					.getText();
			System.out.println("Job Name is :" + ApprovedbuttonJobName);
			Thread.sleep(3000);

			Assert.assertEquals(allbuttonJobName, ApprovedbuttonJobName, "fail");
			Thread.sleep(3000);*/

			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,
					currentTCName);

			results = project.logout(pr.getlocator("logout"));
			Mobilewriteresults(results, driver, "click on logout button", test,
					currentTCName);

			project.checklogin(SuperAdminEmail, Password);
			Thread.sleep(3000);

			// Verification Points
			String allbuttonSuperAdminJobName = pr.getlocator("IncidentJobName").getText();
			System.out.println("Job Name is :" + allbuttonSuperAdminJobName);
			Thread.sleep(3000);
			Assert.assertEquals(allbuttonJobName, allbuttonSuperAdminJobName, "fail");
			Thread.sleep(3000);


			results = project.menuIcon(pr.getlocator("menuIcon-id"));
			Mobilewriteresults(results, driver, "click on menu button", test,
					currentTCName);

			results = project.logout(pr.getlocator("logout"));
			Mobilewriteresults(results, driver, "click on logout button", test,
					currentTCName);
		}
		extent.endTest(test);


	}
}
