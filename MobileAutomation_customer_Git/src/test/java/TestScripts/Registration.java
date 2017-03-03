package TestScripts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class Registration extends Baseclass {
	static Excelreader er = new Excelreader();
	static ProjectSpecific project=new ProjectSpecific();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath, "Datasheet");

	public static String fName = inputarr[0][1];
	public static String lName = inputarr[1][1];
	public static String jTitle = inputarr[2][1];
	public static String email = inputarr[3][1];
	public static String cCode = inputarr[5][1];
	public static String pNumber = inputarr[6][1];

	public static String compName = inputarr[8][1];
	public static String taxID =  inputarr[9][1];
	public static String CompEmail =  inputarr[10][1];

	public static String compPhoneNumber =  inputarr[12][1];
	public static String AddLine1 =  inputarr[13][1];
	public static String AddLine2 =  inputarr[14][1];
	public static String city =  inputarr[15][1];
	public static String state =  inputarr[16][1];
	public static String country = inputarr[17][1];
	public static String zip = inputarr[18][1];
	public static WebElement resigterbutton;


	@Test
	public static void Registration() throws InterruptedException, IOException

	{
		String results;

		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "Registration";
		ExtentTest test = extent.startTest(currentTCName,"Registration CustomerApp");
		Thread.sleep(2000);



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

		try
		{
			WebElement menuIcon=pr.getlocator("menuIcon-id");
			if(menuIcon.isDisplayed())
			{
				results=project.menuIcon(pr.getlocator("menuIcon-id"));	
				results=project.logout(pr.getlocator("logout"));	
				Thread.sleep(1000);
			}

			else
			{	
				Thread.sleep(1000);
				System.out.println("Registration page");

			}
		}

		catch(Exception e)
		{

		}
        Thread.sleep(5000);
		System.out.println("####Registration#####");
		
		Thread.sleep(2000);
		results = gm.click(pr.getlocator("RegisterNow-id"));
		Mobilewriteresults(results, driver, "click on register now button",test, currentTCName);
		Thread.sleep(3000);

		try{
			if(DeviceType.contains("Android"))
			{
				
			}
			else
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
			
				
			
		}
		catch(Exception e){		
		}
		
		if(DeviceType.contains("IOS"))
		{
			GenericMethods.scrollios("down");
			Thread.sleep(1000); 
			resigterbutton = driver.findElement(By.id("REGISTER"));
			System.out.println(resigterbutton);	
		}
		
		results = gm.click(pr.getlocator("RegisterCompanyCheckbox-id"));
		Mobilewriteresults(results, driver, "click on RegisterCompany checkbox", test,
				currentTCName);
		Thread.sleep(1000);


		try{
			if(DeviceType.contains("Android"))
			{
				Thread.sleep(1000);
				driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
                System.out.println("test");
			}	
		}
		catch(Exception e){		
		}

		Thread.sleep(2000); 
		results = gm.sendkeys(pr.getlocator("FirstName-id"), fName);
		Mobilewriteresults(results, driver, "Entered First Name:"+fName, test,
				currentTCName);

		results = gm.sendkeys(pr.getlocator("LastName-id"), lName);
		Mobilewriteresults(results, driver, "Entered Last Name:"+lName, test,
				currentTCName);


		results = gm.sendkeys(pr.getlocator("JobTitle-id"), jTitle);
		Mobilewriteresults(results, driver, "Entered JobTitle:"+jTitle, test,
				currentTCName);

		results = gm.sendkeys(pr.getlocator("RegisterEmail-id"), email);
		Mobilewriteresults(results, driver, "Entered Email:"+email, test, currentTCName);


		results = gm.sendkeys(pr.getlocator("RegisterCountryCode-id"), cCode);
		Mobilewriteresults(results, driver, "Entered CountryCode:"+cCode, test,
				currentTCName);

		results = gm.sendkeys(pr.getlocator("RegisterPhoneNum-id"), pNumber);
		Mobilewriteresults(results, driver, "Entered PhoneNumber:"+pNumber, test,currentTCName);
		Thread.sleep(1000);

		if(DeviceType.contains("Android"))
		{
		driver.scrollTo("Company Details");
		Thread.sleep(1000); 
		}
		else
		{

		}

		results = gm.sendkeys(pr.getlocator("CompanyName-id"), compName);
		Mobilewriteresults(results, driver, "Entered Company Name:"+compName, test,currentTCName);

		results = gm.sendkeys(pr.getlocator("Companytax-id"), taxID);
		Mobilewriteresults(results, driver, "Entered TaxID:"+compName, test, currentTCName);
		Thread.sleep(1000);


		results = gm.sendkeys(pr.getlocator("CompanyEmail-id"), CompEmail);
		Mobilewriteresults(results, driver, "Entered Company Email:"+CompEmail, test, currentTCName);


		results = gm.sendkeys(pr.getlocator("CompCountryCode-id"), cCode);
		Mobilewriteresults(results, driver, "Entered Company CountryCode:"+cCode, test,currentTCName);


		results = gm.sendkeys(pr.getlocator("CompanyPhoneNumber-id"),compPhoneNumber);
		Mobilewriteresults(results, driver, "Entered Company PhoneNumber:"+compPhoneNumber, test,currentTCName);


		results = gm.sendkeys(pr.getlocator("CompAddressLine1-id"), AddLine1);
		Mobilewriteresults(results, driver, "Entered AddressLine1:"+AddLine1, test,currentTCName);

		results = gm.sendkeys(pr.getlocator("CompAddreddLine2-id"), AddLine2);
		Mobilewriteresults(results, driver, "Entered AddressLine2:"+AddLine2, test,currentTCName);

		results = gm.sendkeys(pr.getlocator("CompRegisterCity-id"), city);
		Mobilewriteresults(results, driver, "Entered City"+city, test,currentTCName);


		if(DeviceType.contains("Android")){

		}
		else
		{
			GenericMethods.scrollios("down");
			Thread.sleep(1000); 


		}

		results = gm.sendkeys(pr.getlocator("CompRegisterState-id"), state);
		Mobilewriteresults(results, driver, "Entered State:"+state, test,currentTCName);


		if(DeviceType.contains("Android")){ 
			results = gm.sendkeys(pr.getlocator("CompRegisterCountry-id"), country);
			Mobilewriteresults(results, driver, "Entered country:"+country, test,
					currentTCName);
			Thread.sleep(1000);

			results = gm.sendkeys(pr.getlocator("CompRegisterZip-id"), zip);
			Mobilewriteresults(results, driver, "Entered zip:"+zip, test,currentTCName);
			Thread.sleep(1000);

		}
		else

		{
			results = gm.sendkeys(pr.getlocator("CompRegisterZip-id"), zip);
			Mobilewriteresults(results, driver, "Entered Zip:"+zip, test,currentTCName);

			results = gm.sendkeys(pr.getlocator("CompRegisterCountry-id"), country);
			Mobilewriteresults(results, driver, "Enter country:"+country, test,currentTCName);


			GenericMethods.scrollios("down");
			Thread.sleep(2000); 

		}	
		results = gm.click(pr.getlocator("WorkType-id"));
		Mobilewriteresults(results, driver, "selected work type check box",test, currentTCName);
		Thread.sleep(1000);

		if(DeviceType.contains("Android")){
			gm.scrollandroid("Register");
			Thread.sleep(1000);
		}
		else
		{
			GenericMethods.scrollios("down");
			Thread.sleep(1000);
		}

	
		try{
			
		
		   if(DeviceType.contains("Android"))
			{
			   
			results = gm.click(pr.getlocator("RegisterButton-id"));
			Mobilewriteresults(results, driver, "clicked on Register button", test,	currentTCName);
			Thread.sleep(4000); 
			
			 System.out.println("Android register button"); 
				if(pr.getlocator("BackToLogin-id").isDisplayed()){
					
					results = gm.click(pr.getlocator("BackToLogin-id"));
					Mobilewriteresults(results, driver, "clicked on Back To Login button", test,	currentTCName);
					Thread.sleep(2000);
					test.log(LogStatus.INFO, "Registration successfull");
				}
				
				else
				{		
				 //  driver.navigate().back();
                   //test.log(LogStatus.ERROR, "Registration unsuccessfull");
				}	


			}
			
			else
			{
            System.out.println("IOS register button");
				resigterbutton.click();
				Thread.sleep(2000);
				
				if(pr.getlocator("regBackToLogin").isDisplayed()){
					results = gm.click(pr.getlocator("regBackToLogin"));
					Mobilewriteresults(results, driver, "clicked on Back To Login button", test,	currentTCName);
					test.log(LogStatus.INFO, "Registration successfull");
				}
				
				else
				{
					//driver.navigate().back();
					//test.log(LogStatus.ERROR, "Registration unsuccessfull");
				}	
			} 
		   
	}
		catch(Exception e){
			
			if(DeviceType.contains("Android")){
				driver.navigate().back();
				test.log(LogStatus.ERROR, "Registration unsuccessfull");
			}
			else
			{
				Thread.sleep(2000);
				driver.findElement(By.id("Dismiss")).click();
				driver.navigate().back();
				test.log(LogStatus.FAIL, "Registration unsuccessfull");
			}
	
		}

		

		extent.endTest(test);

	}

}
