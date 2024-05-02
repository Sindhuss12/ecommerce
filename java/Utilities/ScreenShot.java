package Utilities;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
		public static String filepath = ".\\flipkart\\";
		public static void screenShotTC(WebDriver scdriver,String fileName)throws IOException{
			File src=((TakesScreenshot)scdriver).getScreenshotAs(OutputType.FILE);       
			try
			{  // now copy the  screenshot to desired location using copyFile method
				FileUtils.copyFile(src, new File(filepath+fileName+".png"));
				System.out.println("Screenshot captured");
	        }catch (IOException e)      
				{
	        		System.out.println(e.getMessage());      
				}
		  }
 
	}
 
 
