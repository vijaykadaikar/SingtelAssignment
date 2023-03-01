#Author: Vijay Kadaikar
Feature: ToDo List UI

  @Functional @Boundary
  Scenario: MVC_USER should be able to add items of size as per the boundaries set
    Given MVC_USER launch the url
    When MVC_USER complete the first ToDo item
    Then User add the ToDo item of different sizes
      |  1 |
      |  2 |
      | 32 |
      | 64 |
    Then MVC_USER clicks on active button and ToDo item count must be "4"

  @Functional @UI @Usability
  Scenario: MVC_USER should be able to view all significant sections of UI
    Given MVC_USER launch the url
    Then MVC_USER should be able to view "todos" as heading
    Then MVC_USER should be able to view "What needs to be done?" as placeholder for ToDoItem textbox
    Then MVC_USER should be able to view the left pane with different sections
      | Official Resources |
      | Community          |
    Then MVC_USER should be able to view the footer with different sections
      | Double-click to edit a todo |

  @Functional  @Usability
  Scenario: MVC_USER should be able to refresh page and retain the list
  Given MVC_USER launch the url
  Then MVC_USER clicks on active button and ToDo item count must be "4"
  When MVC_USER do the page refresh
  Then MVC_USER clicks on active button and ToDo item count must be "4"  
  
  
   @Functional  @Bug
  Scenario: MVC_USER should be able to edit the item
  Given MVC_USER launch the url
  When MVC_USER clicks on completed button
  Then MVC_USER edit the completed item
  