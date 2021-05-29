
@login
Feature: Login and place order
    Background: Launch the app
      Given I launch the app

  Scenario Outline: User should be able to login on app with correct credentials and initial set up should be shown
    Given I am on login screen
    When I login with "<username>" and "<password>"
    And I tap on "signin" button
    And I am on products screen
    And I add item1 to cart
    And I add item2 to cart
    And I remove item1 from cart
    And I click on cart
    And I click on checkout button
    And I enter first name as "<firstname>"
    And I enter last name as "<lastname>"
    And I enter postCode "<postcode>"
    And I click on continue button
    And I scroll down
    And I click on finish button
    And I verify the order
    And I click on back button
    And I click on menu
    And I logout

    Examples:
      | username      | password     | firstname | lastname | postcode |
      | standard_user | secret_sauce | Lingaraj  | Karamudi | 1000     |

