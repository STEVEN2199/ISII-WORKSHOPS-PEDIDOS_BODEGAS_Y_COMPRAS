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
@tag
Feature: Title of your feature
  #I want to use this template for my feature file
  Calculate the insurance prime for a customer
  

  @tag1
  Scenario: The customer is an underage
    Given the client buys an insurance premium
    And is underage
    When calculate the insurance premium
    Then you cannot take out insurance: Minor of age

  @tag2
  Scenario Outline: Title of your scenario outline
    Given the customer calculates insurance prime con <age>
    When the system validate the other information <sex> <isMarried> <driverLicenceValid>
    Then the system calculate the insurance prime

    Examples: 
      | age  | sex | isMarried  | driverLicenceValid  |
      | 4  | M | yes  | yes  |
      | 25  | F | no  | yes  |
      | 92  | M | yes  | yes  |
      
