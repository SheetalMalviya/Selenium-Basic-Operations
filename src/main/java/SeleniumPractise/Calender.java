package SeleniumPractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		System.out.println("The title of the page is " + driver.getTitle());
		WebElement fromField = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		fromField.sendKeys("J");
		Thread.sleep(1000);

		for (int i = 0; i < 11; i++) {
			fromField.sendKeys(Keys.ARROW_DOWN);
			System.out.println(fromField.getAttribute("value"));
			if (fromField.getAttribute("value").contains("Jamnagar")) {
				fromField.sendKeys(Keys.ENTER);
				;
				Thread.sleep(2000);
				break;
			}
		}

		WebElement dest = driver.findElement(By.id("gosuggest_inputDest"));
		dest.sendKeys("Mum");
		Thread.sleep(2000);

		for (int i = 0; i < 11; i++) {
			dest.sendKeys(Keys.ARROW_DOWN);
			System.out.println(dest.getAttribute("value"));
			if (dest.getAttribute("value").contains("Kitale")) {
				dest.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				break;
			}
		}

		// WebElement depCalender=driver.findElement(By.id("departureCalendar"));
		// depCalender.click();
		WebElement month = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
		System.out.println(month.getText());
		while (!month.getText().contains("July")) {
			driver.findElement(By.className("DayPicker-NavButton--next")).click();
		}

		List<WebElement> datelist = driver.findElements(By.className("DayPicker-Day"));
		for (int i = 0; i < datelist.size(); i++) {
			if (datelist.get(i).getText().contains("18")) {
				datelist.get(i).click();
				break;
			}

		}

		WebElement traveller = driver.findElement(By.id("pax_link_common"));
		traveller.click();
		driver.findElement(By.id("adultPaxPlus")).click();
		driver.findElement(By.id("childPaxPlus")).click();
		driver.findElement(By.id("infantPaxPlus")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("gi_search_btn")).click();

	}
}
