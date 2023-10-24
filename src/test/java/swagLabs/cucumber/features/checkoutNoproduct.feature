Feature: Checkout in Swaglabs with no product
Scenario: user able to checkout no product
  Given User is on products page
  And User click cart simbol button
  And User click checkout button
  And User send personal data
  When User click the finish button
  Then User will see the success message