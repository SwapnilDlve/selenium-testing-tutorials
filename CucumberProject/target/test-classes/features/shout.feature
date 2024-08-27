Feature: Shout Feature
  
  Buisness Rule: The valid range is upto 200 meters

	@no-ui
  Scenario: Valid Range
    Given Sean is 100 meters away from Lucia
    When Sean shouts "Free Coffee"
    Then Lucia listens to the message

  Scenario: Invalid Range
    Given Sean is 900 meters away from Lucia
    When Sean shouts "Free Coffee"
    Then Lucia cannot listen to the message
