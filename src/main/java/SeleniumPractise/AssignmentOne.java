package SeleniumPractise;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOne {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement option = driver.findElement(By.xpath("//input[@value='option2']"));
		String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		option.click();
		Thread.sleep(2000);

		System.out.println("The obtained text is " + text);

		List<WebElement> optionList = driver.findElements(By.xpath("//select[@id='dropdown-class-example']//option"));
		for (int i = 0; i < optionList.size(); i++) {
			if (optionList.get(i).getText().equalsIgnoreCase(text)) {
				optionList.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();
		System.out.println("the alert text is " + alertText);
		if (alertText.contains(text)) {
			System.out.println(text + " text is present in alert dialog box");

		}
		driver.switchTo().alert().accept();

		driver.quit();

	}

}
