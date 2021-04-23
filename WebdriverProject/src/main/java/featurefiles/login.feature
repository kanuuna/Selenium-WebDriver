#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@loginSmokeTests
Feature: Login smoke tests
  I want to use this template for my feature file

  @loginSuccess
  Scenario: Tests that a user can login succesfully
    Given user is on the login page
    When the user enters their "<username>"
    Then the "<username>" is entered correctly
    When the user enters their "<password>"
    Then the "<password>" is entered correctly
    When the user clicks the login button
    Then the user is logged in succesfully
	

  @loginSuccess2
  Scenario Outline: Title of your scenario outline
    Given that the browser is open
    And user is on the login page
    When the user enters their "<username>"
    Then the "<username>" is entered correctly
    When the user enters their "<password>"
    Then the "<password>" is entered correctly
    When the user clicks the login button
    Then the user is logged in succesfully
    When the links are shown
    
    

    Examples: 
      | username      | password      |
      | opensourcecms | opensourcecms |
      | Deep          | testing123    |
