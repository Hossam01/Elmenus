## Elmenus Task 

Displaying list of sticky pegged tags, and items list with detailed screen with dark and light mode 

# Screenshots 


<img src="https://user-images.githubusercontent.com/74387512/141703770-c4a7bd9d-b99b-4f1a-9d99-c5b199a26101.png" width="300">
<img src="https://user-images.githubusercontent.com/74387512/141703767-f7f3c63d-d024-4fa5-9223-73eed82710d5.png" width="300">

<img src="https://user-images.githubusercontent.com/74387512/141704035-2aecf229-67f0-4e68-8ad9-28be8eb2fccd.png" width="300">
<img src="https://user-images.githubusercontent.com/74387512/141704038-0fd03182-a881-47a2-b9bf-d84d650f8b83.png" width="300">

<img src="https://user-images.githubusercontent.com/74387512/141703777-282c391c-85e3-416e-b85d-3b9b7e5d6556.png" width="300">
<img src="https://user-images.githubusercontent.com/74387512/141703772-7fbeea6d-89f8-4948-a6d7-8dfe275ee1b1.png" width="300">
<img src="https://user-images.githubusercontent.com/74387512/141703780-243c45a4-6c7c-40d7-8a52-813d52aec4e7.png" width="300">


# Techicality 

The project uses Clean architecture as structure pattern consisting of the layers : 
*  Data layer contains data source logic-networking via Retrofit-, Data Transfer Objects, and repositories implementation 
*  Domina layer contains mainly project Bussiness rules, and consist of Domain Named Objects, Repositories, Mappers, and application use cases 
*  Presentation layer contains UI related and dependent Apis, it contains The, Components, Navigation, ViewModels, UI State, UI Intent, and framework Apis-Activities..etc

* Classes are behaving through MVI pattern, with Repository, Singleton, Factory design pattern

![arc](https://user-images.githubusercontent.com/74387512/141706451-771f50c2-9e87-424b-9f16-c757c4fff30d.PNG)


# Dependencies 


* Retorift : type-safe REST client for Android and Java which aims to make it easier to consume RESTful web services
* Pagging 3 : helps load and display pages of data from a larger dataset from local storage or over network.
* Corotines : a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
* Hilt : a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection
* Jetpack Compose : Android’s modern toolkit for building native UI. It simplifies and accelerates UI 
* Coil : an image loading library for Android backed by Kotlin Coroutines
* Navigation : Android’s components archtotucre to the interactions that allow users to navigate across, into, and back out from the different pieces of content within app 
* StateFlow : a state-holder observable flow that emits the current and new state updates to its collectors.
* ConstraintLayout :  help place composables relative to others on the screen, and is an alternative to using multiple nested

# Talk 
Parallax effect is done using custom Jetpack compose layouts by minabulation the transaction and alpha of composable using Column Scroll state. But currently shared element transation is not supported by Jetpack Compose yet. and that my next up coming challenge 😊

 
