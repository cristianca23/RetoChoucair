package runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/exitoCompras.feature"},
        glue = {"stepdefinitions"},
        tags = "@ComprarTelevisores",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)

public class RunnerExito {


}
