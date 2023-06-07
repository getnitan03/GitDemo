package Streams;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeTableSorting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(URL);
		boolean LoopRun = true;
		List<String> OL = new ArrayList<String>();
		List<String> NL = new ArrayList<String>();
		
		while(LoopRun) {
			try {
				List<WebElement> CV = driver.findElements(By.xpath("//tbody//tr/td[1]"));
				CV.stream().map(s->s.getText()).forEach(OL::add);
				driver.findElement(By.xpath("//a[@aria-label='Next'][@aria-disabled='false']")).click();
			}catch(Exception e) {
				LoopRun = false;
				break;
			}
		}
		driver.findElement(By.xpath("//a[@aria-label='First'][@aria-disabled='false']")).click();
		
		//Double Click to sort
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		LoopRun = true;
		while(LoopRun) {
			try {
				List<WebElement> CV = driver.findElements(By.xpath("//tbody//tr/td[1]"));
				CV.stream().map(s->s.getText()).forEach(NL::add);
				driver.findElement(By.xpath("//a[@aria-label='Next'][@aria-disabled='false']")).click();
			}catch(Exception e) {
				LoopRun = false;
				break;
			}
		}
		System.out.println(OL);
		Collections.sort(OL);
		System.out.println(NL);
		System.out.println(OL.equals(NL));

	}

}
