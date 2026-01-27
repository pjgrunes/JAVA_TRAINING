package M5.act.db.act3;
import M5.act.db.act3.StudentDAO;
import M5.act.db.act3.CourseDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final StudentDAO students = new StudentDAO();
    private static final CourseDAO courses = new CourseDAO();

    public static void main(String[] args) {
        System.out.println("===== STUDENT COURSE MANAGEMENT =====");
        while (true) {
            System.out.println(
                   " 1. Add Student 2. Add Course 3. Show Students 4. Show Courses 0. Exit" );
            int opt = readInt("Choose an option: ");

            try {
                switch (opt) {
                    case 1: addStudent();
                    break;
                    
                    case 2: addCourse();
                    break;
                    
                    case 3: showStudents();
                    break;
                    
                    case 4: showCourses();
                    break;
                    
                    case 0: System.out.println("Exiting application. Goodbye!");
                    break; 
                    
                    default: System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void addStudent() throws Exception {
        System.out.print("Enter name: ");
        String name = in.nextLine().trim();
        int age = readInt("Enter age: ");
        System.out.print("Enter email: ");
        String email = in.nextLine().trim();

        int id = students.add(name, age, email);
        System.out.println("Student added successfully! ID: " + id);
    }

    private static void addCourse() throws Exception {
        int studentId = readInt("Enter student ID: ");
        System.out.print("Enter course name: ");
        String courseName = in.nextLine().trim();
        int grade = readInt("Enter grade: ");
        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }
        int id = courses.add(studentId, courseName, grade);
        System.out.println("Course added successfully! ID: " + id);
    }

    private static void showStudents() throws Exception {
        List<String> rows = students.list();
        System.out.println("\nID | Name | Age | Email");
        System.out.println("------------------------");
        rows.forEach(System.out::println);
    }

    private static void showCourses() throws Exception {
        List<String> rows = courses.listJoined();
        System.out.println("\nID | Course Name | Grade | Student Name");
        System.out.println("---------------------------------------");
        rows.forEach(System.out::println);
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}

