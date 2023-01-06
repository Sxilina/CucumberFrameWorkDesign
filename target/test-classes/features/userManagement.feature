@Regression @userManagement
Feature: Crater User Management
User management focuses on user creation,update and delete 
and also authentication.

 Background:
   Given user is on the login page

  @validLoginTest @loginTests @smokeTest
  Scenario: User is able to login successfully
    When user enters valid "adminuser@primetechschool.com" and "Testing123"
    And clicks on the login button
    Then user should be on the dashboard page
    And user quits the browser

  @invalidLogin @loginTests
  Scenario: Invalid login attempts
    When user enters invalid "hello@john.com" and "password1234"
    And clicks on the login button
    Then an error message appears
    And user is not logged in
    And user quits the browser
    
    @invalidTestSets
    Scenario Outline: Invalid login attempts
    When user enters invalid useremail "<useremail>" and password "<passweord>"
    And clicks on the login button
    Then error messages appear
    And user is not logged in
    And user quits the browser
    
    Examples:
    | useremail                  | passweord       | 
    | helil@primetechschool.com  | standardhhfvajk | 
    | nothing@primetechschool.com| Testing123      |
    |                            | Testing123      |
    | nothing@primetechschool.com|                 |
    
    