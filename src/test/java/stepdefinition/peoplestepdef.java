package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.Peoplepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Base;


public class peoplestepdef extends Base{
	 private Peoplepage p;
	 private WebDriverWait wait;
	 
	 @Before
	 public void setup() throws InterruptedException
	 {
		launchbrowser();
		p = new Peoplepage(getDriver());
        login("Qa","IFocus@123");
      
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @Given("^navigate to people$")
    public void navigate_to_people() throws InterruptedException {
        getDriver().get("https://qa.wellzy.in/people/members");
        Thread.sleep(10);
//        String currentUrl = driver.getCurrentUrl();
//    	Thread.sleep(10);  
//        Assert.assertEquals("https://qa.wellzy.in/people/members", currentUrl);
//        Thread.sleep(10);  
        System.out.println("User  has been landed on the people page");
        Thread.sleep(1000);
    }

    @And("^click on elements: member, lead, staff, know your wellness$")
    public void click_on_elements_member_lead_staff_know_your_wellness() throws InterruptedException {
        p.clickonPeopleElements();
//        Thread.sleep(1000);
    }

    @Then("^click on create new, create member$")
    public void click_on_create_new_create_member() throws InterruptedException {
        p.clickoncreatenewmember();
        Thread.sleep(1000);
    }

    @Then("^click on create new, create lead$")
    public void click_on_create_new_create_lead() throws InterruptedException {
        p.clickoncreatenewlead();
        Thread.sleep(1000);
    }

    @Then("^click on create new, create staff$")
    public void click_on_create_new_create_staff() throws InterruptedException {
        p.clickoncreatestaff();
        Thread.sleep(1000);
    }

    @After
    public void closing() {
        quitDriver();
        System.out.println("Closing browser");
    }
	 }
