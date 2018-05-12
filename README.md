# IneedIT
<p align="center">
    <img src="https://github.com/pppttl/IneedIT/blob/master/Screenshots/1-login.png?raw=true" alt="Login screen" height="400" width="216"/>
    <img src="https://github.com/pppttl/IneedIT/blob/master/Screenshots/2-requests.png?raw=true" alt="Requests screen" height="400" width="216"/>
    <img src="https://github.com/pppttl/IneedIT/blob/master/Screenshots/3-requestdetails.png?raw=true" alt="Request details screen" height="400" width="216"/>
    <img src="https://github.com/pppttl/IneedIT/blob/master/Screenshots/4-notification.png?raw=true" alt="Notification sent by the application" height="400" width="216"/>
</p>

## Introduction
IneedIT is an Android application for small companies to manage their
device requests coming from their employees.

This application was made by Attila Papp during the spring of 2018
as a university project.

## Main functions
The users have the ability to send in device requests, list them
or chat with administrators about the details.
The administrators can either accept or deny the pending requests.
When the status changes, the user receives a notification on their device.

These notifications arrive even when the application is closed, thanks
to some basic server-side code hosted using Firebase Functions.

The users have profiles where they can share data about their contact
information.

## Technologies
* ***MVP pattern***: This allows the bussiness logic to be separated
from the view and the database implementation, making it easier to change
the database implementation (e.g. use a REST API instead of Firebase)
and also increases testability. (The bussiness logic is 100% tested.)
* ***Firebase Auth***: User authentication is provided by Firebase.
* ***Firebase Realtime Database***: When the data changes the users can
see the updated values right away.
* ***Firebase Functions***: A small JavaScript application is running
on the server monitoring the requests in the database. If that status of
the requesst changes, it sends a notification to the user's device(s).
* ***Firebase Messaging***: Notifications are sent through this.
* ***Depdendency injection using Dagger2***: This helps making it easy to
follow the Single Responsibility Principle by making the code loosely
coupled, while increasing testability.
* ***GitFlow***: This was the first project where I could practice this
principle. You can see the closed pull requests, or check out my progress
using the tags. You can also download releases by week, to see how the
application evolved.
* ***Justinmind Prototyper***: My first task was to design the application,
and I used this tool.
* ***Butterknife***: No more findViewById. :)
* ***Project Lombok***: Never write getter/setter methods again.
* ***Mockito***: Easily mock-out complicated objects in unit tests.
* ***Notification channels***: The application uses Android 8's new feature,
to separate the notification of status changes and new comments.