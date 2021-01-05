package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("0.5")){
			Assert.assertFalse(false);
			System.out.println("return date is disabled");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("return date is enabled");
		}
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[4]/li[3]/a")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
		
		
		
		////a[@value="SAG"]
		
		
		

	}

}
