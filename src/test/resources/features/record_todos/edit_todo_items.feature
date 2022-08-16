@cucumber
@editing
Feature: edit any item in the todo list
  as a To-do app user
  I want to be able to edit the registered tasks.

  Scenario: Edit registered task
    Given that Jane has a todo list that contains Buy milk, Wash the car, take the dog out
    When she tries to change the task 'Buy milk' to 'Buy bread'
    And she filters her list to show only Active tasks
    Then her todo list should show Buy bread, Wash the car, take the dog out
