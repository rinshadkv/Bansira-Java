# Library Management System

## Project Setup

### Prerequisites

- Java JDK 21

## Compiling the Project

### Main Classes

1. Navigate to the `project-root` directory.
2. Compile the main classes:
   ```sh
   javac -d out main/*.java 
   ```
3. Compile the tests
   ```sh
   javac -d out -cp .;lib/junit-platform-console-standalone-1.11.0-M2.jar test/LibraryTest.java
   ```

## Running the Application

### Running the Main Application

1. Navigate to the root directory.
2. Run the main application:

```

java -cp out main.LibraryMenu
```

### Running the Tests

1. Navigate to the root directory
2. Run the tests using JUnit 5

```
java -cp out;lib/junit-platform-console-standalone-1.11.0-M2.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
```

Alternatively you can use the IDE specified settings for run and test the application

   