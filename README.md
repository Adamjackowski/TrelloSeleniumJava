Automated tests
========================

## Instructions for starting automated tests 

### 1 - General requirements:

1. The driver for the given browser(Firefox/Geckodriver, Chrome, Edge) must be added to the PATH environment path.
2. Java must be added to the PATH environment path.
3. Selenium must be installed.
4. The testData.json file must be added to the project -> See "Storing login details".

### 2 - For the VS Code program:

1. Download the "Java" extension. Open the project folder.
2. To run a given test, in the explorer (upper left corner) discover the tests, select the test file of interest, press PPM and select the option to run tests from a given file.
3. To run each method you can open a test file and choose run/debug button above each test method.

### 3 - Test scructure

1. Tests are written in "Page Object Pattern" - please get familiar with it before starting to implement new ones.
2. Each test is in each file and each file contain each test methods. 
3. Some setUp and a little bit of test data is put into a before/after suite and test methods.

##  Storage of login details 

### 1 - The config.json file

1. Config file json should be in the root project folder\artifact\src\test\java\testPackage.
2. The config.json file should contain the following fields (values must be completed with valid data).

```
{
  "Login" : "",
  "Password" : ""
}

```