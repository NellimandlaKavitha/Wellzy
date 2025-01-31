package Testrunner;

import io.cucumber.testng.CucumberOptions;
import utils.Reportconfig;

@CucumberOptions(
    glue = "stepdefinition",
    features = "src\\features\\java\\Features",
    monochrome = true,
    dryRun = false,
    tags = "@Dashboard",
    plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-reports.json"}
)
public class dashboardtestrunner extends Reportconfig {
}