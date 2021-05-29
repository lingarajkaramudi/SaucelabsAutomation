

## Framework with cucumber tests setup and execution ([cucumber BDD tests here](#cucumber-bdd-tests))

**Package : UITestFramework** : It includes the common classes (and methods) which are required by each test to perform actions. Below are classes in this package:

**CreateSession.java** : All the methods to create a new session and destroy the session after the test(s) execution is over. Each test extends this class. Below are the methods in CreateSession class in their execution order.

1. createDriver(String os, Method methodName) - method creates the driver depending upon the passed parameter (android or iOS) and loads the properties files (config and test data properties files).

2. Tests execution (tests are present in IntegrationTests.tests package)

3. teardown() - method quit the driver after the execution of test(s) 



**GenericMethods.java** : It is a common repository for all the  webdriver and appium methods which are called in each coreLogic classes. Every new method which is being used in coreLogic classes should be added in this class as well. It is to reduce the duplicate code. Each screen class extends this class. Below are few methods defined in this class:

waitForVisibility(By targetElement) - method to wait for an element to be visible
findElement(By locator) - method to find an element
findElements(By locator) - method to find all the elements of specific locator

**Package : app** : It contains the .apk file  on  which tests would be executed. 

**Package : config** - It contains three files config.properties, android_config.properties

**config.properties** : Path to android and iOS config files are defined in this file. Other common required values like DB connection information etc. could be written in this file.


1. android_config.properties - contains the location of the file where test data required by android tests is defined

1. en_US_android.properties - All test data required by android tests is defined in this file.




# Cucumber BDD tests



**Package : cucumberIntegrationTests** :This package has sub-packages: screens and stepDefinitions. It also includes CucumberRunnerUtil class and CreateSessionCucumber class which are required to keep configurations and creating appium instance respectively.


**CreateSessionCucumber.java** : Similar to [Create session class](**CreateSession.java) to create driver object and loading test data etc.

##### How to execute a test

Maven 3.5.0 with Java 1.8 is used as build tool (can be downloaded from [here](https://maven.apache.org/download.cgi)). pom.xml file is present in base directory which has all the required dependencies and code to invoke testng.xml file when executed from command line.

Connect your device to your machine or start the emulator.

Either execute from test runner class or directly from cucumber feature file



