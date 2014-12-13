@RUNNABLE @DEBUG @ENVIRONMENT
Feature: Environment setup verification
  As a QA Analyst
  I want to make sure the environment wiring is working correctly
  So that when I start test execution

  Scenario Outline:
    Given I have test conditions id: <tc-id>
    And I have setup my cucumber framework
    When I say hello to <whom>
    Then <whom> says hello back to <who>
  Examples:
    | tc-id | whom     | who      |
    | 001   | Cucumber | dumitruc |