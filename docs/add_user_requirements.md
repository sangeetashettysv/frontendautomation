# Requirement: Add User Functionality

## Requirement ID
**REQ-UL-ADD-001**

## Title
Add a new user to the system

## Description
As an admin, I want to add a new user to the system so that new users can be managed and tracked.

---

## Positive Test Cases

**Test Case ID:** TC-ADD-001  
**Scenario:** Add valid user  
**Steps:**  
1. Open Users List page  
2. Click Add User  
3. Fill valid user details  
4. Submit form  
**Expected Result:** New user is added successfully and visible in Users List  
**Tags:** @addUser, @positive  

---

## Negative Test Cases

**Test Case ID:** TC-ADD-002  
**Scenario:** Add user with missing required fields  
**Steps:**  
1. Open Users List page  
2. Click Add User  
3. Leave required fields empty  
4. Submit form  
**Expected Result:** Error messages are displayed and user is NOT added  
**Tags:** @addUser, @negative  

**Test Case ID:** TC-ADD-003  
**Scenario:** Add user with invalid email format  
**Steps:**  
1. Open Users List page  
2. Click Add User  
3. Enter invalid email  
4. Submit form  
**Expected Result:** Error message shown, form submission blocked  
**Tags:** @addUser, @negative  

---

## Traceability

- Requirement `REQ-UL-ADD-001` → Test Cases: `TC-ADD-001`, `TC-ADD-002`, `TC-ADD-003`  
- Automated test can use this ID for traceability and reporting.