Feature: Verifying simple input fields

  @SingleInputField
  Scenario Outline: Verifying single input field is working as expected
    Given Open the browser and navigate to selenium easy site
    When Select no thanks button in learn selenium automate window
    Then Verify selenium easy page is display
    When Select input forms link in menu list
    And Select simple form demo link
    And Enter string in message field "<Message>"
    And click on show message button
    Then Verify display string message is expected

    Examples:
      | Message                               |
      | This is the simple message to display |

  @TwoInputField
  Scenario Outline: Verify user is able to enter input in two fields
    Given Open the browser and navigate to selenium easy site
    When Select no thanks button in learn selenium automate window
    Then Verify selenium easy page is display
    When Select input forms link in menu list
    And Select simple form demo link
    And Enter number in a field "<message a>"
    And Enter number in b field "<message b>"
    And Click on get total button
    Then Verify a and b total values are correct "<total>"

    Examples:
      | message a |  | message b |  | total |
      | 101       |  | 200       |  | 301   |
      | 201       |  | 301       |  | 504   |




Feature: Verifying simple input fields are working expected

  @SingleInputField
  Scenario : Verifying user is able to enter message in text box
    Given Open the browser and navigate to selenium easy site
    When Select input forms link in menu list
    And click on show message button
    Then Verify display string message is expected