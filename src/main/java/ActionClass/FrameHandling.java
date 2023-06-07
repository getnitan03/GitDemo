package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://jqueryui.com/droppable/";
		driver.get(URL);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//driver.findElement(By.cssSelector("#draggable")).click();
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.cssSelector("#draggable")), driver.findElement(By.cssSelector("#droppable"))).build().perform();
		driver.switchTo().defaultContent(); // come back to parent window
		
		driver.findElement(By.xpath("//a[text()='Accept']"));
	}
}
