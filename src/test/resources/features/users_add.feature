Feature: Add user to Users List

  As an admin
  I want to add a new user
  So that new users can be managed in the system

  @req-UL-ADD-001
  Scenario Outline: REQ-UL-ADD-001 - Add User form is shown when Add User is clicked
    Given user opens the application on "<browser>"
    When user clicks the Add User action
    Then user should see the Add User form

    Examples:
      | browser  |
      | chrome   |
      | firefox  |