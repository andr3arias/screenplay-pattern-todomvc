@cucumber
@deletingSomeTasks
Feature: Deleting a number of tasks

  In order to make me feel **a sense of accomplishment**
  As a tidy person
  I want to delete a series of tasks

  Scenario: Delete an number of tasks sequentially
    Given that Jane has a todo list containing 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
    When she deletes the first 10 tasks
    Then the number of items left should be 10
