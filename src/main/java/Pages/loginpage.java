package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
    WebDriver driver;

    By username = By.id("text");
    By password = By.id("password");
    By loginButton = By.xpath("//button[text()='Sign in']");

    public loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameInput) throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(username).sendKeys(usernameInput);
    }

    public void enterPassword(String passwordInput) throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(password).sendKeys(passwordInput);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
}
