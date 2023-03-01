#Author: Vijay Kadaikar
Feature: ToDo List Management

  @Functional @Smoke
  Scenario: MVC_USER should be able to add items in ToDo List and view the added item
    Given MVC_USER launch the url
    When MVC_USER add the ToDo item "ItemContent1"
    Then MVC_USER should be able to view the added ToDo item "ItemContent1"
    Then MVC_USER clicks on active button and ToDo item count must be "1"
    When MVC_USER add the ToDo item "ItemContent2"
    Then MVC_USER should be able to view the added ToDo item "ItemContent2"
    Then MVC_USER clicks on active button and ToDo item count must be "2"
    When MVC_USER add the ToDo item "ItemContent3"
    Then MVC_USER should be able to view the added ToDo item "ItemContent3"
    Then MVC_USER clicks on active button and ToDo item count must be "3"

  @Functional @Smoke
  Scenario: MVC_USER should be able to delete items from ToDo List and validate the removal
    Given MVC_USER launch the url
    When MVC_USER delete the first ToDo item
    Then MVC_USER should not be able to view the added ToDo item "ItemContent1"
    Then MVC_USER clicks on active button and ToDo item count must be "2"
    
    
    
     @Functional
  Scenario: MVC_USER should be able to move the ToDoItem to completed status
    Given MVC_USER launch the url
    When MVC_USER complete the first ToDo item
    Then MVC_USER should be able to view the ToDo item under completed section "ItemContent2"
    Then MVC_USER clicks on active button and ToDo item count must be "1" 

    
    @Functional
   Scenario: MVC_USER should be able to view the ToDoItems from all statuses and clear the completed Items
    Given MVC_USER launch the url
    Then MVC_USER should be able to view the ToDo item under active section "ItemContent3"
    Then MVC_USER clicks on active button and ToDo item count must be "1"
    Then MVC_USER should be able to view the ToDo item under completed section "ItemContent2"
    Then MVC_USER clicks on completed button and ToDo item count must be "1" 
    And MVC_USER should be able to clear the completed items   
    
