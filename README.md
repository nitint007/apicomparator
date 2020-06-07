# apicomparator

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

This is a Assignment project.

# Framework consists REST API libs, Cucumber for BDD purpose, Maven as build tool

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Steps to clone execute the tests:
git clone https://github.com/nitint007/apicomparator

cd apicomparator

mvn clean test

# If fails to execute from cmd line -

Go to '/apicomparator/src/test/java/runner/TestRunner.java'
Run as 'JUnit Test'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# For reporting:

Go to '/apicomparator/target/cucumber-reports' and open 'index.html'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Execution for DKatalis lab:

/apicomparator/bin/parking_lot.bat is created

# If fails to execute from cmd line -

Go to '/apicomparator/src/test/java/runner/TestRunner.java'
Run as 'JUnit Test'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Test data files:

Two type of file are provided:
1. For basic validation of library - 'file1' and 'file2'
2. To check 1000+ request - 'longfile1' and 'longfile2'

File contains 1000 request are also verified.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Assumption:

If we provide intended files for scenarios - each passes.
Currently provided files with combination of URLS considering the problem statement to provide a two files only.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-