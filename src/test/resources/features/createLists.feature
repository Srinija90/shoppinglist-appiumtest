@createLists

Feature: Testing the create lists functionalities

  In order to test the delete list items
  As a user
  I want to able to add list items and delete list items from the list


  @TestCase1 @Smoke @Regression
  Scenario Outline: To verify user is able to add and delete the list items from the created lists
    Given user selects the second layout
    When user creates a <list>
    And user adds the <list-items>
    And user deletes the list item <item>
    Then <item> is deleted successfully
    Examples:
      | list | list-items |            item|
      | list1 | list-item1,list-item2 | list-item2|
      | list2 | list-item3,list-item4 | list-item4|
