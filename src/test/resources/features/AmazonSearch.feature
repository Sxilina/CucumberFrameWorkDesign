Feature: Amazon search

  @amazonSearchTests
  Scenario Outline: Search items on amazon
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And I click on search button
    Then I should see the search item "<items>" on search result page
    And the page titile should contain the searched item "<items>"

    Examples: 
      | name  |
      |coffee mug |
      | pretty coffee mug |
      | ugly coffee mug |
      | small coffee mug |
      | golden coffee mug |
