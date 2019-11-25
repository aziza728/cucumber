Feature: Login
Scenario Outline: User login using the registered user name and password
Given User has registered and is in Login page
When User enter the "<userName>" and "<password>"
And click on login
Then User must be logged in successfully
Examples:
|userName||password|
|apendreresrt||accenture123|



