@Smoke @Regression
Feature: Major Functionalities for Smoke Test

  @Story_1
  Scenario: Validate Home page title
    Then Validate top left corner is "TEKSCHOOL"

     #Then Validate top left corner is "TekSchool" (first it was fail because we runn in small leterr)
    # Right now is shows fail
    # if want to test pass, need to change the value "TEKSCHOOL"

  @Story_2
  Scenario: Validate Home page title and sign in button
    Then Validate top left corner is "TEKSCHOOL"
    Then Validate Sign In Button is Enabled




    # so later po- product owner decides if they want a smoke test or regression test