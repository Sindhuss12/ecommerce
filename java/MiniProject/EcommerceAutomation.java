package MiniProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.driver_setup;
import Utilities.ScreenShot;

public class EcommerceAutomation{
	public static void main(String[] args) throws FileNotFoundException, IOException, Throwable {
		WebDriver driver = driver_setup.driver_set();
		try {
	          WebElement popup =driver.findElement(By.className("_30XB9F"));
	          popup.click();
	        } catch (Exception e) {
	            System.out.println("No pop-up appeared.");
	        }
		
		//Search mobiles and verify prices
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("mobiles under ");
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement popup1 =myWait.until(ExpectedConditions.elementToBeClickable(By.className("_3D0G9a")));
		
		List<WebElement> searchSuggetion=driver.findElements(By.xpath("//li[@class='_3D0G9a']"));
	
		
		for(WebElement searchsug:searchSuggetion) {
			String catagory=searchsug.getText();
			if(catagory.equalsIgnoreCase("mobiles under 15000")) {
				searchsug.click();
				break;
			}		
		}
		
		//set price to 10000
		Select drpPrice = new Select(driver.findElement(By.xpath("(//*[@class='_2YxCDZ'])[2]")));
		drpPrice.selectByVisibleText("₹10000");
		
		//Selecting OS
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,2300)", "");
		WebDriverWait myWait1 = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement popup2 =myWait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),\"Operating System Version Name\")]")));
		
		WebElement os=driver.findElement(By.xpath("//div[text()='Operating System Version Name']"));
		os.click();
		
		//selecting more
		WebDriverWait myWait2 = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement popup3 =myWait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='11 MORE']")));
		
		WebElement more =driver.findElement(By.xpath("//span[text()='11 MORE']"));
		more.click();
		Thread.sleep(5000);
		
		//selecting pie
		WebDriverWait myWait4 = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement popup5 =myWait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Pie']//preceding::div[@class='_24_Dny'][1]")));
		
		WebElement pie=driver.findElement(By.xpath("//div[text()='Pie']//preceding::div[@class='_24_Dny'][1]"));
		pie.click();
		Thread.sleep(2000);
		
	
		WebDriverWait myWait5 = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement popup4 =myWait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Newest First']")));
		
		WebElement newestFirst=driver.findElement(By.xpath("//div[text()='Newest First']"));
		newestFirst.click();
		Thread.sleep(2000);
		
		//Dislay first five mobiles
		List<WebElement> names=driver.findElements(By.className("_4rR01T"));
		List<WebElement> prices1=driver.findElements(By.className("_30jeq3"));
		for(int j=0;j<5;++j){
			System.out.println(names.get(j).getText()+" - "+prices1.get(j).getText());
		}
		String first=driver.findElement(By.className("_30jeq3")).getText();
		System.out.println();
        String firsst= first.substring(1,2)+first.substring(3);

		int fir=Integer.parseInt(firsst);
		if(fir<30000)
		{
			System.out.println("The Price of the first mobile is "+fir+" which is less than 30000.");
		}
		try {
			ScreenShot.screenShotTC(driver, "webb");
		}catch(IOException e){
              e.printStackTrace();			
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}

