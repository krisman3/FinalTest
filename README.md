# FinalTest
This is my final project for the Java Automation course on Skillo.

In this project I decided to create a few tests that revolve around the login page and the registration process.
The login portion consists of a happy path - when everything is entered correctly and we successfully log in as well as 
a negative scenario in which the user just clicks on all of the fields and then presses the sign in button. The appropriate message should pop up.

The registration portion is a bit more interesting.
It has the following tests:

1. When the player enters an already-existing username.
2. When the passwords that the user entered do not match.
3. When the player enters an invalid email address.
3.1. This part actually contains multiple tests inside as there are multiple ways in which the system should warn the user that what he entered is not correct.
5. One of the test will fail on purpose and a screenshot will be saved of the event in /src/test/java/resources/screenshots
