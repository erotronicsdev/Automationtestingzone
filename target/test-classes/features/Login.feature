@order
  Feature: Login feature

    Background: New User on the Home page
      Given I am on the Home page
      When I click on the sign in button

    Scenario:
      Given I am on the login page
      When I enter an a registered email
      And an incorrect password
      Then I should see the authentication failed banner
