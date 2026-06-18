import java.util.*;

// =========================================
// STUDENT GRADE CALCULATOR APPLICATION
// Calculates Total Marks, Average Percentage
// and Final Grade of a Student
// =========================================

class Student {

    // Student Details
    private String name;
    private List<Double> marks;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    // Method to Add Subject Marks
    public void addMark(double mark) {

        // Validate Marks
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        marks.add(mark);
    }

    // Calculate Total Marks
    public double getTotalMarks() {

        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        return total;
    }

    // Calculate Average Percentage
    public double getAveragePercentage() {

        if (marks.isEmpty()) {
            return 0;
        }

        return getTotalMarks() / marks.size();
    }

    // Determine Student Grade
    public String getGrade() {

        double average = getAveragePercentage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display Final Student Report
    public void displayReport() {

        System.out.println("\n==========================================");
        System.out.println("         STUDENT GRADE REPORT");
        System.out.println("==========================================");
        System.out.println("Student Name           : " + name);
        System.out.println("Number of Subjects     : " + marks.size());
        System.out.printf("Total Marks Obtained   : %.2f%n", getTotalMarks());
        System.out.printf("Average Percentage     : %.2f%%%n", getAveragePercentage());
        System.out.println("Final Grade            : " + getGrade());
        System.out.println("------------------------------------------");
        System.out.println("Result Generated Successfully.");
        System.out.println("Thank You for Using Grade Calculator!");
        System.out.println("==========================================");
    }
}

public class GradeCalculatorApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      WELCOME TO GRADE CALCULATOR");
        System.out.println("==========================================");
        System.out.println("This application calculates");
        System.out.println("1. Total Marks");
        System.out.println("2. Average Percentage");
        System.out.println("3. Final Grade");
        System.out.println("==========================================\n");

        // Read Student Name
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(name);

        int subjects;

        // Read Number of Subjects
        while (true) {

            System.out.print("Enter Number of Subjects: ");

            if (sc.hasNextInt()) {

                subjects = sc.nextInt();

                if (subjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }

            } else {

                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();
            }
        }

        System.out.println("\n------------------------------------------");
        System.out.println("Enter Marks for Each Subject");
        System.out.println("------------------------------------------");

        // Read Marks
        for (int i = 1; i <= subjects; i++) {
            while (true) {

                System.out.print("Enter Marks for Subject " + i + " (0-100): ");

                if (sc.hasNextDouble()) {

                    double mark = sc.nextDouble();

                    try {

                        student.addMark(mark);


                        break;

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());
                    }

                } else {

                    System.out.println("Invalid input! Please enter numeric marks only.");
                    sc.next();
                }
            }
        }

       

        // Display Report
        student.displayReport();

        sc.close();
    }
}