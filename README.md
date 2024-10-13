# Mobile-App-Dev-
Mobile Application Development project of Zoom App
Zoomee App
Zoomee is an Android application like Zoom app that enables users to sign up, log in, and start or join meetings. This app focuses on a smooth user experience with intuitive navigation and easy-to-use features. Users can manage their profiles and initiate meetings from the home screen.

Features
User Authentication: Secure user sign-up and login.
Home Screen: Personalized home screen displaying user profile information after login or signup.
Start a Meeting: Users can start a meeting with a single tap.
Signout: Simple sign-out functionality that redirects users to the login screen.
Screenshots
![image](https://github.com/user-attachments/assets/260d1c24-32cc-492a-ad04-51dc5acb8688)
![image](https://github.com/user-attachments/assets/7fc87e1c-2c7e-4fe3-8516-dfb94c9e421e)


Tech Stack
Kotlin: Used for writing the Android application logic.
Android SDK: Includes core components such as Activities, Views, and Intents.
Gradle: Dependency management and build automation. 
 
Usage
Login or Signup:

Launch the app.
If you don't have an account, tap the Signup button to create a new account.
After successful signup, the app will redirect you to the home screen.
Home Screen:

After login, you’ll be directed to the home screen, where your profile information is displayed.
Use the bottom buttons to either Start a Meeting or Signout.
Start a Meeting:

Tap the Start a Meeting button to initiate a meeting. (Feature implementation in progress)
Signout:

Tap Signout to log out and return to the login screen.
Project Structure
css
Copy code
Zoomee/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/zoomee/
│   │   │   │   ├── LoginActivity.kt
│   │   │   │   ├── SignupActivity.kt
│   │   │   │   ├── HomeActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_login.xml
│   │   │   │   │   ├── activity_signup.xml
│   │   │   │   │   ├── activity_home.xml
│   └── build.gradle
├── README.md
└── build.gradle
Future Improvements
Meeting Functionality: Add real-time meeting capabilities.
User Authentication: Connect to a backend service for secure authentication.
Profile Management: Enable users to edit their profile details from the app.
UI Enhancements: Improve UI/UX for a more engaging user experience.
Contributing
Contributions are welcome! Please follow these steps to contribute to the project:
 
