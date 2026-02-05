# Requirement: Delete User Functionality

## Requirement ID
**REQ-UL-DEL-001**

## Title
Delete a user from the system after creation

## Description
As an admin, I want to delete a user from the system so that inactive or invalid users can be removed. The deletion should be possible for any user, including newly created users. A confirmation popup must be shown before deletion.

---

## Positive Test Cases

**Test Case ID:** TC-DEL-001  
**Scenario:** Delete a newly created user successfully  
**Steps:**  
1. Open Users List page at https://mock-user-management-42cc2.web.app/  
2. Create a new user using the Add User functionality  
3. Verify the user appears in the Users List  
4. Click the delete action for the newly created user  
5. Verify the delete confirmation popup shows:  
   - Title includes user name and ID  
   - Text: "Are you sure you want to delete the user?"  
   - Buttons: Close, Yes Delete  
6. Click "Yes Delete" to confirm  
**Expected Result:**  
- User is removed from the Users List  
- (Optional) Success message is displayed  
**Tags:** @deleteUser, @positive, @req-UL-DEL-001  

**Test Case ID:** TC-DEL-002  
**Scenario:** Cancel deletion of a newly created user  
**Steps:**  
1. Open Users List page  
2. Create a new user  
3. Click the delete action for the newly created user  
4. Verify the delete confirmation popup  
5. Click "Close" button or the close icon on the popup  
**Expected Result:**  
- User remains in the Users List  
- No success message is shown  
**Tags:** @deleteUser, @negative, @req-UL-DEL-001  

---

## Negative / Debug Test Cases

**Test Case ID:** TC-DEL-003  
**Scenario:** Intentional failure for debugging  
**Steps:**  
1. Create a new user  
2. Attempt to delete the user but assert incorrectly that the user still exists  
**Expected Result:**  
- Assertion fails to test debugging practices  
**Tags:** @deleteUser, @debug, @req-UL-DEL-001  

---

## Traceability

- Requirement `REQ-UL-DEL-001` → Test Cases: `TC-DEL-001`, `TC-DEL-002`, `TC-DEL-003`  
- Automated tests will use these IDs in the code for traceability and reporting.
