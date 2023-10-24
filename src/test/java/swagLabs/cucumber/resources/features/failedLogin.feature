Feature: Failed Login Swag Labs Page

  Scenario: Failed Login
    Given the User Launch the Web Application "Saucedemo" on the Device
    When the User Enters Unregistered Username and Password
    And the User Click Green "Login" Button
    Then User get error message