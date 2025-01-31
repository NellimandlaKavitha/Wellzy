Feature: Verify dashboard functionality

  @Dashboard
  Scenario: Successfully verified dashboard page
    Given user is on the dashboard page
    And click on the elements: today, weekly, monthly
    And click on create button, member
    And click on create button, lead
    And click on create button,staff
