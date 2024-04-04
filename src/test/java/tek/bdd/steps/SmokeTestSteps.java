package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtilities;

import java.time.Duration;
// According to the design of our framework that we are using, each step definitions class is require d to be extended to
// the parent_class of Selenium utilities class to inherit properties from the parent_class:
public class SmokeTestSteps extends SeleniumUtilities {

    // Implementing the method for the step definition in the feature file for the scenario step:
    // every step definition should have the "void" return type because there is no return for these methods
    // Also, all of these methods of the step definitions should have a public access type so that are visible to the
    // Cucumber and JVM library
    @Then("Validate top left corner is {string}")
    public void validateTopLeftCorner(String expectedTitle) {
        // all we have to is to get the text and use assertions to validate if the expected title is equal to the actual
        // title (outcome):
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds());
        // using the method created in the parent_class or the WebDriver wait instead of repeating the object creation:
        // and withing the parameters of that DriverWait method, we should provide by object:

        String actualTitle = getElementText(HomePage.TOP_NAV_LOGO);
        // String actualTitle = getElementText(By.className("top-nav__logo"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("top-nav__logo")))
        // .getText(); (with this is it asking give me the locator, a text)

        Assert.assertEquals(expectedTitle, actualTitle);
        // Validation using Assertion
        // HOW WE know we element pass- we knows which element to pass
        // The assertion comes from Junit
    }

    @Then("Validate Sign In Button is Enabled")
    public void validateSignInButtonIsEnabled() {
        // going to the designated page// store under home page.java/ then add to selenium utilities
        boolean isButtonEnabled =  isElementEnabled(HomePage.SIGN_IN_BUTTON);
        Assert.assertTrue(isButtonEnabled);
    }
}

