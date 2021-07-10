package co.com.utest.runner;

import co.com.utest.formacion.RunnerPersonalizado;
import co.com.utest.util.BeforeSuite;
import co.com.utest.util.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

import org.junit.runner.RunWith;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


@CucumberOptions(
        features = "src/test/resources/features/uTest_Registrar_persona.feature",
        glue = {"co.com.utest.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)

@RunWith(RunnerPersonalizado.class)
public class RunnerTags {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/uTest_Registrar_persona.feature");
    }
}

