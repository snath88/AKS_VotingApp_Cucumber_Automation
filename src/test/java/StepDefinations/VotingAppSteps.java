package StepDefinations;

import org.junit.Assert;
import DriverFactory.DriverFactory;
import Pages.VotingAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ApplicationHooks.*;

public class VotingAppSteps {
//	WebDriver driver;
	String tittle;
	
	private VotingAppPage AppPage= new VotingAppPage(DriverFactory.getdriver());
	@Given("User is in Voting App Page")
	public void user_is_in_voting_app_page() {
		DriverFactory.getdriver().get(ApplicationHooks.url);
		
	}

	@When("User get the Title of Page")
	public void user_get_the_title_of_page() {
		tittle=AppPage.getHomePageTitle();
	}

	@Then("The Page tittle should be {string}")
	public void the_page_tittle_should_be(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(string,tittle);
	    
	}

	@When("Cats button should be displayed")
	public void cats_button_should_be_displayed() {
		Assert.assertTrue(AppPage.isCatButtonEnabled());
		
	}

	@Then("User click on Cats button")
	public void user_click_on_cats_button() {
		 AppPage.clickCatButton();
	}

	@When("Dogs button should be displayed")
	public void dogs_button_should_be_displayed() {
		Assert.assertTrue(AppPage.isDogButtonEnabled());
	}

	@Then("User click on Dogs button")
	public void user_click_on_dogs_button() {
		AppPage.clickDogButton();
	}

	@When("Reset button should be displayed")
	public void reset_button_should_be_displayed() {
		Assert.assertTrue(AppPage.isResetButtonEnabled());
	}

	@Then("User click on Reset button")
	public void user_click_on_reset_button() {
		AppPage.clickResetButton();
		String result=AppPage.getResultReset();
		Assert.assertEquals("Cats - 0 | Dogs - 0", result);
		
	}
}
