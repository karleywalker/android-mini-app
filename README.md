# android-mini-app-s17-dewgong
android-mini-app-s17-dewgong created by GitHub Classroom


##Team member list
- Hanna Dickerson [hcd2ha]
- Karley Walker [kbw2as]

##Device Name
Dewgong

##Project/App Title
Bucket List

##Basic instructions on usage
* Open app
* Click checkboxes to mark item as completed
* Tap on Bucket List Item to edit item
  * Press back arrow to cancel add and go back to main page
  * Type in text fields to edit name, description, latitude, and longitude
  * Use date picker widget to edit the date to complete by
  * Click "Save" to add updated item to bucket list
* Tap on "ADD" button to add a new Bucket List Item
  * Press back arrow to cancel add and go back to main page
  * Type in text fields to add name, description, latitude, and longitude
  * Use date picker widget to choose the date to complete by
  * Click "Save" to add new item to bucket list

##Any special info we need to run the app
Look for the cutest pokemon icon

##Lessons learned
Setting up the models and getting them to relate to each other was difficult in the setup for reaching the milestone, but once they were established it became much easier to coordinate components. When working in xml files, the layout can be finicky. However, once we understood how the RecyclerView worked as well as the structures of RelativeLayout, LinearLayout, etc. we were able to get the necessary information in the right places at the right time. Figuring out how to use Intents to go between activities made our code not only work significantly better, but it helped out code to be clean and efficient. Setting up a new view was a trick we didn't fully appreciate until the final day or two of working on the project. Views made it easy to implement the checkboxes, inserting the date, and clicking on the bucket item to see the bucket item information. We spent some time playing with styling. Having experience with HTML/CSS was almost a setback in this project because looking for the "familiar" ways of formatting took time away from productive styling. We spent a great deal of time implementing the add item activity in a way that didn't meet the specifications. We originally just did it by adding it to the list using the AddItem Activity and then reopened the activity instead of returning to the old, already opened page and editing that. We fixed this by starting the activity for a result and then using that result to append the main activity with the new item. We had to go to a TA for help with this as it was also influencing how the pages were refreshed, which meant our "checked" items were un-checked after you added a new item. The only error we couldn't figure out was more of a stylistic one; for some reason the first time you check an item, the checkbox is not disabled. The checkbox disabling feature works for all subsequent clicks, and the item does sort to the end of the list, the disabled check just doesn't appear.

