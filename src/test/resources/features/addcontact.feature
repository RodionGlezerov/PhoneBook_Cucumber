Feature: AddContact

  @validContact
  Scenario Outline: Add Contact
    Given Navigate to Page Phone Book
    When Click on Login tab
    And Enter the valid data
    And Click Login Button
    And Click ADD Button
    And Enter Valid Contact Information
      | name   | lastName   | phone   | email   | address   | description   |
      | <name> | <lastName> | <phone> | <email> | <address> | <description> |
    And Click Save
    Then Appear New Contact
    Examples:
      | name | lastName | phone | email        | address | description       |
      | Tom  | Ford     | 22222 | tf@gmail.com | Berlin  | Valid information |