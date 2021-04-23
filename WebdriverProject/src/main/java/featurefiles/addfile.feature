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
@addFileSmokeTest
Feature: Add file smoke test
  I want to use this template for my feature file

  @addFile
  Scenario Outline: Tests that the user is able to add a file
    Given that the user is logged in on the homepage
    When the user clicks the Posts link
    Then the Posts page appears
    When the user clicks the Add New button
    Then the user is shown a welcome popup
    When the user clicks the X button
    Then the popup disappears
    And the Publish button is disabled
    When the user enters text in the "<title>"
    Then the publish button is enabled
    When the user clicks the publish button
    Then a second Publish button appears
    When the user clicks the second button
    Then a View Post link appears
    When the user clicks the View Post link
    Then a page that contains the current date
    And username
    And the "<title>" of the post


    Examples: 
      | title  			| 
      | Dory Roller |  
      | Suolakurkku | 
