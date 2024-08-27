Feature: Login Feature

  Scenario: Valid Users Scenario
    Given The url of the demo web shop "http://demowebshop.tricentis.com/login/"
    When The user enters valid email "askmail@email.com"
    And  The user enters valid password "abc123"
     * The user clicks on login button
    Then The user is in the shopping page
    But Not on the login page
    
    