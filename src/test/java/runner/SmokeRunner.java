package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        plugin = {
                "pretty",
                "summary",
                "com.epam.reportportal.cucumber.ScenarioReporter"
        },
        tags = "@Smoke"
)
public class SmokeRunner extends AbstractTestNGCucumberTests {
}
