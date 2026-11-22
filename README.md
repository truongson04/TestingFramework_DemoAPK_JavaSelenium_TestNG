# Appium Mobile Automation Framework - My Demo App (Android)

[![Java](https://img.shields.io/badge/Java-20-orange.svg)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-9.2.3-purple.svg)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![ExtentReports](https://img.shields.io/badge/Report-ExtentReports%205-green.svg)](https://www.extentreports.com/)
[![Allure](https://img.shields.io/badge/Report-Allure-yellow.svg)](https://qameta.io/allure-report/)

A robust, scalable mobile test automation framework designed for Android applications using **Java**, **Appium**, **TestNG**, and **Maven**. Built following the **Page Object Model (POM)** pattern, the framework incorporates industry best practices including thread-safe driver management, explicit wait synchronization, automatic failure retries, and comprehensive HTML test reporting (ExtentReports & Allure) with automated screenshot capture.

---

## 📌 Project Overview

This project automates end-to-end user journeys for the **Sauce Labs My Demo App** (`com.saucelabs.mydemoapp.rn`), a standard React Native mobile e-commerce application.

### Target Application Details
* **App Name:** Sauce Labs My Demo App
* **Package Name:** `com.saucelabs.mydemoapp.rn`
* **Main Activity:** `.MainActivity`
* **Platform:** Android (via Appium UiAutomator2 driver)

---

## 🧪 Test Scenario (Exercise 01: End-to-End Checkout Flow)

The automated test scenario (`TestExercise1.java`) executes a complete e-commerce purchase workflow:

| Step | Action | Expected / Verification Result |
| :--- | :--- | :--- |
| **Step 1** | Launch application on Android device / emulator | App is opened on the Products catalog screen. |
| **Step 2** | Tap sort icon and select **"Price – Descending"** | Products are sorted by price in descending order. |
| **Step 3** | Scroll down to the bottom and select the cheapest item | Opens the product details for the last item (*Sauce Labs Onesie*). |
| **Step 4** | Increase quantity to **3**, select color **Gray**, and tap **"Add To Cart"** | Cart badge counter in the top-right corner updates to **"3"**. |
| **Step 5** | Tap Cart button | Cart screen displays the added item with correct item price (`$7.99`) and total price (`$23.97`). |
| **Step 6** | Tap **"Proceed to Checkout"**, log in with predefined credentials, and fill required shipping & payment information | Credentials: `bob@example.com` / `10203040`.<br>Shipping details entered.<br>Payment details entered:<br>• **Full Name:** `USER`<br>• **Card Number:** `4868 7191 9682 9038`<br>• **Expiry:** `02/29`<br>• **CVV:** `344` |
| **Step 7** | Tap **"Review Order"** button | Order summary displays correct item price (`$7.99`) and final total (`$29.96` including shipping). |
| **Step 8** | Tap **"Place Order"** button | **"Checkout Complete"** message is displayed, confirming order completion. |

---

## 🏗️ Architecture & Key Features

* **Page Object Model (POM):** Clean separation between page elements/actions and test scripts for maximum maintainability and readability.
* **Driver Management (`DriverFactory` & `DriverManager`):**
  * `DriverFactory`: Configures `UiAutomator2Options` and instantiates the `AndroidDriver`.
  * `DriverManager`: Employs `ThreadLocal<AppiumDriver>` to ensure thread-safe driver sessions and enable parallel execution readiness.
* **Wait Strategy:** Encapsulated in `BasePage` using `WebDriverWait` (Explicit Wait) for element visibility and clickability, avoiding brittle `Thread.sleep` dependencies during element lookup.
* **W3C Actions / Touch Gestures:** Encapsulated touch gesture methods (`PointerInput` / `Sequence`) for fluid vertical scrolling and swiping across Android devices.
* **Auto-Retry Analyzer:** Integrated `RetryAnalyzer` implementing TestNG's `IRetryAnalyzer` to automatically retry failed tests (configured for 1-2 retries) to eliminate flakiness caused by network or rendering delays.
* **Comprehensive Test Reporting:**
  * **ExtentReports 5:** Generates interactive standalone HTML reports at `target/ExtentReports/ExtentReport.html`.
  * **Allure Reports:** Generates lightweight result artifacts with `@Attachment` integration.
  * **Automated Screenshots:** Captures and attaches Base64/PNG screenshots on test pass and test failure via `TestListener`.

---

## 📁 Project Structure

```text
POM_APIUM/
├── pom.xml                               # Maven project dependencies & build configuration
├── testng.xml                            # TestNG suite runner configuration
├── allure-results/                       # Allure raw test execution logs
├── target/
│   └── ExtentReports/
│       └── ExtentReport.html             # Generated Extent HTML report
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── driver/
    │   │   │   ├── DriverFactory.java    # Driver initialization & capabilities setup
    │   │   │   └── DriverManager.java    # ThreadLocal driver management
    │   │   ├── Listeners/
    │   │   │   ├── RetryAnalyzer.java    # TestNG failure retry handler
    │   │   │   └── TestListener.java     # Suite lifecycle listener & screenshot logger
    │   │   ├── pages/
    │   │   │   ├── BasePage.java         # Common actions, explicit waits & gestures
    │   │   │   ├── ProductPage.java      # Catalog, sorting & scroll actions
    │   │   │   ├── ProductDetailPage.java# Quantity, color selection & add to cart
    │   │   │   ├── CartPage.java         # Cart validation & checkout navigation
    │   │   │   ├── LoginPage.java        # Authentication form actions
    │   │   │   ├── CheckOutPage.java     # Shipping address submission
    │   │   │   ├── CheckOutExtra.java    # Payment details form submission
    │   │   │   └── ReviewOrder.java      # Order verification & final placement
    │   │   └── utils/
    │   │       └── ReportManager.java    # ExtentReports instance management
    │   └── resources/                    # Application resources / properties
    └── test/
        └── java/
            ├── base/
            │   └── BaseTest.java         # Test setup (@BeforeMethod) and teardown (@AfterMethod)
            └── testcases/
                └── TestExercise1.java    # Exercise 01 test execution scenario
```

---

## 🛠️ Prerequisites & Environment Setup

Ensure you have the following installed and configured on your system:

1. **Java Development Kit (JDK):** Version 17 or 20+ installed. Set `JAVA_HOME` environment variable.
2. **Apache Maven:** Version 3.8+ installed. Set `M2_HOME` and add `mvn` to `PATH`.
3. **Node.js & Appium Server:**
   ```bash
   npm install -g appium
   appium driver install uiautomator2
   ```
4. **Android SDK:**
   * Set `ANDROID_HOME` pointing to your Android SDK directory.
   * Add `$ANDROID_HOME/platform-tools` and `$ANDROID_HOME/tools` to system `PATH`.
5. **Android Emulator / Real Device:**
   * An active emulator (e.g. `emulator-5554`) or physical device with USB debugging enabled.
   * Target APK installed: [Sauce Labs My Demo App APK](https://github.com/saucelabs/my-demo-app-rn/releases).

---

## ⚙️ Configuration

Check or modify device details in `src/main/java/driver/DriverFactory.java` to match your target environment:

```java
UiAutomator2Options options = new UiAutomator2Options();
options.setPlatformName("Android");
options.setDeviceName("My phone");
options.setUdid("emulator-5554");                     // Your device UDID or emulator ID
options.setAppPackage("com.saucelabs.mydemoapp.rn");   // Target App Package
options.setAppActivity(".MainActivity");               // Main Entry Activity
driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
```

---

## 🚀 Execution Guide

### 1. Start Appium Server
Open a terminal and start the Appium server:
```bash
appium
```
*Default server URL:* `http://127.0.0.1:4723`

### 2. Run Tests via Maven
Execute the entire test suite using the configured `testng.xml`:
```bash
mvn clean test
```

### 3. Run Tests via TestNG (IDE)
* In IntelliJ IDEA or Eclipse:
* Right-click `testng.xml` -> Select **Run 'testng.xml'**.

---

## 📊 Test Reports & Screenshots

### ExtentReports (HTML)
* Automatically generated after test execution at:
  ```text
  target/ExtentReports/ExtentReport.html
  ```
* Open the HTML file in any browser to inspect:
  * Overall test status (Passed, Failed, Skipped).
  * Execution timestamp and step details.
  * Embedded Base64 screenshots captured upon execution completion.

### Allure Reports
1. Ensure the Allure CLI is installed (`scoop install allure` or `npm install -g allure-commandline`).
2. Generate and open the interactive dashboard:
   ```bash
   allure serve allure-results
   ```

---

## 🧩 Framework Components Breakdown

| Component | Class Name | Purpose |
| :--- | :--- | :--- |
| **Driver Factory** | `driver.DriverFactory` | Encapsulates Android capabilities & driver creation. |
| **Driver Manager** | `driver.DriverManager` | Holds the active driver in a `ThreadLocal` container for isolation. |
| **Base Test** | `base.BaseTest` | Orchestrates driver startup before each test and driver termination (`quit()`) after each test. |
| **Base Page** | `pages.BasePage` | Central repository for explicit waits (`WebDriverWait`), click, sendKeys, and swipe actions. |
| **Page Objects** | `pages.*` | Encapsulates locators (`AppiumBy`) and business actions for each screen. |
| **Test Listener** | `Listeners.TestListener` | Listens to TestNG lifecycle events, updates ExtentReports, and takes screenshots. |
| **Retry Analyzer**| `Listeners.RetryAnalyzer`| Retries test cases automatically when assertions fail due to transient factors. |
| **Report Manager**| `utils.ReportManager` | Thread-safe singleton manager for `ExtentReports` and `ExtentTest` instances. |

---

## 👤 Author
* **Project:** Mobile Automation Testing - My Demo App
* **Framework:** TestNG, Appium, Maven & Page Object Model
