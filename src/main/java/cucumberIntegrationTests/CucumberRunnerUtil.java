package cucumberIntegrationTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/java/tests/cucumberTests/features",
        glue = {"cucumberIntegrationTests/stepDefinitions"},
        tags = {"@login"},
        plugin = {"pretty", "html:target/cucumber"}

)
public class CucumberRunnerUtil {

}
