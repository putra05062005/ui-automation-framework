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
    Then saya gagal login

  Scenario: Login kosong
    Given saya membuka halaman login
    When saya memasukkan username kosong
    And saya klik tombol login
    Then saya melihat error kosong