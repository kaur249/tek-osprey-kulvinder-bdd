package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountProfilePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.DataGeneratorUtility;
import tek.bdd.utility.SeleniumUtilities;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtilities {
    private String generatedRandomEmail;

    @Given("User click on Create Account")
    public void user_click_on_create_account() {
        clickElement(LoginPage.CREATE_ACCOUNT_LINK);
    }
    @When("User fill Form {string} and {string} and {string}")
    public void user_fill_form_and_and(String name, String email, String password) {
        generatedRandomEmail= DataGeneratorUtility.randomEmail(email);
        // String randomEmail= DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT,name);
        sendTextToElement(SignUpPage.EMAIL_INPUT,generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT,password);
    }
    @When("User fill up Sign up Form")
    public void user_fill_up_sign_up_form(DataTable dataTable) {
        // Step 1) Converting Data Table to Map
        Map<String, String> data= dataTable.asMap();
        String email= data.get("email");
        String name= data.get("name");
        String password= data.get("password");
        // data.get("email");
        generatedRandomEmail= DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT,name);
        sendTextToElement(SignUpPage.EMAIL_INPUT,generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT,password);
    }

    @When("User fill up Sign up Form With List of Map Data Table")
    public void user_fill_up_sign_up_form_with_list_of_map_data_table(DataTable dataTable) {
        // Converting data table to List of maps.asMaps()
        List<Map<String, String>> data= dataTable.asMaps();
        // Extract first row Data
        Map<String, String> dataMap =data.get(0);
        String email= dataMap.get("email");
        String name= dataMap.get("name");
        String password= dataMap.get("password");

        generatedRandomEmail= DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT,name);
        sendTextToElement(SignUpPage.EMAIL_INPUT,generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT,password);
    }

    @When("User fill up Sign up Form With List Data Table")
    public void user_fill_up_sign_up_form_with_list_data_table(DataTable dataTable) {
        //This Example used List of Data. Converting Data table to List.
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);


        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List of List Data Table")
    public void user_fill_up_sign_up_form_with_list_of_list_data_table(DataTable dataTable) {
        // Convert data table to List of List asLists()
        List<List<String>> rawData= dataTable.asLists();
        // Extracting fist row of List
        List<String> data= rawData.get(0);
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);


        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }


    @When("User Click on Sign up button")
    public void user_click_on_sign_up_button() {
        clickElement(SignUpPage.SIGN_UP_BUTTON);
    }
    @Then("User will navigate to Account Profile Page")
    public void user_will_navigate_to_account_profile_page() {
        boolean isDisplayed= isElementDisplayed(AccountProfilePage.YOUR_PROFILE_TEXT);
        Assert.assertTrue(isDisplayed);
    }
    @Then("Validate {string} and email in account page")
    public void validate_and_in_account_page(String expectedName) {
    // public void validate_and_in_account_page(String expectedName, String expectedEmail) {
        String actualName= getElementText(AccountProfilePage.PROFILE_NAME_TEXT);
        Assert.assertEquals(expectedName, actualName);
        //Assert.assertEquals(expectedName, actualName);

        String actualEmail= getElementText(AccountProfilePage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals(generatedRandomEmail, actualEmail) ;

        // Assertion mean comparison


    }
}
