Feature: Delete user from Users List

  As an admin
  I want to delete a user
  So that inactive or invalid users can be removed from the system

  @req-UL-DEL-001
  Scenario: REQ-UL-DEL-001 – Confirmation dialog is shown when delete is clicked
    Given I am on the Users List page
    When I click the delete action for a user
    Then a delete confirmation dialog should be displayed