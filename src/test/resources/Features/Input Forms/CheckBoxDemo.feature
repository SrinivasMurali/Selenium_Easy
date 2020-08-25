Feature: User can select single, multiple and alternative check box

  @SingleCheckBoxDemo
  Scenario: Verify user is bale to select single check box
    Given Navigate to selenium easy site
    When Select no thanks button in learn selenium automate window
    Then Verify selenium easy page is display
    When Select input forms link in menu list
    And Select checkbox demo link
    And Click single checkbox demo option
    Then Verify check box selected success message

  @MultipleCheckBoxDemo
  Scenario Outline: Verify user is able to select multiple check box
    When Select all check boxes "<CheckBox Count>"
    Then Verify all check boxes are selected

    Examples:
    |CheckBox Count|
    |      4       |

  @AlternativeCheckBoxes
  Scenario: Verify user is able to select alternative check boxes
    When Select alternative check boxes
    Then Verify alternative check boxes are selected

  @UncheckAll
  Scenario: Verify selecting uncheck box all check boxes are unselected
    When Select check all button
    Then Verify all check boxes are selected
    When Select uncheck all button
    Then Verify all check boxes are unselected

  @UncheckButtonVerify
  Scenario: Selecting first three check box uncheck button appear and selecting fourth check box check all button appears
    When select first three check box
    Then Verify uncheck all button appears
    When Select last check box
    Then Verify check all button appears
