package com.dbutorial;

import com.dbutorial.menu.CourseMenu;
import com.dbutorial.menu.StudentMenu;
import com.dbutorial.model.Student;
import com.dbutorial.services.CourseServices;
import com.dbutorial.services.StudentServices;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentServices studentServices = new StudentServices();
        CourseServices courseService = new CourseServices();

        StudentMenu studentMenu = new StudentMenu(studentServices);
        CourseMenu courseMenu = new CourseMenu(courseService);

        while (true) {
            System.out.println("\n\nOptions List: ");
            System.out.println("1. Student Menu");
            System.out.println("2. Course Menu");
            System.out.println("3. Exit");
            System.out.print("Choose the Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    studentMenu.studentMenu();
                    break;

                case 2:
                    courseMenu.courseMenu();
                    break;

                case 3:
                    System.out.println("Program Exiting..");
                    System.exit(0);


                default:
                    System.out.println("Please choose valid option");
            }
        }
    }
}
