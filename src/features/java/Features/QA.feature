@Login
Feature: Verify login functionality

  Scenario Outline: Successfully verifies login functionality
    Given User on the login page
    And Enter <Username>  and <Password>
    When Click on login button
    Then User should navigate to the dashboard page

    
    Examples: 
      | Username  | Password |  
      | Qa        | IFocus@123 | 
      |Free plan  |Ifocus@1234| 
     
    