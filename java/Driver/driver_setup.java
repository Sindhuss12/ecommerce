package Driver;


import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class driver_setup {
 
	public static WebDriver driver_set() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser");
		String browser=sc.next();
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) 
		{
		driver = new ChromeDriver();
		}
		else 
		{
		  driver=new EdgeDriver();
		}
		System.out.println("Browser Launched");
		//opening the URL
		String baseUrl = "https://www.flipkart.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		return driver;
 
	}
}

