# 🚀 UI Automation Framework (Selenium + Cucumber + CI/CD)

## 📌 Overview

This project is a UI Automation Testing Framework built using **Java, Selenium WebDriver, and Cucumber (BDD)**.
It implements **Page Object Model (POM)** and integrates with **GitHub Actions** for continuous integration.

The framework covers:

* Login testing (positive, negative, boundary)
* End-to-End (E2E) checkout flow
* Automated test execution in CI environment

---

## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* Cucumber (BDD)
* JUnit 5
* Gradle
* GitHub Actions (CI/CD)

---

## 🧱 Project Structure

```
pages/
 ├── BasePage.java
 ├── LoginPage.java
 ├── ProductPage.java
 ├── CartPage.java
 └── CheckoutPage.java

steps/
 ├── Hooks.java
 ├── LoginSteps.java
 └── CheckoutSteps.java

features/
 ├── login.feature
 └── checkout.feature
```

---

## ✅ Test Scenarios

### 🔐 Login Testing

* ✔ Valid login (success)
* ✔ Invalid login (wrong credentials)
* ✔ Empty login (boundary case)

### 🛒 End-to-End Checkout

* Login to system
* Select product
* Add to cart
* Proceed to checkout
* Complete order
* Verify success message

---

## ▶️ How to Run (Local)

Run all tests:

```
./gradlew clean test
```

Run with visible browser:

```
./gradlew test
```

Run in headless mode:

```
./gradlew test -Dheadless=true
```

---

## ⚙️ CI/CD Integration

This project uses **GitHub Actions** to automatically run tests on every:

* Push
* Pull Request

Pipeline includes:

* Java setup
* Chrome installation
* Test execution
* Test report upload

---

## 📊 Test Report

After execution, reports are generated in:

```
app/build/reports/
```

In CI, reports are uploaded as artifacts.

---

## 🔥 Key Features

* Page Object Model (POM) design pattern
* Behavior Driven Development (BDD)
* Parameterized test steps
* Reusable WebDriver setup
* Headless browser support for CI
* End-to-End testing workflow

---

## 🎯 Purpose

This project demonstrates:

* Automation testing skills
* CI/CD integration
* Real-world testing workflow
* Debugging in different environments (local vs CI)

---

## 👨‍💻 Author

Pahala Putra Tambunan

---
