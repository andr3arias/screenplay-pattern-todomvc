@cucumber
@editing
Feature: edit any item in the todo list

  as a To-do app user
  I want to be able to edit the registered tasks.

  Scenario: Edit registered task
    Given that Jane has a todo list that contains Buy milk, Wash the car, take the dog out
    When she tries to change the task Buy milk, to Buy bread
    And filters her list to show only active tasks
    Then her todo list should show Buy bread, Wash car, take out dog
