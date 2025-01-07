package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.loginpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdef {
    WebDriver driver;
    loginpage Loginpage;

    @Before()
    public void setup() {
        System.out.println("Launching browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

   @Given("User on the login page")
    public void user_on_the_login_page() {
        driver.get("https://qa.wellzy.in/login");
          }


   @Given("^Enter (.+)  and (.+)$")
   public void enter_qa_and_ifocus(String username, String password) throws InterruptedException {
	   Loginpage = new loginpage(driver);

      Loginpage.enterUsername(username);
      Loginpage.enterPassword(password);
   }
   @When("Click on login button")
   public void click_on_login_button() {
	   Loginpage.clickOnLoginButton();

   }


    @Then("User should navigate to the dashboard page")
    public void user_should_navigate_to_dashboard_page() {
        System.out.println("Dashboard navigation successful!");
             }

    @After
    public  void closebrowser()
    {
    	System.out.println("fgggedfdf");
    	driver.quit();

    }

}
