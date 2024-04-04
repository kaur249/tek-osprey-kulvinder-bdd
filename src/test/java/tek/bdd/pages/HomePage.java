package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {


    // Constant Variable POM approach- created one class
    // Constant Variable naming convention. all letter capital
    // and _ instead of space
    public static final By TOP_NAV_LOGO = By.className("top-nav__logo");

    public static final By SIGN_IN_BUTTON = By.id("signinLink");

    public static final By ACCOUNT_LINK= By.linkText("Account");


}
