@tags

Feature: Open page
  Scenario: Open website
    And I Setup Browser "Chromium"
    And I open page "https://seleniumbase.io/demo_page"
    And I click on button "Button:"
    And I wait for "10" seconds
    And I tear down