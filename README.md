📘 README – Student Result Management System (Java)
Overview

This is my Java Assignment-3 for the Student Result Management System.
The program collects student details, stores marks for three subjects, validates them, calculates the average, and prints the final result (Pass/Fail).
The main focus of this assignment was to practice exception handling, including custom exceptions, try–catch, throw/throws, and finally.

Features

Add student with roll number, name, and marks

Validates marks between 0 – 100

Custom exception: InvalidMarksException

Shows result for a specific student

Uses arrays to store multiple students

Handles different types of errors

finally block used to display exit/cleanup message

Concepts Used

Custom Exception Class

Checked Exception Handling

try–catch–finally

throw & throws

Arrays

Object-oriented design

How It Works
1. Student Class

Stores roll number, name, and marks

Validates marks

Calculates average

Displays complete result

2. InvalidMarksException

Thrown when marks < 0 or > 100

Shows custom error messages

3. ResultManager

Handles menu

Adds students

Searches student by roll number

Manages exceptions and invalid input

Stores students inside an array

4. Main Class

Simply starts the menu
