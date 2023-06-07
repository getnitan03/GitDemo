package ActionClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://rahulshettyacademy.com/loginpagePractise/#";
		driver.get(URL);
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> ow = driver.getWindowHandles();
		Iterator it = ow.iterator();
		
		String pw = (String) it.next();
		String cw = (String) it.next();
		
		driver.switchTo().window(cw);
		String emailID = driver.findElement(By.xpath("//strong/a")).getText();
		driver.switchTo().window(pw);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailID);
		
	}

}
