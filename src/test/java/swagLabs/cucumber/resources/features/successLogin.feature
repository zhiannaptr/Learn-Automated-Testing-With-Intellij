Feature: Login Swag Labs Page

  Scenario: Success Login
    Given the User Launch the Web Application
    When the User Enters Registered Username and Password
    And the User Click the "Login" Button
    Then the user is on Product Page "https://www.saucedemo.com/inventory.html"