package utilityHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags= "@Test",
        glue = {"stepDefinitions"},
        features = {"src/test/java/features"},
        plugin = {
                "pretty"
                , "html:target/cucumber-report/cucumber-html-report"
                , "html:target/cucumber-report/cucumber.html"
                , "json:target/cucumber-report/cucumber.json"
        })

public class TestRunner {
}