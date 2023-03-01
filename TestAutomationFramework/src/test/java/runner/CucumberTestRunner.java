package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false, monochrome = true, dryRun = false, plugin = {  "pretty", "html:target/cucumber.html", "json:target/cucumber-report/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features="src/test/resources/features", glue="stepdef")
public class CucumberTestRunner {
}
