Feature: Sort Available Products

  Scenario: Choose to Sort Products by Price (High to Low)
    Given the User Success Login
    When the User Clicks the Sorting Features (A to Z)
    And the User Clicks Products by Price (High to Low)
    Then Products Will Display by Price (High to Low)