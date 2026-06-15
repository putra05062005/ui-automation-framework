Feature: Login

  Scenario: Login berhasil
    Given user membuka website
    When user login dengan username "standard_user" dan password "secret_sauce"
    Then user berhasil login

  Scenario: Login gagal
    Given user membuka website
    When user login dengan username "wrong" dan password "wrong"
    Then user gagal login

  Scenario: Login kosong
    Given user membuka website
    When user login dengan username "" dan password ""
    Then user melihat error login