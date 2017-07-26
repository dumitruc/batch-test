@FAST @UGLY @PREFERRED
Feature: Date processing - fast and ugly
  My big machine can process all sorts of date that have been thrown at it

  PREFERRED

  Simplest batch approach
  Pros:
    Efficient
    Prettier
    Easier to follow (i.e. business read)
  Cons:
    Convoluted codding at the back, more places to go wrong, more maintenance
    Complexity grows exponentially with objects and flow complexity(i.e. lose of flow, context etc...)
    Some break down(or fake) in test flow


  Background: Setup and execution
    Given the dates
      | key | date         |
      | 0   | 20 July 2017 |
      | 1   | 20/07/2017   |
      | 2   | 07/20/2017   |
    And application has run


  Scenario: Passing some simple to understand date
    Given my transaction data contains the date as "20 July 2017"
    When my big machine finished processing the data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

  Scenario: Passing some UK formatted date
    Given my transaction data contains the date as "20/07/2017"
    When my big machine finished processing the data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

  Scenario: Passing some US formatted date
    Given my transaction data contains the date as "07/20/2017"
    When my big machine finished processing the data
    Then it identifies the date as "yyyy/MM/dd" with value "2017/07/20"

#And so on and so forth...