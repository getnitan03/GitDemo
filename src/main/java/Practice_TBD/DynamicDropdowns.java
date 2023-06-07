package Practice_TBD;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import E2E_Framework.DriverClass;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		DynamicDropdowns DC = new DynamicDropdowns();
		//DC.SelectPassengers(5);
		//DC.SelectFromT0("PNQ", "ATQ");
		//DC.AutoSuggestiveSelectionList("AF", "South Africa");
		//DC.CheckBoxSelection();
		DC.SelectDate();
		/*
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		String URL = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(URL);
		WebElement CurrencyWE = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));
		
		//Drop-down with select tag - Static DropDown
		
		Select CurrencyDD = new Select(CurrencyWE);
		CurrencyDD.selectByValue("USD");
		System.out.println(CurrencyDD.getFirstSelectedOption().getText());
		*/
		
		
	}

	public void SelectPassengers(Integer Adult) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = "https://www.spicejet.com/";
		driver.get(URL);
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']//*[@data-testid='svg-img']")).click();
		//Adding Adults
		for(int i=1;i<Adult;i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
			if(driver.findElement(By.xpath("//div[@data-testid='Adult-testID-minus-one-cta']/following-sibling::div/div")).getText().equals(Adult.toString())) {
				break;
			}
		}
		
		//Scroll a webelement using javascript
		WebElement PL = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']/following-sibling::div"));
		js.executeScript("arguments[0].scrollIntoView()", PL);
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		
	}
	
	public void SelectFromT0(String From, String To) {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = "https://www.spicejet.com/";
		driver.get(URL);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//div[text()='" + From + "']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//div[text()='" + To + "']")).click();
		
		
		
	}
	
	public void AutoSuggestiveSelectionList(String vChar, String Country) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		String URL = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(URL);
		driver.findElement(By.id("autosuggest")).sendKeys(vChar);
		Thread.sleep(1000);
		List<WebElement> AL = driver.findElements(By.cssSelector(".ui-menu-item"));
		Iterator<WebElement> it = AL.iterator();
		while(it.hasNext()) {
			WebElement WE = it.next();
			if(WE.getText().equalsIgnoreCase(Country)){
				WE.click();
				break;
			}
		}
	}	
		public void CheckBoxSelection() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
			String URL = "https://rahulshettyacademy.com/AutomationPractice/";
			driver.get(URL);
			List<WebElement> inputCheckBox = driver.findElements(By.cssSelector("input"));
			System.out.println("Total number of Check or Radio Box's : " + inputCheckBox.size());
			
			driver.findElement(By.cssSelector("#checkBoxOption1")).click();
			Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
			
	}
		
		public void SelectDate() {
			WebDriver driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			String URL = "https://www.spicejet.com/";
			driver.get(URL);
			driver.findElement(By.xpath("//div[text()='Select Date']")).click();
			try {
				List<WebElement> MonthText = driver.findElements(By.xpath("//div[@data-testid='undefined-calendar-picker']//div[contains(@data-testid,'undefined-month')]"));
				for(int i=1;i<MonthText.size();i++) {
					if(MonthText.get(i).isDisplayed()) {
						if(MonthText.get(i).getText().toUpperCase().contains("OCTOBER-2023")) {
							//MonthText.get(i).click();
							break;
						}
					}else {
						driver.findElements(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[0]/svg[]"));
					}
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			
			
			
		}
	
}
