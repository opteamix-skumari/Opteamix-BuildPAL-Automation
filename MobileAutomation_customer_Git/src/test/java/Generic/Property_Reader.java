package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Property_Reader extends Baseclass{


	public static Properties webelem = null;

	public static String selection(){
		if(DeviceType.contains("Android")){
			path=Constants.Androidid;
		}
		else{
			path =Constants.IOSid;
		}
		return path;
	}

	public static String path=selection();

	public static String getstring(String value) {

		Properties prop = new Properties();
		InputStream input = null;
		String Value = null;

		try {
			input = new FileInputStream(Constants.capabalities);

			// load a properties file
			prop.load(input);

			Value = prop.getProperty(value);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Value;
	}

	/*public static WebElement getxpath(String xpathkey) throws IOException{

		webelem = new Properties();
		//System.out.println("pathtttt"+path);
		FileInputStream fs = new FileInputStream(path);
		webelem.load(fs);

		try{

			return driver.findElement(By.xpath((webelem.getProperty(xpathkey))));

		}
		catch (Exception e){
			return null;

		}

	}
	public static WebElement getid(String id) throws IOException{

		webelem = new Properties();
		System.out.println(id);
		FileInputStream fs = new FileInputStream(path);
		webelem.load(fs);

		try{
			System.out.println(id);
			return driver.findElement(By.id((webelem.getProperty(id))));

			// return driver.findElement(By.id(id));
		}
		catch (Exception e){
			return null;

		}

	}

	public static WebElement getlocator1(String locater) throws IOException, InterruptedException{
		
		Properties prop = new Properties();
		InputStream input = null;
		String Value = null;
		input = new FileInputStream(path);
		// load a properties file
		prop.clear();
		prop.load(input);
		Value = prop.getProperty(locater);
		String string=Value ;
		String[] parts = string.split(",");
		String locatervalue = parts[0]; 
		String locatername = parts[1];   
		if(locatervalue.contains("id"))
		{
			try{
				return driver.findElement(By.id(locatername));
			}
			catch (Exception e)
			{
				return null;
			}


		}  
		else
		{
			try{
				return driver.findElement(By.xpath(locatername));
			}
			catch (Exception e)
			{
				return null;

			}
		}
	}

*/
public static WebElement getlocator(String locater) throws IOException, InterruptedException{
		
		Properties prop = new Properties();
		InputStream input = null;
		String Value = null;
		input = new FileInputStream(path);
		// load a properties file
		prop.clear();
		prop.load(input);
		Value = prop.getProperty(locater);
		String string=Value ;
		String[] parts = string.split(",");
		String locatervalue = parts[0]; 
		String locatername = parts[1];   
		
		
		try{
			if(locatervalue.contains("id"))
			{
					return driver.findElement(By.id(locatername));

			}  
			else
			{
				return driver.findElement(By.xpath(locatername));	
		}
		}
		catch(Exception e)
		{
			System.out.println("null");
			return null;
			
		}
	}



}
