package com.dbutorial.menu;

import com.dbutorial.model.Course;
import com.dbutorial.model.Student;
import com.dbutorial.services.CourseServices;
import com.dbutorial.services.StudentServices;

import java.util.List;
import java.util.Scanner;

public class CourseMenu {
    Scanner scanner = new Scanner(System.in);
    CourseServices courseService;

    public CourseMenu(CourseServices courseServices) {
        this.courseService = courseServices;
    }

    public void courseMenu() {
        while (true) {
            System.out.println("\n\nOptions List: ");
            System.out.println("1. View Course");
            System.out.println("2. Add Course");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Exit");
            System.out.print("Choose the Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    List<Course> courseList = courseService.getAllCourse();
                    boolean found = false;
                    for (Course course : courseList) {
                        found = true;
                        System.out.println(
                                "COURSE ID: " + course.getCourse_id() +
                                        "\tNAME: " + course.getCourse_name() +
                                        "\tPRICE: " + course.getCourse_price() +
                                        "\tDISCOUNT: " + course.getDiscount_percentage() +
                                        "\tRATING: " + course.getRating()
                        );
                    }

                    if (!found) System.out.println("No course found");
                    break;

                    case 2:
                        System.out.println("Enter Course Name: ");
                        scanner.nextLine();
                        String courseName = scanner.nextLine();

                        System.out.println("Enter Author Name: ");
                        String authorName = scanner.nextLine();

                        System.out.println("Enter Course Price: ");
                        double price = scanner.nextDouble();

                        System.out.println("Enter Discount (%): ");
                        double discount = scanner.nextDouble();

                        courseService.addCourse(new Course(courseName, authorName, price, discount));
                        break;

                    case 3:
                        System.out.println("Remaining");


                        break;

                    case 4:
                        System.out.println("Remaining");

                        break;

                    case 5:
                        System.out.println("Returning to Main menu..");
                        return;


                    default:
                        System.out.println("Please choose valid option");
            }
        }
    }
}
