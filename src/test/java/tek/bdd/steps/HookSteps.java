package tek.bdd.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtilities;

public class HookSteps extends SeleniumUtilities {
    // Hook is the events that cucumber will listen to it and run
    // Interview question: event listener from the cucumber that we can implement for these events that runs before and after scenario using annotation before and after.
    // blocks of code that can run at various points in the Cucumber execution cycle. They are typically used for setup and teardown of the environment before and after each scenario.

    //Hook that Run Before Each Scenario (here it is a java class)
    @Before
    public void initiateTest() {
        openBrowser();
    }// open the browser

    //Hook Will Execute After Each Scenario
    //no matter what happened to Scenarios
    @After
    public void closingTest(Scenario scenario) {// close the session
        if(scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);
            // way to take screenshot

            scenario.attach(capture, "image/png", "screenshot");
        }
        getDriver().quit();
    }

    // These are the only one we implement, before scenario and after scenario
    // hook is for the entire scenario
    // Taking screenshot above

}
