Feature: Login Test

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

  Scenario: Login kosong (boundary)
    Given saya membuka halaman login
    When saya tidak memasukkan username dan password
    And saya klik tombol login
    Then saya melihat validasi error