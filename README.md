# Automated UI Testing with Selenium & Cucumber

## Project Overview
This project is a Selenium-based UI automation framework utilizing Cucumber for behavior-driven development (BDD). It automates the job search functionality on the LexisNexis website, ensuring a seamless and efficient testing process.

Tech Stack
•   Java: 11 (Update version as needed in pom.xml)
•   Selenium WebDriver: 4.29.0
•   Cucumber BDD: 7.21.0
•   JUnit 4: 4.13.2
•   WebDriverManager: 5.8.0
•   Maven: Build & Dependency Management

## Project Structure
|-- src/test/java

|  |-- stepDefinitions/  # Cucumber Step Definitions

|   |-- features/         # Cucumber Feature Files

|   |-- runners/          # Test Runners

|-- pom.xml              # Maven Configuration

|-- cucumber.json        # Test Execution Report

|-- README.md            # Project Documentation

## Setup Instructions
1. Prerequisites
   Ensure the following dependencies are installed:
   •    Java 17
   •    Maven (Run mvn -version to verify installation)
   •    Google Chrome & ChromeDriver (Managed automatically by WebDriverManager)

2. Running Tests with Maven
   To execute tests, use the following command:
   mvn clean test
   Alternatively, navigate to the TestRunner class in the utilityHelper folder and run the tests directly from there.

3. Generating Reports (Optional)
   To generate test execution reports, run:
   mvn test -Dcucumber.options="--plugin json:target/cucumber.json"
   mvn test -Dcucumber.options="--plugin html:target/cucumber.html"

## Test Execution Report
•   Test results are saved in cucumber.json or cucumber.html within the target/cucumber-report/ directory.
•   To generate reports, tests must be executed using the TestRunner class.
•   Use the Cucumber Reports Plugin to generate comprehensive HTML reports.

## Troubleshooting
•   Tests not running? Ensure Java and Maven are correctly installed.
•   WebDriver issues? Run mvn clean and restart the tests.
•   Element not found? Increase implicit/explicit waits in Selenium.

This framework ensures efficient, maintainable, and scalable UI testing with Selenium and Cucumber. Happy testing! 

