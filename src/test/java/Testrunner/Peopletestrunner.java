package Testrunner;

import io.cucumber.testng.CucumberOptions;
import utils.Reportconfig;

@CucumberOptions(
    glue ="stepdefinition",
    features ="src\\features\\java\\Features",
    tags = "@People",
    plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-reports.json"},
    monochrome = true
)
public class Peopletestrunner extends Reportconfig {
}