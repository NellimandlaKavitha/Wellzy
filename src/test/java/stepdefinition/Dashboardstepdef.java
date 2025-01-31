package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Dashboardpage1;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.Base;

public class Dashboardstepdef extends Base {
	Dashboardpage1 d;
	 private WebDriverWait wait;

	    
	    @Before
	    public void setup() throws InterruptedException {
	        launchbrowser();
	        d = new Dashboardpage1(getDriver());
	        login("Qa","IFocus@123");
	        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	        
	    }

	    @Given("user is on the dashboard page")
	    public void user_is_on_the_dashboard_page() throws InterruptedException {
	    	 driver.get("https://qa.wellzy.in/dashboard");
	    	 Thread.sleep(10);
	    	 System.out.println("User landed on dashboard page");
	        
	    }
	    @And("click on the elements: today, weekly, monthly")
	    public void click_on_the_elements_today_weekly_monthly() {
	    	d.clickOntodayweeklymonthly();
	       
	    }
	    @And("click on create button, member")
	    public void click_on_create_button_member() {
	    	d.clickoncreatemember();
	        
	    }
	    @And("click on create button, lead")
	    public void click_on_create_button_lead() {
	    	d.clickoncreatelead();
	        
	    }
	    @And("click on create button,staff")
	    public void click_on_create_button_staff() {
	    	d.clickoncreatestaff();
	         
	    }
	

}