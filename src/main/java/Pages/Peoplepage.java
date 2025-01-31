package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Peoplepage {
    WebDriver driver;
    WebDriverWait wait;

   
    private By members = By.xpath("//a[contains(text(),'Members')]");
    private By leads = By.xpath("//a[text()='Leads']");
    private By staff = By.xpath("//a[text()='Staff']");
    private By createNew = By.cssSelector("[class='h-5 w-5 flex-shrink-0 self-center']");
    private By createMember = By.xpath("//span[text()='Member']");
    private By close = By.xpath("//span[text()='Close']/..");
    private By createLead = By.xpath("//span[text()='Lead']");
    private By createStaff = By.xpath("//span[text()='Staff']");
    private By knowYourWellness = By.xpath("//a[text()='Know Your Wellness']");
    private By peopleModule = By.xpath("(//span[@class='sr-only'])[1]");
    

    public Peoplepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickonpeoplemodule() {
        wait.until(ExpectedConditions.elementToBeClickable(peopleModule)).click();
    }

    public void clickonPeopleElements() {
        wait.until(ExpectedConditions.elementToBeClickable(members)).click();
        wait.until(ExpectedConditions.elementToBeClickable(leads)).click();
        wait.until(ExpectedConditions.elementToBeClickable(staff)).click();
        wait.until(ExpectedConditions.elementToBeClickable(knowYourWellness)).click();
    }

    public void clickoncreatenewmember() {
        wait.until(ExpectedConditions.elementToBeClickable(createNew)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createMember)).click();
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void closemodel() {
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickoncreatenewlead() {
        wait.until(ExpectedConditions.elementToBeClickable(createNew)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createLead)).click();
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickoncreatestaff() {
        wait.until(ExpectedConditions.elementToBeClickable(createNew)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createStaff)).click();
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }
}