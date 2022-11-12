Feature: Navigate

  @navigate
  Scenario: Open Login Page
    Given Navigate to Page Phone Book
    When Click on Login tab
    Then Appear LoginRegistration form
