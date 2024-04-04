@Regression
Feature: Retail app security test feature

  Background: Description about the background
    # background will execute first before each scenario
    Given User click on Sign In Button

  #Change to Scenario: to Scenario Outline, so we can add examples table
  @Security_positive
  Scenario Outline: Validate Valid user credential
    When User enter "<username>" and "<password>" and click on Login
    Then User will see Account button on home page

    Examples:
      | username           | password  |
      | kaur1234@gmail.com | Tek@2023  |
      | mansoor@gmail.com  | Ruya@2014 |

     # Now we can get rid of of these below:
     # Scenario: : Validate different valid user credential
     #Given User click on Sign In Button
     # When User enter "mansoor@gmail.com" and "Ruya@2014" and Click on Login
     # above this steps will take perimeter, take different values from feature file.Then User will see Account button on home page
    # Then User will see Account button on home page

  @Security_Negative
   Scenario Outline: Validate Sign in with Invalid Credentials
    When User enter "<username>" and "<password>" and click on Login
    Then validate error message "<errorMessage>"

     Examples:
       | username          | password      | errorMessage               |
       | Wrong@gmail.com   | 12345678Ab@   | wrong username or password |
       | mansoor@gmail.com | wrongPassword | wrong username or password |
       | wrong@gamil.com   | wrongPassword | wrong username or password |




