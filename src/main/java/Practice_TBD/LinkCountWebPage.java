package Practice_TBD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCountWebPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(URL);
		
		//Find total number of links present on webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Find total number of tags at the footer section of web page
		
		WebElement footerWE = driver.findElement(By.xpath("//table[@class='gf-t']"));
		System.out.println(footerWE.findElements(By.tagName("a")).size());
		
		//Finding number of links in first section of footer
		WebElement footerWEOne = driver.findElement(By.xpath("//table[@class='gf-t']//td[1]"));
		List<WebElement> WL = footerWEOne.findElements(By.tagName("a"));
		Iterator it = WL.iterator();
		//String keyCombination = Keys.chord(Keys.CONTROL,Keys.ENTER);
		HttpURLConnection HUC = null;
		while(it.hasNext()) {
			WebElement we = (WebElement) it.next();
			//we.sendKeys(keyCombination);
			//Thread.sleep(5000);
			
			// Broken Link Testing
			String url = we.getAttribute("href");
			try {
				
				HUC = (HttpURLConnection) new URL(url).openConnection();
				HUC.setRequestMethod("HEAD");
				HUC.connect();
				int ResCode = HUC.getResponseCode();
				
				if(ResCode>=400) {
					System.out.println("Link Broken - " + url );
					continue;
				}else {
					System.out.println("Link Working - " + url);
					System.out.println(ResCode);
				}
			} catch (MalformedURLException e) {
				System.out.println("Link Broken - " + url );
				continue;
			} catch (IOException e) {
				System.out.println("Link Broken - " + url );
				continue;
			}
		}
		
	}

}
