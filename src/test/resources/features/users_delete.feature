Feature: Delete user from Users List

  As an admin
  I want to delete a user
  So that inactive or invalid users can be removed from the system

  # ---------------- Positive Tests ----------------
  @req-UL-DEL-001 @deleteuser @positive
  Scenario Outline: REQ-UL-DEL-001 - Delete newly created user successfully
    Given user opens the application on "<browser>"
    When user creates a new user
    And user clicks the delete action for the newly created user
    Then a delete confirmation dialog should be displayed
    When user confirms deletion
    Then the deleted user should no longer appear in the users list
    # And a delete success message should be shown to the user

    Examples:
      | browser  |
      | chrome   |
      | firefox  |

  # ---------------- Negative / Cancel Tests ----------------
  @req-UL-DEL-002 @deleteuser @negative
  Scenario Outline: REQ-UL-DEL-002 - Cancel deletion and verify user still exists
    Given user opens the application on "<browser>"
    When user creates a new user
    And user clicks the delete action for the newly created user
    Then a delete confirmation dialog should be displayed
    When user cancels deletion
    Then the user should still appear in the users list

    Examples:
      | browser  |
      | chrome   |
      | firefox  |

  # ---------------- Debug / Failing Test ----------------
  @req-UL-DEL-003 @deleteuser @debug
  Scenario Outline: REQ-UL-DEL-003 - Intentional fail the test
    Given user opens the application on "<browser>"
    When user creates a new user
    And user clicks the delete action for the newly created user
    Then a delete confirmation dialog should be displayed
    When user confirms deletion
    Then assert incorrectly that the user still appears in the users list

    Examples:
      | browser  |
      | chrome   |
      | firefox  |
