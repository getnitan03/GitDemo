package eKartAuto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eKartAuto {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String promoCode = "rahulshettyacademy";
		driver.get(URL);
		
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Beetroot");
		itemList.add("Beans");
		itemList.add("Potato");
		eKartAuto eKA = new eKartAuto();
		
		if(js.executeScript("return document.readyState").toString().equals("complete")) {
			if (eKA.addItemToKart(itemList,driver)) {
				driver.findElement(By.cssSelector(".cart-icon")).click();
				driver.findElement(By.cssSelector(".cart-preview.active button")).click();
				driver.findElement(By.cssSelector(".promoCode")).sendKeys(promoCode);
				driver.findElement(By.cssSelector(".promoBtn")).click();
				
				/*
				//Applying Explicit wait
				WebDriverWait eWait = new WebDriverWait(driver,Duration.ofSeconds(20));
				try {
					eWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
					System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
					
				}catch(NoSuchElementException e){
					System.out.println("Element not visible");
				}*/
				
				//Using Fluent Wait
				
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3));
				try {
					WebElement WE = fluentWait.until(new Function<WebDriver, WebElement>() {

						public WebElement apply(WebDriver driver) {
							try {
								if (driver.findElement(By.cssSelector(".promoInfo")).isDisplayed()){
									return driver.findElement(By.cssSelector(".promoInfo"));
								}else {
									return null;
								}
							}catch(org.openqa.selenium.NoSuchElementException e) {
								return null;
							}
							
						}
						
					});
					
					System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
					
				}catch(org.openqa.selenium.NoSuchElementException e){
					System.out.println("Element not visible");
				}
				
				
			}else {
				System.out.println("No Item found");
			}
			
		}else {
			System.out.println("Page Not Loaded");
			System.out.println("Dummy Msg1");
			System.out.println("Dummy Msg2");
			System.out.println("Dummy Msg3");
		}

	}
	
	public boolean addItemToKart(ArrayList<String> itemList, WebDriver driver) {
		Iterator it = itemList.iterator();
		int itemsCounter = 0;
		while(it.hasNext()) {
			try {
				driver.findElement(By.xpath("//div/h4[contains(text(),'"+ it.next().toString().trim() + "')]/following-sibling::div[@class='product-action']/button")).click();
				itemsCounter++;
			}catch(Exception e){
				System.out.println("Item : "+ it.next() +" not found on web page");
				//e.printStackTrace();
				continue;
			}
		}
		
		if(itemsCounter>0) {
			return true;
		}else {
			return false;
		}
	}

}
