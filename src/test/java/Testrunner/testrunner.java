package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    glue = "stepdefinition",
    features = "src/features/java/Features",
    monochrome = true,
    dryRun = false,
    tags = "@Login",
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
)
public class testrunner extends AbstractTestNGCucumberTests {
}
