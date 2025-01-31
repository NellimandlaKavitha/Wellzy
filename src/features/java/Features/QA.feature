Feature: Verify login functionality

  @Login
  Scenario Outline: Successfully verifies login functionality
    Given User on the login page
    And Enter <Username> and <Password>
    When Click on login button
    Then User should navigate to the dashboard page

   