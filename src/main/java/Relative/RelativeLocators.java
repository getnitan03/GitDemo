package Relative;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[]args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = "https://rahulshettyacademy.com/angularpractice/";
		driver.get(URL);
		/*
		WebElement NameEditBox = driver.findElement(By.xpath("//div/input[@name='name']"));
		String LabelText = driver.findElement(with(By.tagName("label")).above(NameEditBox)).getText();
		System.out.println(LabelText);
		*/
		
		WebElement labelText = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(labelText)).click();
		
	}
	
	
}
