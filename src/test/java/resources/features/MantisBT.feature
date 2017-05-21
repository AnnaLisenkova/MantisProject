Feature: Task cycle
  Scenario: MyScenario for working with task
    Given Log in as "tester1"
      And Click on CreateTask button on the top
     When Fill the form with info from "MyTask"
      And Submit created task
      And Open Task List
    Then Task List contains "MyTask"
    And Log out
    Given Log in as "dev1"
      And Open Task List
    Then Task List contains "MyTask"
    Given Open "MyTask" review
      And Task fields contain information from "MyTask"
    Then Change "MyTask" status to "решена" by "dev1"
    And Click on "Перевести в:" button
    And Click on "Решить" button at Task Solution Form
    And Log out
    Given Log in as "lead1"
      And Open Task List
    Then Task List contains "MyTask"
    Given Open "MyTask" review
    Then Change "MyTask" status to "закрыта" by "lead1"
      And Click on "Перевести в:" button
     When Change responsibility to "lead1"
    Then Click on "Закрыть задачу" button at Task Solution Form
    Given Open Review Page
      And Click on "Недавно измененные (30 Дней)"
    Then Task List contains "MyTask"

