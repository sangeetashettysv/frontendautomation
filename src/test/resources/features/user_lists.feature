Feature: Users List Page

  As an admin
  I want to view the users list
  So that I can see all users in the system

  @req-UL-LIST-001 @positive @userlist
  Scenario Outline: REQ-UL-LIST-001 - Verify Users List page loads correctly
    Given user opens the application on "<browser>"
    Then user should see the users list page

    Examples:
      | browser |
      | chrome  |
      | firefox |
