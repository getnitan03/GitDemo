package Practice_TBD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		String URL = "https://www.makemytrip.com/flights/";
		driver.get(URL);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		String ExpectedYear = " 2024";
		String ExpectedMonth = "January";
		String ExpectedDate = ExpectedMonth + ExpectedYear;
		
		WebElement MonthParent = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]"));
		
		//Read Current Month
		String CurentMonthYear = MonthParent.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
		//int ovevrideValue = 20;
		System.out.println(CurentMonthYear);
		System.out.println(ExpectedDate);
		/*
		for(int i =1;i<100;i++) {
			if(ExpectedDate.equals(CurentMonthYear)) {
				break;
			}else {
				driver.findElement(By.xpath(("//span[@aria-label='Next Month']"))).click();
				CurentMonthYear = MonthParent.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
				System.out.println(CurentMonthYear);
			}
		}*/
		
		
		while(ExpectedDate.equals(CurentMonthYear) == false) {
			
			driver.findElement(By.xpath(("//span[@aria-label='Next Month']"))).click();
			CurentMonthYear = MonthParent.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
			System.out.println(CurentMonthYear);
			//ovevrideValue++;
		}
		
		
		MonthParent.findElement(By.xpath("//div[@class='DayPicker-Day']//p[text()=15]")).click();;
		
	}

}
