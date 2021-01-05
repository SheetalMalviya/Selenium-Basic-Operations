package SeleniumPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
 driver.findElement(By.id("autosuggest")).sendKeys("united");
 Thread.sleep(3000);
// List<WebElement> list=driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
 List<WebElement> list=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li//a[@class='ui-corner-all']"));
 System.out.println(list.size());
 
	
	for(int i=0;i<list.size();i++) {
		if(list.get(i).getText().equalsIgnoreCase("united kingdom")) {
			list.get(i).click();
			
		}
	}
}}
