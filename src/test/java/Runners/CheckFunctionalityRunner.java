package Runners;
import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/Features",glue= {"stepDefinitions"},
 tags = {"@tag1"},
 plugin = {"pretty", "html:target/htmlreports"})
public class CheckFunctionalityRunner {

}
