# Online Store - Java

This project was written in the Java programming language and it operates as an online store with two types of logins, one for admin, and one for a customer. Depending on which is logged in, a different menu is displayed. All data that gets created, updated, or deleted while the app is running gets saved, including creating new users. 

## Installation

Clone this repository

```bash
git clone https://github.com/Ramo-11/Online_Store.git
```

## Running

You must have make installed in order to run the project

Since the project uses Graphical User Interface (GUI), support for a monitor is required. So running on WSL might cause issues. Powershell, Git Bash, MacOS terminal and other terminals should all be sufficient for running.

Create a jar file
```bash
make jar
```
Run the jar file
```bash
java -jar OnlineStore.jar
```
Alternatively, you could compile and run without using a jar file

To compile and run
```bash
make run
```