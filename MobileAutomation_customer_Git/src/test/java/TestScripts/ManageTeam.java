package TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;

public class ManageTeam extends Baseclass {
	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,"Datasheet");

	public static String email = inputarr[3][1];
	public static String password = inputarr[4][1];
	public static String teamName = inputarr[6][3];
	public static String subTeamName = inputarr[7][3];
	// Add Member
	public static String AMFirstName = inputarr[0][3];
	public static String AMLastName = inputarr[1][3];
	public static String AMJobTitle = inputarr[2][3];
	public static String AMEmail = inputarr[4][3];
	public static String AMCountryCode = inputarr[8][3];
	public static String AMPhoneNumber = inputarr[5][3];
	public static WebElement Addbutton;

	@Test
	public static void ManageTeam() throws InterruptedException, IOException {

		Thread.sleep(5000);
		System.out.println(teamName);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "ManageTeam";

		ExtentTest test = extent.startTest(currentTCName,"ManageTeam CustomerApp");

		Thread.sleep(2000);
		project.checklogin(email, password);

		Thread.sleep(3000);
		
		System.out.println("####ManageTeam#####");
		
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
		
		results = project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results, driver, "click on menu button", test,currentTCName);
		Thread.sleep(3000);
		
		results = gm.click(pr.getlocator("ManageTem"));
		Mobilewriteresults(results, driver, "click on ManageTem button", test,currentTCName);
		Thread.sleep(2000);

		try{
			if(DeviceType.contains("IOS"))
			{

				results = gm.click(pr.getlocator("Accounting"));
				Mobilewriteresults(results, driver, "click on menu button", test,currentTCName);
				Thread.sleep(3000);
			}

			else
			{
				results = gm.click(pr.getlocator("Engineering"));
				Mobilewriteresults(results, driver, "click on menu button", test,currentTCName);
				Thread.sleep(3000);
			}
		}
		catch(Exception e){		
		}

		System.out.println("################Positivescenario1:customerrequestor###################");	
		Thread.sleep(1000);
		// +icon
		results = gm.click(pr.getlocator("PlusIcon"));
		Mobilewriteresults(results, driver, "click on PlusIcon", test,currentTCName);


		results = gm.click(pr.getlocator("AddTeam"));
		Mobilewriteresults(results, driver, "clicked on AddTeam", test,currentTCName);

		// Enter team name
		Thread.sleep(4000);
		results = gm.sendkeysalert(pr.getlocator("TeamName"), AMJobTitle);
		Mobilewriteresults(results, driver, "clicked on  TeamName", test, currentTCName);
		Thread.sleep(2000);

		results = gm.click(pr.getlocator("Submit_Add"));
		Mobilewriteresults(results, driver, "clicked on Submit_Add button", test,
				currentTCName);
		Thread.sleep(2000);
		
		if(negativescenarios.contains("yes")){
			System.out.println("################Negativescenario1:customerrequestor###################");	
			Thread.sleep(1000);
			results = gm.click(pr.getlocator("PlusIcon"));
			Mobilewriteresults(results, driver, "click on PlusIcon", test,currentTCName);


			results = gm.click(pr.getlocator("AddTeam"));
			Mobilewriteresults(results, driver, "clicked on AddTeam", test,currentTCName);

			// Enter team name
			Thread.sleep(4000);
			results = gm.sendkeysalert(pr.getlocator("TeamName"), AMJobTitle);
			Mobilewriteresults(results, driver, "clicked on  TeamName", test, currentTCName);
			Thread.sleep(2000);

			results = gm.click(pr.getlocator("Submit_Add"));
			Mobilewriteresults(results, driver, "clicked on Submit_Add button", test,
					currentTCName);
			Thread.sleep(3000);
			
			project.alertcheck1("okButton-id","okButton-id",test);
			Thread.sleep(2000);
		}

		// Click on plus icon and click on Add user
		System.out.println("################Positivescenario2:customerrequestor###################");
		Thread.sleep(1000);
		results = gm.click(pr.getlocator("PlusIcon"));
		Mobilewriteresults(results, driver, "click on PlusIcon", test,currentTCName);
		Thread.sleep(2000);
		
		
				results = gm.click(pr.getlocator("AddUser"));
				Mobilewriteresults(results, driver, "clicked on Add User ", test,currentTCName);
				Thread.sleep(2000);			
		

		results = gm.sendkeys(pr.getlocator("AMFirstName"), AMFirstName);
		Mobilewriteresults(results, driver, "Entered value in FirstName", test, currentTCName);
		Thread.sleep(1000);

		results = gm.sendkeys(pr.getlocator("AMLastName"), AMLastName);
		Mobilewriteresults(results, driver, "Entered value in LastName", test, currentTCName);
		Thread.sleep(1000);

		results = gm.sendkeys(pr.getlocator("AMJobTitle"), AMJobTitle);
		Mobilewriteresults(results, driver, "Entered value in JobTitle", test, currentTCName);
		Thread.sleep(3000);

		results = gm.sendkeys(pr.getlocator("AMEmail"), AMEmail);
		Mobilewriteresults(results, driver, "Entered value in Email", test, currentTCName);
		Thread.sleep(2000);

		results = gm.sendkeys(pr.getlocator("AMCountryCode"), AMCountryCode);
		Mobilewriteresults(results, driver, "Entered value in CountryCode", test,
				currentTCName);
		Thread.sleep(2000);

		results = gm.sendkeys(pr.getlocator("AMPhoneNumber"), AMPhoneNumber);
		Mobilewriteresults(results, driver, "Entered value in PhoneNumber", test,
				currentTCName);
		Thread.sleep(2000);
		
		if(negativescenarios.contains("yes")){
			System.out.println("################Negativescenario2:customerrequestor###################");	
			Thread.sleep(1000);
			
			try
			{
				if(DeviceType.contains("Android"))
				{
					driver.scrollTo("ADD MEMBER");
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("IOS");
				}
			}catch(Exception e)
			{
				System.out.println("Enter");
			}
			

			results = gm.click(pr.getlocator("AddMember"));
			Mobilewriteresults(results, driver, "click on AddMember", test,currentTCName);
			Thread.sleep(2000);
			
			project.alertcheck("okButton-id","okButton-id",test);
			Thread.sleep(2000);
		}
		
		driver.swipe(362, 300, 362, 1000, 1000);
		Thread.sleep(1000);
		
		System.out.println("################Positivescenario2:customerrequestor###################");
		results = gm.click(pr.getlocator("AMADDButton"));
		Mobilewriteresults(results, driver, "click on ADDButton", test,currentTCName);
		Thread.sleep(3000);


		try
		{
			if(DeviceType.contains("Android")){
				List<WebElement> radiobutton = driver.findElementsById("com.industrialevo.customer:id/select_team_radio_button");
				radiobutton.get(1).click();
				Thread.sleep(3000);

				List<WebElement> checkbox = driver.findElementsById("com.industrialevo.customer:id/select_role_checkbox");
				checkbox.get(0).click();
				Thread.sleep(3000);	

				results = gm.click(pr.getlocator("AMOK"));
				Mobilewriteresults(results, driver, "click on Tick button", test,
						currentTCName);
				Thread.sleep(2000);

				driver.scrollTo("ADD MEMBER");
				Thread.sleep(3000);
			}

			else
			{
				results = gm.click(pr.getlocator("AMCheckBox"));
				Mobilewriteresults(results, driver, "Selected the checkbox", test,
						currentTCName);
				Thread.sleep(2000);


				results = gm.click(pr.getlocator("AMOK"));
				Mobilewriteresults(results, driver, "click on Tick button", test,
						currentTCName);
				Thread.sleep(2000);

				results = gm.click(pr.getlocator("AMCheckBox"));
				Mobilewriteresults(results, driver, "click on Tick button", test,
						currentTCName);
				Thread.sleep(2000);

				results = gm.click(pr.getlocator("mtplus"));
				Mobilewriteresults(results, driver, "click on Tick button", test,currentTCName);
				Thread.sleep(1000);	
				gm.scrollios("down");
				Thread.sleep(500);
				gm.scrollios("down");
			}

		}
		catch(Exception e){
			System.out.println(e);
		}



		try{
			if(DeviceType.contains("Android")){

				results = gm.click(pr.getlocator("AddMember"));
				Mobilewriteresults(results, driver, "click on AddMember", test,currentTCName);
			}


			else
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeOther[6]/XCUIElementTypeOther")).click();
			}
		}
		catch(Exception e)
		{

		}



		Thread.sleep(2000);
		try{
			if(DeviceType.contains("Android")){
				results = gm.click(pr.getlocator("okbutton"));
				Mobilewriteresults(results, driver, "click on ok button", test,
						currentTCName);
				Thread.sleep(2000);
				for(int i=0;i<4;i++){
					results = project.menuIcon(pr.getlocator("menuIcon-id"));
					Mobilewriteresults(results, driver, "click on menu button", test,
							currentTCName);
					Thread.sleep(1000);
				}
			}
			else
			{
				results = gm.click(pr.getlocator("AMOK"));
				Mobilewriteresults(results, driver, "click on Tick button", test,currentTCName);

				Thread.sleep(2000);
				results = project.menuIcon(pr.getlocator("BackToLogin-id"));
				Mobilewriteresults(results, driver, "click on BackToLogin", test,currentTCName);

			}
		}
		catch(Exception e){
			System.out.println(e);
		}


		results = project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results, driver, "click on menu button", test,
				currentTCName);
		Thread.sleep(1000);

		results = project.logout(pr.getlocator("logout"));
		Mobilewriteresults(results, driver, "click on logout button", test,
				currentTCName);
		Thread.sleep(2000);

		//Verification	
		project.checklogin(AMEmail, password);
		Thread.sleep(2000);

		if(pr.getlocator("menuIcon-id").isDisplayed())
		{
			test.log(LogStatus.INFO, "user successfully logged in with new credentials");
		}
		else
		{
			test.log(LogStatus.WARNING, "user unable logged in with new credentials");
		}

		results = project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results, driver, "click on menu button", test,
				currentTCName);
		Thread.sleep(2000);
		try
		{
			if(DeviceType.contains("Android"))
				{
				results = gm.click(pr.getlocator("Settings"));
				Mobilewriteresults(results, driver, "click on logout button", test,
						currentTCName);
				Thread.sleep(2000);

				results = gm.click(pr.getlocator("Profile"));
				Mobilewriteresults(results, driver, "click on logout button", test,
						currentTCName);
				Thread.sleep(4000);

				// Veridication points
				System.out.println("Roles name is" + pr.getlocator("Roles").getText());
				Thread.sleep(3000);
				
				System.out.println("Teams name is" + pr.getlocator("Teams").getText());
				Thread.sleep(3000);

				results = gm.click(pr.getlocator("AMOK"));
				Mobilewriteresults(results, driver, "click on Tick button", test,
						currentTCName);
				Thread.sleep(2000);

				results = gm.click(pr.getlocator("okbutton"));
				Mobilewriteresults(results, driver, "click on ok button", test,
						currentTCName);
				Thread.sleep(3000);

				results = project.menuIcon(pr.getlocator("menuIcon-id"));
				Mobilewriteresults(results, driver, "click on menu button", test,
						currentTCName);
				Thread.sleep(2000);
				}
			else{
				System.out.println("IOS");
		}
		}catch(Exception e)
		{
			System.out.println("Enter");
		}

		results = project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results, driver, "click on menu button", test,
				currentTCName);
		Thread.sleep(2000);
		
		results = project.logout(pr.getlocator("logout"));
		Mobilewriteresults(results, driver, "click on logout button", test,
				currentTCName);
		Thread.sleep(2000);

		extent.endTest(test);

	}
}
