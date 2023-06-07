package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionClass {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://www.amazon.com/";
		driver.get(URL);
		
		Actions a = new Actions(driver);
		//Action class - to mouseover
		a.moveToElement(driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"))).build().perform();
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("HELLO");
		
		//Action class to hold a key down for caps alphabets
		WebElement we = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		//Composite Action - combination of multiple actions - move, keydown, send keys
		a.moveToElement(we).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
	}

}
