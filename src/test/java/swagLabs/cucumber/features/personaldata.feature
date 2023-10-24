Feature: Send personal data in Swaglabs
Scenario: user able to send personal data
  Given user is on personal data page
  And user has entered first name
  And user has entered last name
  And user has entered zipcode
  When user click the continue button
  Then user will see the overview page