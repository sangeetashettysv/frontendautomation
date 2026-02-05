@users @addUser
Feature: Add user to Users List

  As an admin
  I want to add a new user
  So that new users can be managed in the system

  @sanity @regression @req-UL-ADD-001
  Scenario Outline: REQ-UL-ADD-001 - Add User form is shown
    Given user opens the application on "<browser>"
    When user clicks the Add User action
    Then Add User form should be displayed

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @regression @req-UL-ADD-002
  Scenario Outline: REQ-UL-ADD-002 - Add button enabled for valid data
    Given user opens the application on "<browser>"
    When user clicks the Add User action
    And user enters valid user details
    Then Add button should be enabled

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @regression @negative @req-UL-ADD-003
  Scenario Outline: REQ-UL-ADD-003 - Invalid email validation
    Given user opens the application on "<browser>"
    When user clicks the Add User action
    And user enters invalid email
    Then email validation error should be shown
    And Add button should be disabled

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @debug @negative @req-UL-ADD-004
  Scenario Outline: REQ-UL-ADD-004 - Intentional failure for debugging
    Given user opens the application on "<browser>"
    When user clicks the Add User action
    And user enters invalid phone number
    Then Add button should still be enabled

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @regression @req-UL-ADD-005
  Scenario Outline: REQ-UL-ADD-005 - Newly added user is visible in users list
  Given user opens the application on "<browser>"
  When user clicks the Add User action
  And user enters valid user details
  And user submits the Add User form
  Then a success message should be shown to the user
  And the newly added user should appear in the users list

  Examples:
    | browser |
    | chrome  |
    | firefox |