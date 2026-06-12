Feature: Login

  Scenario: Login berhasil
    Given saya membuka halaman login
    When saya memasukkan username dan password yang benar
    And saya klik tombol login
    Then saya berhasil login

  Scenario: Login gagal
    Given saya membuka halaman login
    When saya memasukkan username dan password yang salah
    And saya klik tombol login
    Then muncul pesan error

  Scenario: Login kosong (boundary)
    Given saya membuka halaman login
    When saya memasukkan username dan password yang salah
    And saya klik tombol login
    Then muncul pesan error