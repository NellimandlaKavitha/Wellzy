package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;
import utils.Utilities;

public class loginstepdef extends Base{

	private Loginpage L;
	private WebDriverWait wait;
	Utilities u=new Utilities();
	String username=u.getDataFromPropertyFile("Data","username");
	String password=u.getDataFromPropertyFile("Data","password");
	
	@Before
	public void setup()
	{
		launchbrowser();
		L  = new Loginpage(getDriver());
		
	}
	
	@Given("^User on the login page$")
	public void user_on_the_login_page() {
		 driver.get("https://qa.wellzy.in/login");
		this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	   
	}

	@Given("^Enter (.+) and (.+)$")
	public void enter_username_and_password(String username, String password) {
		 L.enterUsername(username);
         L.enterPassword(password);
	    
	}

	@When("^Click on login button$")
	public void click_on_login_button() {
		L.clickOnLoginButton();
	     
	}

	@Then("^User should navigate to the dashboard page$")
	public void user_should_navigate_to_the_dashboard_page() {
		 System.out.println("Dashboard navigation successful!");
	}

	 @After
   public void tearDown() {
       quitDriver();
   }


}
	
	
	
	
