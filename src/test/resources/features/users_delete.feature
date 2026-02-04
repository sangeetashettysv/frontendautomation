Feature: Delete user from Users List

  As an admin
  I want to delete a user
  So that inactive or invalid users can be removed from the system

  @req-UL-DEL-001 @usersList
    Scenario Outline: REQ-UL-DEL-001 - Verify delete confirmation dialog on multiple browsers
        Given user opens the application on "<browser>"
        When user clicks the delete action for a user
        Then a delete confirmation dialog should be displayed

        Examples:
        | browser  |
        | chrome   |
        | firefox  |