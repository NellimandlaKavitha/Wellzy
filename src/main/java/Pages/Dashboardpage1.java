package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboardpage1 {
    WebDriver driver;
    private WebDriverWait wait;

    By today = By.xpath("//button[text()='Today']");
    By weekly = By.xpath("//button[text()='Weekly']");
    By monthly = By.xpath("//button[text()='Monthly']");
    By createButton = By.xpath("//button[text()='Create']");
    By member = By.xpath("//span[text()='Member']");
    By lead = By.xpath("//span[text()='Lead']");
    By staff=By.xpath("//span[text()='Staff']");
    By close = By.xpath("//span[text()='Close']/..");

    public Dashboardpage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOntodayweeklymonthly() {
      wait.until(ExpectedConditions.elementToBeClickable(today)).click();
      wait.until(ExpectedConditions.elementToBeClickable(weekly)).click();
      wait.until(ExpectedConditions.elementToBeClickable(monthly)).click();
    }

    public void clickoncreatemember() {
      wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
      wait.until(ExpectedConditions.elementToBeClickable(member)).click();
      wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickonclose() {
    	 wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickoncreatelead() {
    	 wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(lead)).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickoncreatestaff()
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(staff)).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(close)).click();

    }








}