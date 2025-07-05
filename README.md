# REST-API-CLIENT

COMPANY : CODTECH IT SOLUTIONS

NAME : SHESHANK

INTERN ID : CT04DG800

DOMAIN : JAVA PROGRAMMING

DURATION : 4 WEEKS

MENTOR : NEELA SANTOSH

** REST-API-CLIENT DESCRIPTION**
Creating a Java application that consumes a public REST API, such as one that fetches weather data, involves several key steps and concepts in software development. This task not only requires knowledge of Java programming but also an understanding of how to interact with web services, handle HTTP requests, and parse JSON responses. Below is a detailed description of the task, its components, and the overall process involved in developing such an application.

Overview of the Task
The primary goal of this task is to develop a Java application that can retrieve weather data from a public API, such as OpenWeatherMap, and display that data in a structured format. This involves making HTTP requests to the API, receiving JSON responses, and then parsing that JSON to extract relevant information, which is then presented to the user in a readable format.

Key Components
Understanding REST APIs: REST (Representational State Transfer) APIs are a set of rules that allow different software applications to communicate over the web. They use standard HTTP methods (GET, POST, PUT, DELETE) to perform operations. In this case, we will use the GET method to retrieve weather data.

HTTP Client: Java provides several libraries for making HTTP requests. The HttpClient class, introduced in Java 11, is a modern and efficient way to handle HTTP requests. It allows developers to send requests and receive responses asynchronously, making it suitable for applications that require real-time data fetching.

JSON Parsing: The data returned from the API is typically in JSON (JavaScript Object Notation) format, which is lightweight and easy to read. To parse JSON in Java, libraries such as org.json or Gson can be used. These libraries provide methods to convert JSON strings into Java objects, making it easier to access the data.

User Input: The application should allow users to input the name of a city for which they want to fetch weather data. This can be done using the Scanner class to read input from the console.

Data Display: Once the data is fetched and parsed, it should be displayed in a structured format. This could include information such as temperature, humidity, wind speed, and weather conditions. Formatting the output in a clear and organized manner enhances user experience.

Implementation Steps
Set Up the Project: Create a new Java project and include necessary dependencies for HTTP requests and JSON parsing. If using Maven, add the required libraries in the pom.xml file.

Create the Main Class: Develop a main class that will handle user input, make HTTP requests, and display the results. This class will contain methods for fetching weather data and parsing the JSON response.

Fetch Weather Data: Implement a method that constructs the API request URL using the user-provided city name and the API key. Use the HttpClient to send the request and receive the response.

Parse JSON Response: Once the response is received, use a JSON library to parse the data. Extract relevant fields such as temperature, humidity, and weather conditions.

Display Results: Format the extracted data and print it to the console in a user-friendly manner. This could involve using formatted strings to align the output neatly.

Error Handling: Implement error handling to manage potential issues such as invalid city names, network errors, or API response errors. This ensures that the application can handle unexpected situations gracefully.

Conclusion
Developing a Java application that consumes a public REST API for weather data is an excellent way to practice and demonstrate skills in web services, HTTP communication, and data parsing. This task not only enhances programming proficiency but also provides insights into how modern applications interact with external data sources. By following the outlined steps, developers can create a robust application that effectively retrieves and displays weather information, thereby fulfilling the requirements of the task. This project serves as a foundational exercise for understanding more complex integrations and data handling in software development.

**OUTPUT**
[Task-2.txt](https://github.com/user-attachments/files/21077009/Task-2.txt)
