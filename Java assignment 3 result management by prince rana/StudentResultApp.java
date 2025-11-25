import java.util.Scanner;

// Custom exception for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String msg) {
        super(msg);
    }
}

// Student class
class Student {

    int rollNumber;
    String studentName;
    int[] marks = new int[3];

    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    // validate marks for all subjects
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i+1) + ": " + marks[i]);
            }
        }
    }

    // calculate average
    public double calculateAverage() {
        int total = 0;
        for (int m : marks) total += m;
        return total / 3.0;
    }

    // display full details
    public void displayResult() {
        System.out.println("\nRoll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        double avg = calculateAverage();
        System.out.println("\nAverage: " + avg);

        if (avg >= 33)
            System.out.println("Result: Pass");
        else
            System.out.println("Result: Fail");
    }
}


// Manager class for handling menu and storage
class ResultManager {

    Student[] students = new Student[100];
    int count = 0;
    Scanner sc = new Scanner(System.in);

    // add a new student with exception handling
    public void addStudent() {

        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i+1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);

            // validate marks
            s.validateMarks();

            students[count++] = s;
            System.out.println("Student added successfully.\n");

        } catch (InvalidMarksException ime) {
            System.out.println("Error: " + ime.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            System.out.println("Returning to main menu...\n");
        }
    }

    // display specific student details
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int rn = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (students[i].rollNumber == rn) {
                    students[i].displayResult();
                    System.out.println("Search completed.\n");
                    return;
                }
            }
            System.out.println("No student found with this roll number.\n");
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        }
    }

    // main menu
    public void mainMenu() {

        int choice = 0;

        while (choice != 3) {
            System.out.println("===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    showStudentDetails();
                    break;

                case 3:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }

        sc.close();
    }
}


// Main class
public class StudentResultApp {
    public static void main(String[] args) {
        ResultManager rm = new ResultManager();
        rm.mainMenu();
    }
}
