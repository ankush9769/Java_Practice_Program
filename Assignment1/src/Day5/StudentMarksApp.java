package Day5;

import java.util.Scanner;

public class StudentMarksApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] name = new String[n];
        int[][] marks = new int[n][3];
        int choice;
        do {
            System.out.println("\n===== STUDENT MARKS APPLICATION =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter Student Details");
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Student Name: ");
                        name[i] = sc.nextLine();
                        System.out.println("Enter Marks for 3 Subjects:");
                        for (int j = 0; j < 3; j++) {
                            System.out.print("Subject " + (j + 1) + ": ");
                            marks[i][j] = sc.nextInt();
                        }
                        sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("\n----------- REPORT -----------");
                    for (int i = 0; i < n; i++) {
                        int total = 0;
                        System.out.println("\nStudent Name : " + name[i]);

                        System.out.print("Marks : ");

                        for (int j = 0; j < 3; j++) {
                            System.out.print(marks[i][j] + " ");
                            total += marks[i][j];
                        }

                        double avg = total / 3.0;

                        System.out.println("\nTotal : " + total);
                        System.out.println("Average : " + avg);

                        if (avg >= 75) {
                            System.out.println("Grade : A");
                        } else if (avg >= 60) {
                            System.out.println("Grade : B");
                        } else if (avg >= 40) {
                            System.out.println("Grade : C");
                        } else {
                            System.out.println("Grade : Fail");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Student Name to Search: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < n; i++) {

                        if (name[i].equalsIgnoreCase(search)) {

                            int total = 0;

                            System.out.println("\nStudent Found");
                            System.out.println("Name : " + name[i]);

                            System.out.print("Marks : ");

                            for (int j = 0; j < 3; j++) {
                                System.out.print(marks[i][j] + " ");
                                total += marks[i][j];
                            }

                            double avg = total / 3.0;

                            System.out.println("\nTotal : " + total);
                            System.out.println("Average : " + avg);

                            if (avg >= 75)
                                System.out.println("Grade : A");
                            else if (avg >= 60)
                                System.out.println("Grade : B");
                            else if (avg >= 40)
                                System.out.println("Grade : C");
                            else
                                System.out.println("Grade : Fail");

                            found = true;
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
        sc.close();
    }
}