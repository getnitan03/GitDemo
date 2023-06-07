package Practice_TBD;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScrolling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(URL);
		//Scrolling screen based on coordinates
		//js.executeScript("window.scrollBy(0,500)");
		
		//scrolling screen based on element visibility
		//WebElement WE = driver.findElement(By.cssSelector("#mousehover"));
		//js.executeScript("arguments[0].scrollIntoView()",WE);
		//js.executeScript("document.querySelector('#mousehover').scrollIntoView()");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollIntoView()");
		
		//Get sum of the table 4th column
		List<WebElement> WEL = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		Iterator<WebElement> it = WEL.iterator();
		Integer Sum = 0;
		while(it.hasNext()) {
			WebElement WE = it.next();
			
			Integer val = Integer.valueOf(WE.getText().toString());
			Sum = Sum + val;
		}
		System.out.println(Sum);
		System.out.println("Changing to check GIT update-1");
		System.out.println("Changing to check GIT update-2");
		
	}

}
