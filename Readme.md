# UI Automation Testing Framework

## 📌 Overview

This project is a web UI automation testing framework built using:

* Java
* Gradle
* Selenium WebDriver
* Cucumber (BDD)

The framework is designed to automate testing of web applications using behavior-driven development (BDD) approach.

---

## ⚙️ Technologies Used

* Java
* Gradle
* Selenium WebDriver
* Cucumber
* JUnit

---

## 🏗️ Project Structure

```
src/test/java/
 ├── pages/        → Page Object Model (POM)
 ├── steps/        → Step Definitions
 └── runner/       → Test Runner

src/test/resources/
 └── features/     → Gherkin Test Cases
```

---

## 🧪 Test Scenarios

### ✅ Positive Test

* Login with valid username and password

### ❌ Negative Test

* Login with invalid credentials

### ⚠️ Boundary Test

* Login with empty or incorrect input

---

## 🚀 How to Run

```bash
./gradlew test
```

---

## 📊 Test Report

After running the test, the report will be generated at:

```
app/build/reports/cucumber-report.html
```

---

## 🎯 Features

* Automated UI testing using Selenium
* BDD-style testing with Cucumber
* Page Object Model (POM) implementation
* Structured and maintainable test code
* HTML test reporting

---

## 👨‍💻 Author

Pahala Putra Tambunan
