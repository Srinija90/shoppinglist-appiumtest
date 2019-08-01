@sortListItems

Feature: Testing the sort list items functionalitie

  In order to test the sort list items
  As a user
  I want to able to add list items and sort the list items

  @TestCase2 @Smoke @Regression
  Scenario Outline: To verify user is able to sort the list items
    Given user selects the second layout
    When user creates a <list>
    And user adds the <list-items>
    And sort the list items in alphabetical order
    Then list items should be sorted <sorted-items>

    Examples:
      | list | list-items | sorted-items|
      | list1 | defg,abcd,zxfv,vfgh | abcd,defg,vfgh,zxfv |