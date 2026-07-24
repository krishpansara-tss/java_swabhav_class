package com.dbutorial.menu;

import com.dbutorial.model.Student;
import com.dbutorial.services.StudentServices;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    Scanner scanner = new Scanner(System.in);
    StudentServices studentServices;

    public StudentMenu(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    public void studentMenu(){
        while (true){
            System.out.println("\n\nOptions List: ");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Register student to the Course");
            System.out.println("6. Exit");
            System.out.print("Choose the Option: ");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    List<Student> studentList = studentServices.readStudent();
                    boolean found = false;
                    for(Student student : studentList){
                        found = true;
                        System.out.println("ID: " + student.getId() + "\t\tNAME: " + student.getName() + "\t\tAGE: " + student.getAge());
                    }

                    if(!found) System.out.println("No students found");
                    break;

                case 2:
                    System.out.println("Enter name of the student: ");
                    scanner.nextLine();
                    String studentName = scanner.nextLine();
                    System.out.println("Enter Age of the student: ");
                    int studentAge = scanner.nextInt();

                    studentServices.insertStudent(new Student(studentName, studentAge));
                    break;

                case 3:
                    System.out.println("Enter name of the student: ");
                    scanner.nextLine();
                    studentName = scanner.nextLine();

                    System.out.println("Enter Age of the student: ");
                    studentAge = scanner.nextInt();

                    System.out.println("Enter ID of the student: ");
                    int studentId = scanner.nextInt();


                    break;

                case 4:
                    System.out.println("Enter ID of the student: ");
                    studentId = scanner.nextInt();

                    studentServices.deleteStudent(studentId);
                    break;

                case 5:
                    System.out.println("Enter ID of the student: ");
                    studentId = scanner.nextInt();

                    System.out.println("Enter ID of the course: ");
                    int courseId = scanner.nextInt();

                    studentServices.enrollStudent(studentId, courseId);
                    break;

                case 6:
                    System.out.println("Returning to Main menu..");
                    return;


                default:
                    System.out.println("Please choose valid option");
            }
        }
    }
}
