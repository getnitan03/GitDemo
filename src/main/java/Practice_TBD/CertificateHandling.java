package Practice_TBD;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class CertificateHandling {
	
	public static void main(String[] args) {
		
		ChromeOptions CO = new ChromeOptions();
		CO.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(CO);
		
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = "https://expired.badssl.com/";
		driver.get(URL);
		System.out.println(driver.getTitle());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("D:\\SeleniumSetup\\RestAssuredAPI\\NewFramework\\Screenshots\\SC.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
