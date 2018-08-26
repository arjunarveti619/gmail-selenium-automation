# Prerequisites:
- ChromeDriver, JDK 8+
- Gradle

This Project sends an email to the same gmail-id with Body and Attachment and verifies the same
The test will do
- Login to Gmail
- Compose an email with unique subject, body, and attachment
- Send the email to the same account which was used to login (from and to addresses would be the same)
- Wait for the email to arrive in the Inbox
- Open the received email
- Verifies the subject, body and attachment name of the received email

# Notes
- Update the test.properties file to replace dummy credentials before you run the tests. Update other properties in test.proerties (chrome driver path , path of the file tobe uploaded etc)

- On any terminal, move to the project's root folder and execute the following command:
    - gradlew clean test
