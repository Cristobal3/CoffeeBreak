# CoffeeBreak

Android app using Java & Android Studio

### Purpose: 
A down-time app designed to quickly inform the user of the top US news headlines and serve as a notetaker for reminders.

## Entry Point
![coffeebreak1](https://user-images.githubusercontent.com/36170390/40801165-dd326316-64d7-11e8-80e7-9420e421c246.png)

Standard image procedure was used for the background image as seen below. 

![imagedens](https://user-images.githubusercontent.com/36170390/40857492-f2e0efd8-65a0-11e8-956a-b3782962a556.png)

Image scaling was done using GIMP. Logo and buttons arranged through the use of the "relative" view in XML.

## Page 1: "Latest News"
The first page of the app uses an API call from newsapi.org, a website that delivers news headlines from news outlets (New York Times, The Washington Post, etc.). The view is acheived using a combination of nested "Linear", "Relative" and "Scroll" view layouts contructed in XML. The text extracted from the JSON is fed to TextViews placed inside two "Scroll" views that eacxh take one half of the availbale screen space.

![page1](https://user-images.githubusercontent.com/36170390/40931624-4ccc010c-67f1-11e8-8a93-a29f869117db.png)

This was acheived by having the entry point of the page run an API fetch method from a child class that extends from "AsyncTask," a helper class that alows for background operations. As soon as the "onCreate" method is initiated(the entry point of the page) the API call is executed and later loaded after all the page elements have been rendered. With page elements(TextView, EditText, ProgressBar) publicly defined in the parent class, the child methods are able to successfully update the Android page with the information. The API "fetch" code is pictured below.

![apicall](https://user-images.githubusercontent.com/36170390/40933596-91c6aea0-67f7-11e8-8e21-c41708583416.png)

Data captured by the fetch function is fed into the last AsyncTask method(In-terms of excution order), appropiately named onPostExecute(). Here a new JSON object is created to be called on whenever a textView element needs to be updated with information stored from the newly created onject. A sample of this functionality is pictured below.

![jsonobj](https://user-images.githubusercontent.com/36170390/40937746-3969214e-6805-11e8-8650-e1348732a593.png)

## Page 2: "Reminders"

The second portion of the app serves as a notetaker with recallable data even after the app has been closed. Use of the Android native database through SQlite makes data recall possible.

![page2](https://user-images.githubusercontent.com/36170390/40938130-8472e3c2-6806-11e8-8d99-94056ce5a95f.png)

This page of the application utilizes 4 java classes. Each class is in charge of a critical factor in rendering the page. 

### Database handler: DatabaseHelper class

![datahelper](https://user-images.githubusercontent.com/36170390/40951072-159edb60-683b-11e8-97ef-432ea899d028.png)


Databse methods that handle insering and recalling notes:


![datamethods](https://user-images.githubusercontent.com/36170390/40951010-d663e9c2-683a-11e8-87ff-dee4ed570f48.png)

