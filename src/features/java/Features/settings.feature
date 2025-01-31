Feature: Settings module
 @Settings
  Scenario:Settings
    Given user navigate to settings module
    And click on division
    And clcik on Create Division
    And click on division and enter division
    And click on Biometric Serial Number and  enter number   
    And click on submit button
    Then new division should be created
   
 