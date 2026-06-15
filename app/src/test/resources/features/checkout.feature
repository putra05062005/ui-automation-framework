Feature: Checkout

  Scenario: End to End Checkout
    Given user login ke saucedemo
    When user melakukan checkout produk
    Then checkout berhasil