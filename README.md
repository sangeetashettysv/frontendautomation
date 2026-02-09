# Frontend Automation Project

This is a Selenium + TestNG + Cucumber BDD automation project for a frontend application: [Mock User Management](https://mock-user-management-42cc2.web.app/).

## Project Structure

## Setup

1. Clone the repository.
2. Install [Java 23](https://www.oracle.com/java/technologies/) and Maven.

# Running Tests Locally

1. Clone the repository

- git clone <your-github-repo-url>
- cd ApiAutomation

2. Run all tests
- Run the following command from the project root:
- mvn clean test

3. Run only Add User tests:
- mvn clean test -Dcucumber.filter.tags="@adduser"

4. Run only Delete User tests:
- mvn clean test -Dcucumber.filter.tags="@deleteuser"

**Test Reports**

- After execution, open the HTML report: target/cucumber-reports.html in your browser to view the test results.