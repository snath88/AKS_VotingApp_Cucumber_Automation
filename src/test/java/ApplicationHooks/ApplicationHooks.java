package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private ConfigReader configreader;
	private Properties prop;
	private String browser;
	public static String url;
	private WebDriver driver;
	
	@Before(order=0)
	public void getProperties()
	{
		configreader= new ConfigReader();
		prop= configreader.init_prop();
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		
	}
	
	@Before(order=1)
	public void setUp()
	{
		driverfactory= new DriverFactory();
		
		driver= driverfactory.initDriver(browser);
		driver.get(url);
	}
	
	@After(order=1)
	public void addScreenshots(Scenario sc)
	{
		if(sc.isFailed())
		{
			String screenshotName=sc.getName().replaceAll(" ", "_");
			byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
				}
	
	@After(order=0)
	public void tearDown()
	{
		driver.quit();
	}

}
