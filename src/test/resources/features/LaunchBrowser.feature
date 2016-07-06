Feature: Launch browser for testing

  @WEBUI
  Scenario: Navigate to google search page in chrome
    Given I have test conditions id: launch-browser
    When I navigate to url "http://www.google.co.uk"
