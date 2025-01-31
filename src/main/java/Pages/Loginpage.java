package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
    WebDriver driver;
   
    By username = By.id("[id='text']");
    By password = By.id("password");
    By loginButton = By.xpath("//button[text()='Sign in']");

    public Loginpage(WebDriver driver) {
        this.driver = driver;
         
    }

    public void enterUsername(String usernameInput) {
        
       driver.findElement(username).sendKeys(usernameInput);  
    }

    public void enterPassword(String passwordInput)  {
       
      driver.findElement(password).sendKeys(passwordInput);
    }

    public void clickOnLoginButton() {
       driver.findElement(loginButton).click();
    }
}