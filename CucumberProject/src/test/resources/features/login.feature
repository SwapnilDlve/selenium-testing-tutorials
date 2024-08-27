Feature: Login Feature

  Scenario: Valid Login
    
    Given "Login" Page is Visible to Sean
    When Sean Logins to page using "sdalve" and "Dalve@1234"
    Then Sean sees Message "Hi!!"

