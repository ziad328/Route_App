package com.example.route

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.route.CoursesAdapter
import com.example.route.Course
import com.example.route.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var coursesAdapter: CoursesAdapter
    private val courses = mutableListOf<Course>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar()

        initRecyclerView()
        coursesAdapter.onCourseClick = {
            val intent = Intent(this, CourseDetailsActivity::class.java)
            intent.putExtra(Constants.COURSE, it)
            startActivity(intent)
        }



    }
    private fun setActionBar() {
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(resources.getColor(R.color.colorPrimaryDark))

        )
        val text = SpannableString(supportActionBar?.title)
        text.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.white)),
            0,
            text.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        supportActionBar?.title = text
    }


    private fun createCoursesList() {
        courses.add(
            Course(
                name = Constants.ANDROID_COURSE, image = R.drawable.android,
                content = "Part 1 ( Java SE)\n" +
                        "1. Introduction to Java Programming\n" +
                        "• Overview.\n" +
                        "• Compiler and JVM\n" +
                        "• Project Structure\n" +
                        "• Hello World Application\n" +
                        "• Variables and Data types\n" +
                        "• Operators\n" +
                        "• Conditional statements ( IF - Switch)\n" +
                        "• Loops ( For - While - Do While)\n" +
                        "2. Basics\n" +
                        "• nested loops\n" +
                        "• Strings\n" +
                        "• Arrays\n" +
                        "• functions\n" +
                        "3. Object Oriented Programming\n" +
                        "• Classes and Objects\n" +
                        "• Encapsulation and data hiding\n" +
                        "• Inheritance\n" +
                        "• Polymorphism\n" +
                        "• Abstraction (Abstract classes - Interfaces)\n" +
                        "4. Collections and Generics\n" +
                        "• Sets, Lists\n" +
                        "• Threading\n" +
                        "• Generics Class and MethodPart 2 (Android Development)\n" +
                        "1. Introduction to Android\n" +
                        "• Android OS\n" +
                        "• Android Versions\n" +
                        "• OS Architecture\n" +
                        "• Application Component\n" +
                        "• Android Studio and Gradle\n" +
                        "• Creating Hello World\n" +
                        "2. UI Components\n" +
                        "• Layouts(Constraints Layout- Linear Layout )\n" +
                        "• Using resources ( drawables, Strings colors, and Styles )\n" +
                        "3. UI Components II\n" +
                        "• Menu\n" +
                        "• Support Localization\n" +
                        "• Support Orientation\n" +
                        "4. Intents and Activities\n" +
                        "• Intents\n" +
                        "• Intent Filters\n" +
                        "5. Fragments\n" +
                        "• what is fragments\n" +
                        "• Fragment manager and transaction\n" +
                        "• tablayout, NavigationDrawer, BottomNavigation\n" +
                        "6. Dialogs• Alert Dialog\n" +
                        "• Display dialog with items\n" +
                        "• Custom dialogs (Dialog Fragment)\n" +
                        "7. Data Storage\n" +
                        "• Shared Preference\n" +
                        "• Room (Database Library) - from google Arch Components\n" +
                        "8. Threading and Services\n" +
                        "• Threading\n" +
                        "• Service and Intent Service\n" +
                        "9. Web services and APIs\n" +
                        "• what is JSON ?\n" +
                        "• how to make network calls and APIs\n" +
                        "• Consuming Web APIs\n" +
                        "• Using Retrofit and Gson Libraries\n" +
                        "• how to cache Apis\n" +
                        "• using Room and Retrofit Together\n" +
                        "• what is Repository Pattern?\n" +
                        "10. FireBase RealTime Database\n" +
                        "• how to deal with Realtime Database\n" +
                        "11. Notifications\n" +
                        "• Simple Notification\n" +
                        "• firebase to push Notifications\n" +
                        "• one signal push notifications SDK\n"
            )
        )

        courses.add(
            Course(
                name = Constants.IOS_COURSE, image = R.drawable.ios, content = "OOP refreshment\n" +
                        "• Introduction\n" +
                        "a. Installing OS X virtual machine\n" +
                        "b. Installing Xcode and the iOS SDK\n" +
                        "c. A guided tour of Xcode\n" +
                        "d. An Introduction to Xcode playgrounds\n" +
                        "• Swift Programming Language\n" +
                        "a. Swift Data Types, Constants, and Variables\n" +
                        "b. Swift Operators and Expressions\n" +
                        "c. Swift Flow Control\n" +
                        "d. The Swift Switch Statement\n" +
                        "e. An Overview of Swift Functions\n" +
                        "f. The Basics of Object Oriented Programming in Swift\n" +
                        "g. An Introduction to Swift Subclassing and Extensions\n" +
                        "h. Working with Array and Dictionary Collections in Swift\n" +
                        "i. Understanding Error Handling in Swift\n" +
                        "• Views, Layouts, and Storyboards.\n" +
                        "a. Learning different types of Xcode projects\n" +
                        "b. Creating first application\n" +
                        "c. Introduction to application file structure.\n" +
                        "d. Using Storyboards in Xcode\n" +
                        "e. Introduction to basic UI Components.\n" +
                        "f. Creating basic UI Components using Storyboard\n" +
                        "g. Creating basic UI Components programmatically\n" +
                        "h. Customizing UI Components.\n" +
                        "i. An Introduction to Auto Layout in iOS\n" +
                        "j. Working with iOS Auto Layout Constraints in Interface Builder\n" +
                        "k. Creating Navigation controller and learning its flow\n" +
                        "l. Creating tab-based application\n" +
                        "m. Adding custom fonts\n" +
                        "n. Creating table view \n" +
                        "o. Example about gestures\n" +
                        "p. Creating custom cells for tables\n" +
                        "q. Animations  \n" +
                        "r. Examples about subclass\n" +
                        "• Working with local data\n" +
                        "a. Working with UserDefaults\n" +
                        "b. Introduction to CoreData\n" +
                        "c. Introduction to Realm\n" +
                        "d. Creating data models\n" +
                        "e. Saving retrieving data\n" +
                        "• ToDo app project\n" +
                        "a. Implement the interface\n" +
                        "b. Create realm models\n" +
                        "c. restore ToDo lists\n" +
                        "• CocoaPods\n" +
                        "a. Introduction to Cocoapods\n" +
                        "b. Installing sample pods\n" +
                        "c. Learning how to use pods in project\n" +
                        "d. How to look for a useful pod\n" +
                        "e. Example using Realm database thirdparty\n" +
                        "• Networking\n" +
                        "a. Working with Alamofire pod\n" +
                        "b. Installing and configuring Alamofire\n" +
                        "c. Learning how to send GET \n" +
                        "d. Learning how to parse JSON responses using ObjectMapper pod\n" +
                        "e. Creating sample login screen with POST \n" +
                        "f. Creating sample table view displays data from JSON object\n" +
                        "• Dynamic animator\n" +
                        "a. Deal with physics engine\n" +
                        "b. Apply Gravity field to dynamic objects\n" +
                        "c. Apply collision field to dynamic objects\n" +
                        "d. Apply other physics fields to dynamic objects\n" +
                        "• Working with Maps\n" +
                        "a. Introduction to maps\n" +
                        "b. Showing current user location\n" +
                        "c. Adding pins\n" +
                        "• Apply some design patterns\n" +
                        "a. Creational: Singleton.\n" +
                        "b. Structural: MVC, Decorator, Adapter, Facade.\n" +
                        "c. Behavioral: Observer\n" +
                        "• Creating final project depends on attendees needs"
            )
        )

        courses.add(
            Course(
                name = Constants.FULL_STACK_COURSE,
                image = R.drawable.fullstack,
                content = "•HTML\t\n" +
                        "•HTML 5 \n" +
                        "•CSS\n" +
                        "•CSS3\n" +
                        "•SASS\n" +
                        "•Bootstrap 4\n" +
                        "•JavaScript\n" +
                        "•Regular expressions\n" +
                        "•ECMAScript 6\n" +
                        "•JQuery\n" +
                        "•angular 7\n" +
                        "•fabric.js\n" +
                        "•AJAX\n" +
                        "•JSON\n" +
                        "•Hosting and domains\n" +
                        "•Freelancing tips and tricks\n" +
                        "•PHP\n" +
                        "•MYSQL\n" +
                        "•MYSQL advanced queries and triggers\n" +
                        "•OOP \n" +
                        "•Design Patterns\n" +
                        "•MVC\n" +
                        "•laravel \n" +
                        "•build Api , Api authentication\n" +
                        "•connect wordpress with laravel\n" +
                        "•build wordpress web service \n" +
                        "•agile\n" +
                        "•Scrum\n" +
                        "•Software development process\n"
            )
        )
    }

    private fun initRecyclerView() {
        createCoursesList()
        coursesAdapter = CoursesAdapter(courses)
        binding.rvCourses.apply {
            adapter = coursesAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

    }


}