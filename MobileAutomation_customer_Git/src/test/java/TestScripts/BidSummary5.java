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

public class BidSummary5 extends Baseclass {

	static ProjectSpecific project = new ProjectSpecific();
	static Excelreader er = new Excelreader();
	static String[][] inputarr = er.readinfxlsfilepoi(Constants.xlpath,
			"Datasheet");

	public static String Email = inputarr[3][7];
	public static String Password = inputarr[4][1];

	public static String IRJobName = inputarr[0][7];
	public static String IRPincode = inputarr[1][7];

	public static String IRWorkTypeJobName = inputarr[2][7];

	@Test
	public static void BidSummary() throws InterruptedException, IOException {

		Thread.sleep(3000);
		String results;
		GenericMethods gm = new GenericMethods();
		Property_Reader pr = new Property_Reader();
		String currentTCName = "BidSummary";

		ExtentTest test = extent.startTest(currentTCName, "BidSummary Awarded");

		if (pr.path.contains("IOS")) {
			try {
				Alert al = driver.switchTo().alert();
				al.accept();
				Thread.sleep(1000);
				Alert al1 = driver.switchTo().alert();
				al1.accept();
			} catch (Exception e) {
				System.out.println("alert pop not displayed");
			}

		}

		Thread.sleep(2000);
		project.checklogin(Email, Password);
		System.out.println("####BidSummary#####");
		Thread.sleep(4000);

		results = gm.click(pr.getlocator("Hammericon"));
		Mobilewriteresults(results, driver, "Click on Hammericon", test,
				currentTCName);
		Thread.sleep(4000);

		try {
			if (DeviceType.contains("Android")) {
				// Bid Summary Page
				List<WebElement> bidSummary = driver
						.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
				bidSummary.get(1).click();
				Thread.sleep(3000);

				// Verification points
				String BidSummaryVendorName = pr.getlocator("VendorName")
						.getText();
				System.out.println("Vendor Name is :" + BidSummaryVendorName);
				Thread.sleep(3000);

				results = gm.click(pr.getlocator("Award"));
				Mobilewriteresults(results, driver, "click on Award", test,
						currentTCName);
				Thread.sleep(4000);

				results = gm.click(pr.getlocator("AlertOkButton"));
				Mobilewriteresults(results, driver, "Click on OK button", test,
						currentTCName);
				Thread.sleep(2000);

				// Click on Back Arrow Icon
				results = project.menuIcon(pr.getlocator("menuIcon-id"));
				Mobilewriteresults(results, driver, "click on menu button",
						test, currentTCName);
				Thread.sleep(2000);

				results = gm.click(pr.getlocator("BidSummaryHammerIcon"));
				Mobilewriteresults(results, driver, "click on Hammer Icon",
						test, currentTCName);
				Thread.sleep(4000);

				// Verification points
				String BidAmount = pr.getlocator("BidAmount").getText();
				System.out.println("Bid Amount is :" + BidAmount);
				Thread.sleep(3000);

				// Click on Back Arrow Icon
				results = project.menuIcon(pr.getlocator("menuIcon-id"));
				Mobilewriteresults(results, driver, "click on menu button",
						test, currentTCName);
				Thread.sleep(2000);

			} else {
				System.out.println("IOS");
				results = gm.click(pr.getlocator("Pending"));
				Mobilewriteresults(results, driver, "Click on Pending", test,
						currentTCName);
				Thread.sleep(1000);

				String companyname = pr.getlocator("Crewcompany").getText();
				System.out.println("Companyname is :" + companyname);
				Thread.sleep(1000);

				if (companyname.contains("Crew company")) {
					test.log(LogStatus.INFO, "Job name matched");
				}

				else {
					test.log(LogStatus.ERROR, "Job name not matched");
				}

				Thread.sleep(2000);

				results = gm.click(pr.getlocator("AWARD"));
				Mobilewriteresults(results, driver, "click on AWARD button",
						test, currentTCName);
				Thread.sleep(4000);
				System.out.println("####Bid#####");
			}

		} catch (Exception e) {
			System.out.println("enter");
		}

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
