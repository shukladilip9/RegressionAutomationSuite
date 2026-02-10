Feature: Login Functionality

  Scenario: User logs in successfully
    Given User is on login page
    When User enters username "Admin" and password "admin123"
    And User clicks on login button
    Then User should see the dashboard

    Scenario: Add
      Given User is on login page
      When User enters username "Admin" and password "admin123"
      And User clicks on login button
      Then Sum is 3