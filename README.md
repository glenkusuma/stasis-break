# Stasis Break

## Overview

A text-based adventure game. this project is developed as part of the Tugas Individu 1 Project for the OOP course (BBK1JAB3 - 2025) at SiTelu Studios.
this game is designed to test understanding of Object-Oriented Programming (OOP) concepts, debugging skills, and clean coding practices. In this game, players are assume role of a character navigate through multiple scenes. Each scene, players will presented with a description and several choices that affect their character's health and XP.

## Technologies and Tools

- **Java:** ^23.0.0  
- **Maven:** ^3.0.0  
- **JUnit:** ^5.0.0  
- **IDE:** Visual Studio Code  
  - **Extension:** Extension Pack for Java  
    - Identifier: `vscjava.vscode-java-pack`  
    - Version: 0.29.0  
- **Version Control:** Git

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/glenkusuma/stasis-break
cd stasis-break
```

### 2. Verify Java Installation
Ensure that Java (version ^23.0.0) is installed:
```bash
java -version
```

example output
```txt
openjdk version "24.0.1" 2025-03-18
OpenJDK Runtime Environment (build 24.0.1)
OpenJDK 64-Bit Server VM (build 24.0.1, mixed mode, sharing)
```


### 3. Verify Maven Installation
Make sure Maven (version ^3.0.0) is installed:
```bash
mvn --version
```

example output
```txt
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /usr/share/java/maven
Java version: 24.0.1, vendor: Arch Linux, runtime: /usr/lib/jvm/java-24-openjdk
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.13.8-arch1-1", arch: "amd64", family: "unix"
```

### 4. Open the Project in VS Code
- Open the project folder in VS Code.
- Install the **Extension Pack for Java** if not already installed.

## Building the Project

To compile and package the project, run:
```bash
mvn clean install
```

## Running the Application

After building the project, run the application using Maven:
```bash
mvn exec:java -Dexec.mainClass="com.sitelu.studios.stasisbreak.Main"
```
Alternatively, you can run the `Main.java` class directly from VS Code.

## Running Tests

Unit tests are implemented using JUnit ^5.0.0. To run the tests, execute:
```bash
mvn test
```

## References

- **Java Documentation:** [Oracle Java Docs](https://docs.oracle.com/en/java/)
- **Maven Documentation:** [Maven Apache](https://maven.apache.org/)
- **JUnit Documentation:** [JUnit 5](https://junit.org/junit5/)
- **VS Code Java Extension:** [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
