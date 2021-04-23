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
@toolsSmokeTests
Feature: Tools smoke tests
  I want to use this template for my feature file

  @toolsHeadings
  Scenario: Tests that the hovering over the Tools button presents the right options, and the tools page diplays vice versa.
    Given that the user is on the homepage
    When the user hovers over the Tools link
    Then the correct options are displayed
    When the user clicks the available tools button
    Then the user is taken to the Tools page
    And  the displayed paragraph contains vice versa

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
