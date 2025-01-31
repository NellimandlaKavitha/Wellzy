Feature: People module

  @People
  Scenario: Successfully verified people module
    Given navigate to people
    And click on elements: member, lead, staff, know your wellness
    Then click on create new, create member
    Then click on create new, create lead
    Then click on create new, create staff