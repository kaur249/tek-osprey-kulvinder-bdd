package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.utility.SeleniumUtilities;

public class SecurityTestSteps extends SeleniumUtilities {

    @Given("User click on Sign In Button")
    public void userClickOnSignInButton() {
        clickElement(HomePage.SIGN_IN_BUTTON);
    }
    @When("User enter {string} and {string} and click on Login")
    public void userEnterCredentialsAndClickLogin(String username, String password) {
        sendTextToElement(LoginPage.EMAIL_INPUT,username);
        sendTextToElement(LoginPage.PASSWORD_INPUT,password);

        clickElement(LoginPage.LOGIN_BUTTON);

    }
    @Then("User will see Account button on home page")
    public void accountButtonWillDisplayOnHomepage() {
        boolean isDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isDisplayed);
    }
        @Then("validate error message {string}")
        public void validateErrorMessage(String expectedErrorMessage) {
        String actualError= getElementText(LoginPage.ERROR_MESSAGE);

        Assert.assertEquals(expectedErrorMessage,actualError);
    }
}
