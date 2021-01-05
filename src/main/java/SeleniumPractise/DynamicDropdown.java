package SeleniumPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		// driver.manage().window().fullscreen();
		// driver.manage().deleteAllCookies();

		/*
		 * driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1']"
		 * )).click(); driver.findElement(By.xpath("//*[@value='KQH']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("(//*[@value='AMD'])[2]")).click();
		 * 
		 * Thread.sleep(2000);
		 */

		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1']")).click(); 
		driver.findElement(By.xpath("//*[@value='KQH']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DED']")).click();
		driver.quit();}

}
