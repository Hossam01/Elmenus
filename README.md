## Elmenus Task 

Displaying list of sticky pegged tags, and items list with detailed screen 


# Techicality 

The project uses Clean architecture as structure pattern consisting of the layers : 
*  Data layer contains data source logic-networking via Retrofit-, Data Transfer Objects, and repositories implementation 
*  Domina layer contains mainly project Bussiness rules, and consist of Domain Named Objects, Repositories, Mappers, and application use cases 
*  Presentation layer contains UI related and dependent Apis, it contains The, Components, Navigation, ViewModels, UI State, UI Intent, and framework Apis-Activities..etc


![arc](https://user-images.githubusercontent.com/74387512/141706451-771f50c2-9e87-424b-9f16-c757c4fff30d.PNG)


# Dependencies 


* Retorift : type-safe REST client for Android and Java which aims to make it easier to consume RESTful web services
* Pagging 3 : helps load and display pages of data from a larger dataset from local storage or over network.
* Corotines : a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
* Hilt : a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection
* Glide : an image loading library for Android backed by Kotlin Coroutines
* Navigation : Android’s components archtotucre to the interactions that allow users to navigate across, into, and back out from the different pieces of content within app 
* ConstraintLayout :  help place composables relative to others on the screen, and is an alternative to using multiple nested

 
