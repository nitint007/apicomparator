@Compare
Feature: Compare API responses from two files
Description: To compare, if API responses are equal.

Background: To check if provided URLs are valid
Given Provided urls are valid

@CheckValid
Scenario: To check if comparison response is equal
When If response data is equal
Then Should respond result as equal

@CheckInvalid
Scenario: To check if comparison response is NOT equal
When If response data not equal
Then Should respond result as not equal

@CheckURL
Scenario: To check if URL provided is invalid
When If one not URL
Then Should respond Invalid URL