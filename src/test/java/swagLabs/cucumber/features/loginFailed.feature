Feature: Login Swaglabs dengan invalid input
  Scenario: User login Swaglabs gagal
    Given User masuk ke login page Swaglabs
    And User memasukkan invalid username
    And User memasukkan invalid password
    When User mengklik login button
    Then User gagal melihat halaman products