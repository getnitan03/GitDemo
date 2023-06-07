package E2E_Framework;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.Urls;
import org.testng.Assert;

public class DriverClass {

	public static void main(String[] args) {
		DriverClass DC = new DriverClass();
		
		//System.setProperty("Webdriver.chrome.driver","D:\\SeleniumSetup\\WebDriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(URL);
		//System.out.println(driver.getTitle());
		
		//driver.findElement(By.id("inputUsername")).sendKeys("xyz@gmial.com");
		//using java script executor
		if(js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page loaded successfully");
			
			js.executeScript ("document.getElementById('inputUsername').value ='xyz@gmial.com'");
			
			driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("Hello123");
			driver.findElement(By.className("signInBtn")).click();
			
			try {
				String ErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
				//System.out.println(ErrorText);
				
				if(ErrorText.length() > 0) {
					
					String Pwd = DC.getPassword(driver);
					
					if(Pwd.length()>0) {
						driver.findElement(By.cssSelector(".go-to-login-btn")).click();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						driver.findElement(By.id("inputUsername")).sendKeys("Tester_Nitan");
						driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(Pwd);
						driver.findElement(By.className("signInBtn")).click();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
						driver.findElement(By.xpath("//*[text()='Log Out']")).click();
						
					}
				}
				
			}catch(org.openqa.selenium.NoSuchElementException e){
				System.out.println("No Error displayed");
				e.printStackTrace();
			}catch(org.openqa.selenium.ElementClickInterceptedException e) {
				System.out.println("Button Click Operation Failed");
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Page not loaded");
		}
		
		
		
		
		driver.close();
		
	}
	
	public String getPassword(WebDriver driver) {
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Tester@xyz.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("111111111");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		String PasswordRaw = driver.findElement(By.cssSelector(".infoMsg")).getText();
		String Pwd = PasswordRaw.split("'")[1].split("'")[0];
		//System.out.println(Pwd);
		return Pwd;
		
	}

}
