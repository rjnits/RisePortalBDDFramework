$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/raju.das/eclipse-workspace/RisePortalBDDFramework/src/main/java/Features/verifyHomePageTitle.feature");
formatter.feature({
  "line": 1,
  "name": "Home Page title of Rise portal",
  "description": "",
  "id": "home-page-title-of-rise-portal",
  "keyword": "Feature"
});
formatter.before({
  "duration": 100000,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Home Page title of Rise portal",
  "description": "",
  "id": "home-page-title-of-rise-portal;verify-home-page-title-of-rise-portal",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@first"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enters username and password and click submit button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "verify user is on home page",
  "keyword": "Then "
});
formatter.match({
  "location": "VerifyHomaPageStepDefination.user_on_login_page()"
});
formatter.result({
  "duration": 10570050800,
  "status": "passed"
});
formatter.match({
  "location": "VerifyHomaPageStepDefination.user_enters_username_and_password_and_click_submit_button()"
});
formatter.result({
  "duration": 3551616900,
  "status": "passed"
});
formatter.match({
  "location": "VerifyHomaPageStepDefination.user_is_on_home_page()"
});
formatter.result({
  "duration": 8298400,
  "status": "passed"
});
formatter.after({
  "duration": 190588400,
  "status": "passed"
});
});