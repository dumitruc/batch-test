@SLOW @PRETTY
Feature: Date processing - slow and pretty
  My big machine can process all sorts of date that have been thrown at it

  Standard approach
  Pros:
    Easy to create, standard way of thinking
    Ease to code
  Cons:
    very slow and inefficient


  Scenario: Passing some simple to understand date
    Given my transaction has the date as "20 July 2017"
    When my big machine processes this data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

  Scenario: Passing some UK formatted date
    Given my transaction has the date as "20/07/2017"
    When my big machine processes this data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

  Scenario: Passing some US formatted date
    Given my transaction has the date as "07/20/2017"
    When my big machine processes this data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

#And so on and so forth...