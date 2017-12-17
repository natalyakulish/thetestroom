Feature: Animal adoption

  @qa
  Scenario Outline: Name should be Displayed below the text enter field

    Given User is on "Home" page
    When User input "<Name>"
    Then "<Name>" is displayed

    Examples:

      | Name       |
      | Tony Stark |

  Scenario Outline: Check confirmation text

    Given User is on "Home" page
    When User input "<Name>"
    And User presses "Continue" button
    And User selects "<Animal name>"
    And User presses "Continue" button
    Then confirmation text "Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal." is displayed


    Examples:

      | Name       | Animal name    |
      | Tony Stark | Simba the Lion |

  Scenario Outline: User should not be able to adopt when User does not enter a Name
    Given User is on "Home" page
    When User presses "Continue" button
    And User selects "<Animal name>"
    And User presses "Continue" button
    Then User is not on "Confirmation" page

    Examples:

      | Animal name    |
      | Simba the Lion |

  Scenario Outline: Adopt another animal after a complete Adoption
    Given User is on "Home" page
    When User input "<First User Name>"
    And User presses "Continue" button
    And User selects "<First Animal name>"
    And User presses "Continue" button
    Then confirmation text "Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal." is displayed
    And User presses "Back to home" button
    When User input "<Second User Name>"
    And User presses "Continue" button
    And User selects "<Second Animal name>"
    And User presses "Continue" button
    Then confirmation text "Thank you for your selection. Your animal adoption papers will be sent to you shortly with a lovely card from your selected animal." is displayed


    Examples:

      | First User Name | First Animal name | Second User Name | Second Animal name |
      | Tony Stark      | Simba the Lion    | Ned Stark        | Nemo the Fish      |
