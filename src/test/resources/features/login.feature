Feature: Login

  @validData
  Scenario: Login with the valid data
    Given Navigate to Page Phone Book
    When Click on Login tab
    And Enter the valid data
    And Click Login Button
    Then SignOut button displayed

    @invalidPassword
    Scenario Outline: Login with the valid email and an invalid password
      Given Navigate to Page Phone Book
      When Click on Login tab
      And Enter the valid email and an invalid password
        | email | password |
        |<email>| <password>|
      And Click Login Button
      Then Alert appeared
      Examples:
        | email | password |
        | Man@mail.com | Aa12345|
        | Man@mail.com | a12345~|
