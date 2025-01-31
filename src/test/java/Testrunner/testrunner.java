package Testrunner;

import io.cucumber.testng.CucumberOptions;
import utils.Reportconfig;

@CucumberOptions(
    glue = "stepdefinition",
    features = "src/features/java/Features/QA.feature",
    monochrome = true,
    dryRun = false,
    tags = "@Login",
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
)
public class testrunner extends Reportconfig {
}