package tek.bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "classpath:features", // this is for the all the feature you have and it will run
        glue = "tek.bdd.steps",
        dryRun = false,
        tags = "@Regression",
        // if you want to run regression, tags= "@Regression" or "@Smoke" or "@Story_2" , can run by mutiple using "@Story_1" or @Story_2"
        plugin = {
                "pretty",
                // use "pretty", to make it look pretty
                "html:target/html_report/index.html"

                // If we run it again, it will fail because the username and password is entered twice, they were duplicated
        }

)
// First run the test and it was fail
// org.junit.ComparisonFailure:
// shows below console output when running from the runner class
//Expected :TekSchool
//Actual   :TEKSCHOOL
// Steps is responsible for handling, in a framework  should be at their location
// implementing
public class TestRunner {

}
