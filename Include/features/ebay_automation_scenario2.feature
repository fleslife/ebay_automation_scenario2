Feature: Home Page

  Background: 
    Given I open default page

  Scenario: Verify view all category
    When I type 'MacBook' on 'input_Search'
    And I select '58058' on 'dropdown_SearchCategory'
    And I click 'button_Search'
    Then I should see 'Save this search'
    And I should see text 'Apple Macbook 13" Laptop / UPGRADED 8GB RAM 1TB HD / MAC OS 2017 / WARRANTY' on 'First_Result'
