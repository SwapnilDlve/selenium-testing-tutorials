Feature: Login Feature

  Background: 
    Given The url of the demo web shop "http://demowebshop.tricentis.com/login/"
	
	@valid @smoke
  Scenario Outline: Valid Users Scenario
    When The user enters valid email "<email>"
    And The user enters valid password "<password>"
    * The user clicks on login button
    Then The user is in the shopping page
    But Not on the login page

    Examples: 
      | email             | password |
      | askmail@email.com | abc123   |
      | askmail@ymail.com | abc123   |
      | askmail@gmail.com | abc123   |

@invalid @smoke
  Scenario Outline: Invalid Users Scenario
    When The user enters Invalid email "<email>"
    And The user enters Invalid password "<password>"
    * The user clicks on login button
    Then The user is in the login page
    But Not on the shopping page

    Examples: 
      | email             | password |
      | askmail@email.com | abc1234  |
      | askmail@ymail.com | abc1234  |
      | askmail@gmail.com | abc1234  |

