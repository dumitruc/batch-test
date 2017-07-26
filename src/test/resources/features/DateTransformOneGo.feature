@FASTEST @UGLIEST
Feature: Date processing - fastest and ugliest
  My big machine can process all sorts of date that have been thrown at it

  Simplest batch approach
  Pros:
    Most efficient
    Ease to code
  Cons:
    Ugliest ever FF, wouldn't even call it a FF
    Quite confusing to follow


  Scenario: Passing some simple to understand date
    Given my transaction "0" has the date as "20 July 2017"
    And my transaction "1" has the date as "20/07/2017"
    And my transaction "2" has the date as "07/20/2017"
    When my big machine processes this data
    Then it identifies the "0" date as "yyyy/MM/dd" with value "2017/07/20"
    And it identifies the "1" date as "yyyy/MM/dd" with value "2017/07/20"
    And it identifies the "2" date as "yyyy/MM/dd" with value "2017/07/20"

#And so on and so forth...