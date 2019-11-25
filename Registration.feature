Feature:  Registration for TestMeapp
Scenario: User Register in testmeapp
Given User is in the sign up page
And user enters the user name "apendreresrt" 
And user enters the first name "santhi"
And user enters the last name "moses"
And user enters password and confirm password "accenture123" && "accenture123"
And user selects the gender
And user enters the contact email and mobile number "accenture@gmail.com" && "9115621775"
And user enters the dob "04/25/2004"
And user enters the address "accenture chennai"
And user selects the security question and enters the answer "green"
When User click on the signUp button
Then User navigated to login page



