@Compare
Feature: Compare API responses from two files
Description: To compare, if API responses are equal.

Background: 
Given Provided two files with list of APIs

Scenario:
When If response data is equals
Then Should respond result as equal

Scenario:
When If response data is equals
Then Should respond result as not equal

Scenario:
When If one not URL
Then Should respond Invalid URL