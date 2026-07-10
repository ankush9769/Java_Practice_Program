package Day6;

import java.util.Scanner;

public class Student {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Maximum Number Of Students: ");
        int maxStudents = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[maxStudents];
        int[][] marks = new int[maxStudents][3];
        int studentCount = 0;
        int choice;
        do {
            System.out.println("\n===== STUDENT MARKS APPLICATION =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:

                    if (studentCount == maxStudents) {
                        System.out.println("Student list is full.");
                        break;
                    }

                    System.out.print("How many students do you want to add? ");
                    int numberToAdd = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numberToAdd && studentCount < maxStudents; i++) {

                        System.out.println("\nEnter details for Student " + (studentCount + 1));

                        System.out.print("Enter Name: ");
                        names[studentCount] = scanner.nextLine();

                        for (int j = 0; j < 3; j++) {
                            System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                            marks[studentCount][j] = scanner.nextInt();
                        }

                        scanner.nextLine();
                        studentCount++;
                    }

                    if (studentCount == maxStudents) {
                        System.out.println("Maximum student limit reached.");
                    }

                    break;

                case 2:

                    if (studentCount == 0) {
                        System.out.println("No student records available.");
                        break;
                    }

                    System.out.println("\n========== STUDENT REPORT ==========");

                    for (int i = 0; i < studentCount; i++) {

                        int total = 0;

                        System.out.println("\nStudent Name : " + names[i]);

                        System.out.print("Marks : ");

                        for (int j = 0; j < 3; j++) {
                            System.out.print(marks[i][j] + " ");
                            total += marks[i][j];
                        }

                        double average = total / 3.0;

                        System.out.println("\nTotal : " + total);
                        System.out.println("Average : " + average);

                        if (average >= 75) {
                            System.out.println("Grade : A");
                        } else if (average >= 60) {
                            System.out.println("Grade : B");
                        } else if (average >= 40) {
                            System.out.println("Grade : C");
                        } else {
                            System.out.println("Grade : Fail");
                        }
                    }

                    break;

                case 3:

                    if (studentCount == 0) {
                        System.out.println("No student records available.");
                        break;
                    }

                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine();

                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {

                        if (names[i].equalsIgnoreCase(searchName)) {

                            found = true;
                            int total = 0;

                            System.out.println("\nStudent Found");
                            System.out.println("Name : " + names[i]);

                            System.out.print("Marks : ");

                            for (int j = 0; j < 3; j++) {
                                System.out.print(marks[i][j] + " ");
                                total += marks[i][j];
                            }

                            double average = total / 3.0;

                            System.out.println("\nTotal : " + total);
                            System.out.println("Average : " + average);

                            if (average >= 75) {
                                System.out.println("Grade : A");
                            } else if (average >= 60) {
                                System.out.println("Grade : B");
                            } else if (average >= 40) {
                                System.out.println("Grade : C");
                            } else {
                                System.out.println("Grade : Fail");
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

        scanner.close();
    }
}
