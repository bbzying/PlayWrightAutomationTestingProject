@tags

Feature: Open page
  Scenario: Open website
    And I Setup Browser "msedge"
    And I open page "http://www.amazon.com"
    And I tear down