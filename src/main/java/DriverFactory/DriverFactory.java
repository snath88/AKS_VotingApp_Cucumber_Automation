package DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	public WebDriver initDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		
		else if(browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			tlDriver.set(new SafariDriver());
		}
			
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		getdriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return getdriver();
	}

	public static synchronized WebDriver getdriver()
	{
		return tlDriver.get();
	}
}
