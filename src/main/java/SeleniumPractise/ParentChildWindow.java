package SeleniumPractise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentChildWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();

		driver.switchTo().window(childWindowID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());

		driver.switchTo().window(parentWindowID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

	}

}
