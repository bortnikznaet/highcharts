Feature: View Combo Timeline

  @Smoke @OPT1
  Scenario: Scenario: Open Combo Timeline page
    When Open the page
    Then Verification that the page was opened

  @Regression
  @OPT2
  Scenario: Hover Point
    When Open the page
    And Agree to Cookies
    And Hide Revenue data
    Then Hover each tracker point and verify the tooltip contents

