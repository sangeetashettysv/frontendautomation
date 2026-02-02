Feature: Users List Page

  Scenario Outline: Verify Users List Page on multiple browsers
    Given user opens the application on "<browser>"
    Then user should see the users list page

    Examples:
      | browser  |
      | chrome   |
      | firefox  |