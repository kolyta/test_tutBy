package base.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSettings {
	public static WebDriver driver;

	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kolyta\\workspace\\email\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://tut.by");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void testClose() {
		driver.close();
		driver.quit();
	}

}
