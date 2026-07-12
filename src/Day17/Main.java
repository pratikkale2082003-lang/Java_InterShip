package Day17;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("======================================");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= ADD =================

                case 1:

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    Student student = new Student(name, email);

                    dao.insertStudent(student);

                    break;

                // ================= DISPLAY =================

                case 2:

                    dao.displayStudents();

                    break;

                // ================= SEARCH =================

                case 3:

                    System.out.print("Enter Student ID : ");

                    int searchId = sc.nextInt();

                    Student s = dao.searchStudent(searchId);

                    if (s != null) {

                        System.out.println("\nStudent Found");
                        System.out.println("----------------------------");
                        System.out.println("ID    : " + s.getStudentId());
                        System.out.println("Name  : " + s.getName());
                        System.out.println("Email : " + s.getEmail());

                    } else {

                        System.out.println("Student Not Found.");

                    }

                    break;

                // ================= UPDATE =================

                case 4:

                    System.out.print("Enter Student ID : ");

                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name : ");

                    String newName = sc.nextLine();

                    System.out.print("Enter New Email : ");

                    String newEmail = sc.nextLine();

                    Student updateStudent =
                            new Student(updateId, newName, newEmail);

                    dao.updateStudent(updateStudent);

                    break;

                // ================= DELETE =================

                case 5:

                    System.out.print("Enter Student ID : ");

                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    break;

                // ================= EXIT =================

                case 6:

                    System.out.println("\nThank You!");
                    System.out.println("Application Closed.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

        sc.close();

    }

}