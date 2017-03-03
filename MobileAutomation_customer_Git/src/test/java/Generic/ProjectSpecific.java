package Generic;

import io.appium.java_client.MobileElement;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProjectSpecific extends Baseclass {

	String results;
	GenericMethods gm = new GenericMethods();
	Property_Reader pr = new Property_Reader();
	static Excelreader er = new Excelreader();
	static ProjectSpecific project = new ProjectSpecific();


	//############################### Explicit wait #############################################
	
		public static void Explicit_wait(WebElement wle, long T1) {
			WebDriverWait wait = new WebDriverWait(driver, T1);
			wait.until(ExpectedConditions.visibilityOf(wle));
		}
		
		//############################### menu icon #############################################
		
	public static String menuIcon(WebElement element)throws InterruptedException, IOException

	{
		try {
			if (DeviceType.contains("Android")) {
				//WebDriverWait wait = new WebDriverWait(driver, 30);
				//wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				Thread.sleep(500);

			} 
			else 
			{
				//WebDriverWait wait = new WebDriverWait(driver, 30);
				//wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
			}
			return Constants.KEYWORD_PASS;
			
		} catch (Exception e) {
			System.out.println("Unable to find element: " + element);
		}
		return Constants.KEYWORD_FAIL;

	}
	
	//############################### logout #############################################
	
	public String logout(WebElement element) throws InterruptedException,
			IOException

	{
		try {
			Thread.sleep(500);
			if (DeviceType.contains("Android")) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				Thread.sleep(2000);
				driver.findElement(By.id("android:id/button1")).click();

			} else {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				Thread.sleep(500);
				driver.findElement(By.id("OK")).click();

			}
			return Constants.KEYWORD_PASS;
		} catch (Exception e) {
			System.out.println("Unable to find element: " + element);
		}
		return Constants.KEYWORD_FAIL;

	}
	
	public String checklogin(String email,String password) throws InterruptedException, IOException

	{
		try{
			Thread.sleep(500);
			WebElement element=pr.getlocator("Email/PhoneNum-id");
			if(element.isDisplayed())	
			{
			results=gm.sendkeys(pr.getlocator("Email/PhoneNum-id"),email);
		    results=gm.sendkeys(pr.getlocator("Password-id"), password);
			results=gm.click(pr.getlocator("Login-id"));	
			}
			else
			{
				System.out.println("logged in");
				
			}
			return Constants.KEYWORD_PASS;
		}
	
			catch(Exception e)
				{
			//	System.out.println(e);
				}
			
		
		return Constants.KEYWORD_FAIL;

	}
	
	public  void alertcheck(String iosbutton,String Androidbutton,ExtentTest test){
		Property_Reader pr=new Property_Reader();
		try
		{

			if(DeviceType.contains("Android"))
			{	
				String message =null;
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]")).isDisplayed())
				{
					Thread.sleep(2000);
					message=pr.getlocator("message").getText();
					System.out.println(message);
					test.log(LogStatus.INFO, message);
				}
				else
				{
					System.out.println(message);
					test.log(LogStatus.FAIL,message);
				}
			String	results=gm.click(pr.getlocator(Androidbutton));

			}
			else
			{	
				Alert al1=driver.switchTo().alert();
				String validationmessage=al1.getText();
				System.out.println(validationmessage);

				if(validationmessage.contains("Failed"))
				{
					test.log(LogStatus.INFO, validationmessage);
				}
				else{
					test.log(LogStatus.FAIL, validationmessage);
				}

				results=gm.click(pr.getlocator(iosbutton));

			}
		}
		catch(Exception e)
		{
			//System.out.println();
		}
	}
	
	public  void alertcheck1(String iosbutton,String Androidbutton,ExtentTest test){
		Property_Reader pr=new Property_Reader();
		try
		{

			if(DeviceType.contains("Android"))
			{	
				String message =null;
				if(driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]")).isDisplayed())
				{
					Thread.sleep(2000);
					message=pr.getlocator("message1").getText();
					System.out.println(message);
					test.log(LogStatus.INFO, message);
				}
				else
				{
					System.out.println(message);
					test.log(LogStatus.FAIL,message);
				}
			String	results=gm.click(pr.getlocator(Androidbutton));

			}
			else
			{	
				Alert al1=driver.switchTo().alert();
				String validationmessage=al1.getText();
				System.out.println(validationmessage);

				if(validationmessage.contains("Failed"))
				{
					test.log(LogStatus.INFO, validationmessage);
				}
				else{
					test.log(LogStatus.FAIL, validationmessage);
				}

				results=gm.click(pr.getlocator(iosbutton));

			}
		}
		catch(Exception e)
		{
			//System.out.println();
		}
	}
	

}
