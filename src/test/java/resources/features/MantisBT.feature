Feature: Task cycle
  Scenario: MyScenario for working with task
    Given Log in as "tester1"
      And Click on CreateTask button on the top
    When Fill the form with info from "MyTask"
      And Submit created task
      And Open Task List
    Then Task List contains "MyTask" with condition "назначена" by "dev1"
    And Log out
    Given Log in as "dev1"
      And Open Task List
    Then Task List contains "MyTask" with condition "назначена" by "dev1"
    Given Open "MyTask" review
      And Task fields contain info from "MyTask" with some additional
          | originator |  tester1  |
          |   status   | назначена |
          | resolution |  открыта  |
    Then Change task status to "решена"
      And Click on "Перевести в:" button
      And Click on "Решить" button at Task Solution Form
      And Log out
    Given Log in as "lead1"
      And Open Task List
    Then Task List contains "MyTask" with condition "решена" by "dev1"
    Given Open "MyTask" review
    Then Change task status to "закрыта"
      And Click on "Перевести в:" button
    When Change responsibility to "lead1"
    Then Click on "Закрыть задачу" button at Task Solution Form
    Given Open Review Page
      And Click on "Недавно изменённые (30 дней)"
     Then Task List contains "MyTask" with condition "закрыта" by "lead1"

