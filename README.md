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
The first page of the app uses an API call from newsapi.org, a website that delivers top headlines from news outlets (New York Times, The Washington Post, etc.). The view is acheived using a combination of nested "Linear", "Relative" and "Scroll" view layouts contructed in XML. The text extracted from the JSON is fed to TextViews placed inside two "Scroll" views that each take one half of the available screen space.

![page1](https://user-images.githubusercontent.com/36170390/40931624-4ccc010c-67f1-11e8-8a93-a29f869117db.png)

This was acheived by having the entry point of the page run an API fetch method from a child class that extends from "AsyncTask," a helper class that alows for background operations. As soon as the "onCreate" method is initiated(the entry point of the page) the API call is executed and later loaded after all the page elements have been rendered. With page elements(TextView, EditText, ProgressBar) publicly defined in the parent class, the child methods are able to successfully update the Android page with the information. The API "fetch" code is pictured below.

![apicall](https://user-images.githubusercontent.com/36170390/40933596-91c6aea0-67f7-11e8-8e21-c41708583416.png)

Data captured by the fetch function is fed into the last AsyncTask method(In-terms of execution order), appropiately named onPostExecute(). Here a new JSON object is created to be called on whenever a TextView element needs to be updated with information stored from the newly created object. A sample of this functionality is pictured below.

![jsonobj](https://user-images.githubusercontent.com/36170390/40937746-3969214e-6805-11e8-8650-e1348732a593.png)

## Page 2: "Reminders"

The second portion of the app serves as a notetaker with recallable data even after the app has been closed. Use of the Android native database through SQlite makes data recall possible.

![page2](https://user-images.githubusercontent.com/36170390/40938130-8472e3c2-6806-11e8-8d99-94056ce5a95f.png)

There are three main java files that define the functionality of the page:

### Database handler: DatabaseHelper class

![datahelper](https://user-images.githubusercontent.com/36170390/40951072-159edb60-683b-11e8-97ef-432ea899d028.png)

The DatabaseHelper class is an extention of SQLiteOpenHelper, a class that aleviates the creation of databases and version management. SQLiteDatabase is another class that is also invoked to handle normal database operations(CREATE, READ, UPDATE, DELETE). The overrided methods "onCreate" and "onUpgrade" take data from the Notes class, one of the 4 governing parent classes. The onCreate() creates a table, while the onUpgrade() updates the table. 


Database methods that handle inserting and recalling notes:


![datamethods](https://user-images.githubusercontent.com/36170390/40951010-d663e9c2-683a-11e8-87ff-dee4ed570f48.png)

Extensive use of the SQLiteDatabses class is present in these methods. For every seperate action taken to modify the database, a seperate instance must be made. To insert data, a "writable" database instance is stored inside a SQLiteDatabase object that is accessed to input data from the Notes class. For data retrieval, a readable instance is created in similar fashion but an additional object using the "Cursor" class is required. Th curser allows for the viewing of specific instances when provided with relevant information that matches row data.

### Database Schema: Notes class

![notesclass](https://user-images.githubusercontent.com/36170390/40991442-6ae31310-68b9-11e8-9eb7-27db145babc2.png)

The Notes class provides the structure of the database used by the databaseHelper, along with methods that store the data extracted from the database. Data stored from extraction is utilized to populate the android page upon rendering when called upon from the entry point class "Page2."

### Entry Point: Page2 Class

![page2class2](https://user-images.githubusercontent.com/36170390/40993126-5703f77e-68be-11e8-8463-fc7ce5370751.png)

The Page2 class employs the use of "RecyclerView" and "List" classes to programatically render a list on the app page. This class is also responsible for defining multiple event listeners and method pairs for the various touch and button controls available when using the UI. 



