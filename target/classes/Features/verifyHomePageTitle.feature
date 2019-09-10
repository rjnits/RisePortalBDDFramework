Feature: Home Page title of Rise portal

@first
Scenario: Verify Home Page title of Rise portal

Given user on login page
When user enters username and password and click submit button
Then verify user is on home page
