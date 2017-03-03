package TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class Forgotpassword extends Baseclass{
	static Excelreader er=new Excelreader();
	static ProjectSpecific project=new ProjectSpecific();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath, "Datasheet");


	public static String email = inputarr[3][1];
	public static String otp = inputarr[19][1];
	public static String newpassword = inputarr[4][1];
	public static String repeatPassword = inputarr[4][1];


	@Test 
	public static void forgotpassword() throws InterruptedException, IOException

	{	
		Thread.sleep(3000);
		String results;
		GenericMethods gm=new GenericMethods();
		Property_Reader pr=new Property_Reader();

		String currentTCName="forgotpassword";
		System.out.println(otp);
		ExtentTest test = extent.startTest(currentTCName, "Forgotpassword CustomerApp");
		Thread.sleep(2000);

		if(pr.path.contains("IOS"))
		{
			try{
				Alert al=driver.switchTo().alert();
				al.accept();
				Thread.sleep(2000);
				Alert al1=driver.switchTo().alert();
				al1.accept();

				Thread.sleep(2000);	
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
				Thread.sleep(2000);
			}
			else
			{	
				System.out.println("login page");

			}
		}
		catch(Exception e)
		{
			//System.out.println();
		}


		
		if(negativescenarios.contains("yes"))
		{
			System.out.println("#####Negative_scenario1:forgotPassword#####");

			results=gm.click(pr.getlocator("forgotPassword-id"));
			Mobilewriteresults(results,driver,"click on Forgotpassword button",test,currentTCName);
			Thread.sleep(2000);

			results=gm.sendkeysalert(pr.getlocator("forgotPasswordEmail-id"), "email@email.com");
			Mobilewriteresults(results,driver,"Entered forgotPassword Email:email@email.com",test,currentTCName);
			Thread.sleep(2000);

			results=gm.click(pr.getlocator("sendButton-id"));	
			Mobilewriteresults(results,driver,"Clicked on Send button",test,currentTCName);
			Thread.sleep(2000);

			project.alertcheck("resetok", "okButton-id", test);
			Thread.sleep(3000);

			if(DeviceType.contains("Android"))
			{	
				results=gm.click(pr.getlocator("cancelButton"));
			Mobilewriteresults(results,driver,"click on cancel button",test,currentTCName);
			Thread.sleep(2000);	

			}


			System.out.println("#####Negative_scenario2:forgotPassword#####");

			results=gm.click(pr.getlocator("forgotPassword-id"));
			Mobilewriteresults(results,driver,"click on Forgotpassword button",test,currentTCName);
			Thread.sleep(2000);

			results=gm.sendkeysalert(pr.getlocator("forgotPasswordEmail-id"), email);
			Mobilewriteresults(results,driver,"Entered forgotPassword Email:" +email,test,currentTCName);
			Thread.sleep(2000);

			results=gm.click(pr.getlocator("sendButton-id"));	
			Mobilewriteresults(results,driver,"Clicked on Send button",test,currentTCName);

			Thread.sleep(8000);
			results=gm.click(pr.getlocator("okButton-id"));	
			Mobilewriteresults(results,driver,"clicked on ok button",test,currentTCName);

			results=gm.sendkeys(pr.getlocator("EnterOTP-id"), otp);
			Mobilewriteresults(results,driver,"Entered OTP:"+otp,test,currentTCName);

			Thread.sleep(2000);
			results=gm.sendkeys(pr.getlocator("EnterNewPassword-id"), newpassword);
			Mobilewriteresults(results,driver,"Entered NewPassword:"+newpassword,test,currentTCName);
			Thread.sleep(2000);

			results=gm.sendkeys(pr.getlocator("EnterRepeatPassword-id"), "password1");
			Mobilewriteresults(results,driver,"Re-entered Password:"+repeatPassword,test,currentTCName);
			Thread.sleep(2000);

			results=gm.click(pr.getlocator("ResetButton-id"));
			Mobilewriteresults(results,driver,"clicked on Reset button",test,currentTCName);

			Thread.sleep(2000);

			project.alertcheck("okButton-id","okButton-id", test);

			results=gm.click(pr.getlocator("ReturnToLogin"));
			Mobilewriteresults(results,driver,"clicked on ReturnToLogin button",test,currentTCName);

			Thread.sleep(2000);
		}
		//resetok


		System.out.println("#####Positive_scenario:forgotPassword#####");
		Thread.sleep(3000);
		results=gm.click(pr.getlocator("forgotPassword-id"));
		Mobilewriteresults(results,driver,"click on Forgotpassword button",test,currentTCName);

		Thread.sleep(2000);
		results=gm.sendkeysalert(pr.getlocator("forgotPasswordEmail-id"), email);
		Mobilewriteresults(results,driver,"Entered forgotPassword Email:"+email,test,currentTCName);
		Thread.sleep(2000);

		results=gm.click(pr.getlocator("sendButton-id"));	
		Mobilewriteresults(results,driver,"Clicked on Send button",test,currentTCName);



		Thread.sleep(8000);
		results=gm.click(pr.getlocator("okButton-id"));	
		Mobilewriteresults(results,driver,"clicked on ok button",test,currentTCName);

		Thread.sleep(2000);

		results=gm.sendkeys(pr.getlocator("EnterOTP-id"), otp);
		Mobilewriteresults(results,driver,"Entered OTP:"+otp,test,currentTCName);

		Thread.sleep(2000);
		results=gm.sendkeys(pr.getlocator("EnterNewPassword-id"), newpassword);
		Mobilewriteresults(results,driver,"Entered NewPassword:"+newpassword,test,currentTCName);
		Thread.sleep(2000);

		results=gm.sendkeys(pr.getlocator("EnterRepeatPassword-id"), repeatPassword);
		Mobilewriteresults(results,driver,"Re-entered Password:"+repeatPassword,test,currentTCName);
		Thread.sleep(2000);

		results=gm.click(pr.getlocator("ResetButton-id"));
		Mobilewriteresults(results,driver,"clicked on Reset button",test,currentTCName);

		Thread.sleep(2000);

		results=gm.click(pr.getlocator("resetok"));	
		Mobilewriteresults(results,driver,"clicked on ok ",test,currentTCName);

		Thread.sleep(2000);

		//Login Page
		project.checklogin(email, newpassword);
		Thread.sleep(6000);

		try
		{

			if(pr.getlocator("menuIcon-id").isDisplayed())
			{	
				test.log(LogStatus.INFO, "Login successfull");	
			}
			else
			{	
				test.log(LogStatus.FAIL, "Login Failed");	

			}
		}
		catch(Exception e)
		{
			//System.out.println();
		}
		results=project.menuIcon(pr.getlocator("menuIcon-id"));
		Mobilewriteresults(results,driver,"click on Menu button",test,currentTCName);

		results=project.logout(pr.getlocator("logout"));
		Mobilewriteresults(results,driver,"click on Logout button",test,currentTCName);

		extent.endTest(test);

	}



}
