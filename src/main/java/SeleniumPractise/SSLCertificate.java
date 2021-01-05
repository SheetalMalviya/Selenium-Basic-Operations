package SeleniumPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificate {

	public static void main(String[] args) {
		
		
		
		DesiredCapabilities ds=new DesiredCapabilities();
		//ds.acceptInsecureCerts();
		ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	
		ChromeOptions c=new ChromeOptions();
		c.merge(ds);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(c);
		
		

	}

}
