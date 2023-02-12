package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VotingAppPage {

	private WebDriver driver;
	
	////1. by locator
	
	private By dogbutton= By.xpath("//button[contains(@value,'Dogs')]");
	
	private By catbutton= By.xpath("//button[contains(@value,'Cats')]");
	
	private By resetbutton= By.xpath("//button[contains(@value,'reset')]");
	
	private By result= By.xpath("//div[contains(@id,'results')]");
	
	//2. constructor of the page
	
	public VotingAppPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//3. Page Action
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isDogButtonEnabled()
	{
		return  driver.findElement(dogbutton).isEnabled();
	}
	
	public boolean isCatButtonEnabled()
	{
	return driver.findElement(catbutton).isEnabled();
	}
	
	public boolean isResetButtonEnabled()
	{
	return driver.findElement(resetbutton).isEnabled();
	}
	
	public void clickDogButton()
	{
		driver.findElement(dogbutton).click();
	}
	
	public void clickCatButton()
	{
		driver.findElement(catbutton).click();
	}
	
	public void clickResetButton()
	{
		driver.findElement(resetbutton).click();
	}
	
	public String getResultReset()
	{
		return driver.findElement(result).getText();
	}
	
}
