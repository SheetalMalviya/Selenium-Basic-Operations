package SeleniumPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		String ar[] = { "Brocolli", "Cucumber", "Tomato", "Beans" };

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		System.out.println("The number of products displayed are " + productList.size());

		for (WebElement element : productList) {
			System.out.println(element.getText());
		}

		for (int i = 0; i < productList.size(); i++) {
			int k = 0;
			String str[] = productList.get(i).getText().split("-");
			String name = str[0].trim();
			List testList = Arrays.asList(ar);
			if (testList.contains(name)) {
				k++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (k == testList.size()) {
					break;
				}
			}

		}
		// driver.quit();
	}
}
