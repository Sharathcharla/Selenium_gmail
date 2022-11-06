Feature: Login Feature File

  @selenium
  Scenario Outline: Login scenario test for Gmail
    Given navigate to Gmail page
    When user logged in using username as <username> and password as <password>
    Then home page should be displayed
    And compose the email
    Examples:
      |abc  |abc |
