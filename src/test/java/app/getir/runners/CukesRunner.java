package app.getir.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/html-default reports.html"},
        features = "src/test/resources/features",
        glue = "app/getir/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}