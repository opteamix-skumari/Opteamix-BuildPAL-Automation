package TestScripts;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.Baseclass;
import Generic.Constants;
import Generic.Excelreader;
import Generic.ExtentReport;
import Generic.GenericMethods;
import Generic.ProjectSpecific;
import Generic.Property_Reader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login extends Baseclass{

	static Excelreader er=new Excelreader();
	static ProjectSpecific project=new ProjectSpecific();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath, "Datasheet");


	public static String email = inputarr[3][1];
	public static String password = inputarr[4][1];

	@Test 
	public static void login() throws InterruptedException, IOException

	{
		Thread.sleep(2000);
		String results;
		GenericMethods gm=new GenericMethods();
		Property_Reader pr=new Property_Reader();

		String currentTCName="login";
		System.out.println("test");
		ExtentTest test = extent.startTest(currentTCName, "Login CustomerApp");

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
		Thread.sleep(2000);
		System.out.println("################Negativescenario1:Login###################");
		results=gm.sendkeys(pr.getlocator("Email/PhoneNum-id"),"invalid@gmail.com");
		Mobilewriteresults(results,driver,"Entered invalid Email:"+"invalid@gmail.com",test,currentTCName);
		Thread.sleep(2000);

		results=gm.sendkeys(pr.getlocator("Password-id"), password);
		Mobilewriteresults(results,driver,"Entered Password:"+password,test,currentTCName);

		results=gm.click(pr.getlocator("Login-id"));	
		Mobilewriteresults(results,driver,"click on Login button",test,currentTCName);
		Thread.sleep(3000);
		
		///	/////Verification
		project.alertcheck("okButton-id","okButton-id",test);

	
		System.out.println("#################Negativescenario2:Login######################");
		results=gm.sendkeys(pr.getlocator("Email/PhoneNum-id"),"");
		Mobilewriteresults(results,driver,"Blank Email id field:__",test,currentTCName);

		Thread.sleep(2000);

		pr.getlocator("Password-id").clear();
		Thread.sleep(1000);
		results=gm.sendkeys(pr.getlocator("Password-id"), password);
		Mobilewriteresults(results,driver,"Entered Password:"+password,test,currentTCName);

		results=gm.click(pr.getlocator("Login-id"));	
		Mobilewriteresults(results,driver,"click on Login button",test,currentTCName);
		Thread.sleep(3000);
		
		/////Verification
		project.alertcheck("okButton-id","okButton-id",test);
		}
		
		//android.widget.LinearLayout
		System.out.println("##############Positivescenario:Login#################");
		Thread.sleep(8000);
		//	driver.findElement(By.id("Email / Phone Number")).sendKeys(Keys.COMMAND,Keys.SHIFT,Keys.valueOf("k"));
		results=gm.sendkeys(pr.getlocator("Email/PhoneNum-id"),email);
		Mobilewriteresults(results,driver,"Entered Email:"+email,test,currentTCName);
		Thread.sleep(3000);
		
		pr.getlocator("Password-id").clear();
		Thread.sleep(1000);
		results=gm.sendkeys(pr.getlocator("Password-id"), password);
		Mobilewriteresults(results,driver,"Entered Password:"+password,test,currentTCName);

		results=gm.click(pr.getlocator("Login-id"));	
		Mobilewriteresults(results,driver,"click on Login button",test,currentTCName);
		Thread.sleep(4000);


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
