@Regression @CreateAccount
Feature: Create New Account Page

  @CreateNewAccount
  Scenario: Create new Account with valid credential
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill Form "Kulvinder" and "kulvinder@gmail.com" and "44568Ab@"
    # When User fill Form "name" and "email" and "password"
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Kulvinder" and email in account page
# 1st step can have like up to 10 paramaeters - maximum is 6 or 8
    #Then Validate "Kulvinder" and "kaur@gmail.com" in account page
  # data scenario
  # data table is for one single step and the data table only and only passing the entire data it has to just one step
  # Features comes from Gherkins


  @CreateNewAccount_2
    # below using data table
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form
    # left column is keys| right column is values
      | email    | kulvinder@gmail.com |
      | password | 44568Ab@            |
      | username | Kulvinder           |
    # 6 permieter coding, if it is more, it is a bad coding
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Kulvinder" and email in account page
    # 2nd steps is call the data table, using a pipes on the steps and these steps will run for any data

  @CreateNewAccount_3
    # Example of list
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List Data Table
      | Kulvinder           |
      | kulvinder@gmail.com |
      | 44568Ab@            |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Kulvinder" and email in account page
    # will only have value no keys

  @CreateNewAccount_4
    #4th using a list of Maps- can have multiple row of data, these help when you run with the data table
  Scenario: Create new Account with valid credential Using List of Maps
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List of Map Data Table
      | name | email             | password  |
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page

  @CreateNewAccount_5
    #5th using a list list, just has values
  Scenario: Create new Account with valid credential Using List of List
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List of List Data Table
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page







