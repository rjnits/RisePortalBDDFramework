Feature: View Final Rating

@third
Scenario: Verify that final rating for year 2018/19 is given by manager

Given user logged in Home page
Then mouse hover to Apprisal and Click on My Apprisal link
Then click on view final rating
Then user move to the bottom of the page
Then verify that final rating is available
