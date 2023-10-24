Feature: Send personal data in Swaglabs with no data
Scenario: user unable to send personal data
  Given User is on personal data page
  And User has not entered first name
  And User has not entered last name
  And User has not entered zipcode
  When User click the continue button
  Then User will not see the overview page