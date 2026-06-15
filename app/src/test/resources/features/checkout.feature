Feature: Checkout

  Scenario: End to End Checkout
    Given user membuka website
    When user login dengan akun valid
    And user memilih produk
    And user masuk ke cart
    And user checkout
    Then user berhasil checkout