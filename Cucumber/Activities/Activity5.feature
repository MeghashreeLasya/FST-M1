@activity5
Feature: Data driven test with Example

  @activities
  Scenario Outline: Testing with Data from Scenario
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the Browser

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |