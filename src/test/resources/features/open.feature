Feature: View Combo Timeline

  @OPT1
  Scenario: Scenario: Open Combo Timeline page
    When Open the page
    Then Verification that the page was opened

  @OPT2
  Scenario: Hover Point
    When Open the page
    And Agree to Cookies
    And Hide Revenue data
    Then Hover each tracker point and verify the tooltip contents

