package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        features = "src/test/resources/features",
        glue = "playwrightsessions",
        snippets = CAMELCASE,
        tags = "@tags"
)

public class TestRunner {
}
