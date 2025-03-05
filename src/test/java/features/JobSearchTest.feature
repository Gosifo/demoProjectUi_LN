Feature: Searches for a job

  @Test
  Scenario Outline: Verify that the user is able to search for a job
    Given I navigate to the LexisNexis website
    When I navigate to the careers job page
    And I enter "<Job Search>" in the search field for jobs or keywords
    And I select the search option
    Then I should see more than 1 search result returned for "<Job Search>"
    And I should see <NoOfRole> role(s) listed for "<Job Search>"
    Examples:
      | Job Search            | NoOfRole |
      | Automation tester     | 10       |
      | Senior Data Scientist | 14       |
      | AutomationTester      |          |