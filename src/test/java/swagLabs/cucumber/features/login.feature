Feature: Login Swaglabs dengan valid input
  Scenario: User login Swaglabs berhasil
    Given User masuk ke halaman login Swaglabs
    And User memasukkan "username"
    And User memasukkan "password"
    When User mengklik tombol "login"
    Then User berhasil dapat melihat halaman "products"