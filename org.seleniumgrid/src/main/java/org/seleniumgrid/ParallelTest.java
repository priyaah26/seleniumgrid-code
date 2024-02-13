package org.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		WebDriverManager.chromedriver().setup();
		driver = new RemoteWebDriver(new URL("http://192.168.0.103:4444"), cap);
		
	}
	
	@Test (priority=1)
	public void test1() {
	System.out.println("Test one Started....");
	driver.get("https://magento.softwaretestingboard.com/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	driver.close();
	}
	
	@Test (priority=2)
	public void test2() {
	System.out.println("Test two Started....");
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	driver.close();
	}
	
	@Test (priority=3)
	public void test3() {
	System.out.println("Test three Started....");
	driver.get("https://www.cricbuzz.com/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	driver.close();
	}
	
	@Test (priority=4)
	public void test4() {
	System.out.println("Test four Started....");
	driver.get("https://www.youtube.com/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	driver.close();
	}
	

}
