# SOFTWARE ENGINEER TAKE HOME TEST - BACKEND

## Description
The task at hand is to create a Command Line Interface (CLI) program using Java, a language that is well-regarded for Object Oriented Programming. What's particularly exiciting is the application of design patterns such as Singleton pattern which can help unsure that a single instance (in this case CommandManager) of a class is created, and the Strategy pattern which allows me to implement different commands as strategies, each adhearing to a common interface but with unique inner implementations.

## Assumptions
* Taken from the ReadMe before
* Given a ‘name’ and a ‘relationship’, you should output the people corresponding to the relationship
in the order in which they are added to the family tree
* You should be able to add a child to any family in the tree through the mother
* Input needs to be read from a text file. and output should be printed to console. **Your program
should take the location to the test file as a parameter**.

## Depedencies
* [Java Development Kit (JDK) v19.0.2](https://www.oracle.com/id/java/technologies/downloads/) for compiling java files
* [Apache Maven v3.8.7](https://maven.apache.org/) for build and test automation for development process
* [JUnit 4 (Included in Apache Maven Dependency)](https://github.com/junit-team/junit4/wiki/Download-and-Install) for unit testing and logical testing

## How to Test the Program
1. Make sure you have Apache Maven v3.8.7 installed
2. Change your directory to 'challenge' directory
  ```sh
  cd challenge
  ```
2. Run test script via Maven
  ```sh
  mvn test
  ```
3. Look at the error logs if there is any
4. Look at the surefire reports for more information about the unit test
```sh
cd target/surefire-reports
```
5. Console / Terminal Line should look like this <br>
![Test Folder](/assets/Screenshot_8.png)

## How to Run the Program
1. Make sure you are in the 'challenge' directory
2. Build the project via Maven
  ```sh
  mvn clean package
  ```
3. Look at the 'target' folder and make sure the build is successful, there should be 'challenge-1.0.jar' file.
4. Target folder should look like this <br>
![Target Folder](/assets/Screenshot_7.png)
5. I have prepared some script to build and run, but if you want to do it manually you can run the program this way
```sh
java -cp target/challenge-1.0.jar com.Nicholas.Main <file_name.txt>
```
6. [Alternatives] (Without file name as argument, you can still input them in console)
```sh
java -cp target/challenge-1.0.jar com.Nicholas.Main
```
7. [Example] Usage
```sh
java -cp target/challenge-1.0.jar com.Nicholas.Main files/test_1.txt
```
8. Successful usage of the program <br>
![Success Image](/assets/Screenshot_9.png)