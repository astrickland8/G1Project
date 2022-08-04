import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
public class ESSMenu {
    /* drafting the employee self-service menu AE [7/18/2022]*/

    public static String essmenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("WELCOME TO THE MCMILLAN EMPLOYEE SELF-SERVICE SYSTEM");
        System.out.println("Please select from the following options and enter the");
        System.out.println("associated keyword! I.E. (for [PAY] PAYROLL, you would enter \"PAY\").");
        System.out.println("[INF] PERSONAL INFO");
        System.out.println("[PAY] PAYROLL");
        System.out.println("[BEN] BENEFITS");
        System.out.println("[TAX] TAX INFORMATION");
        System.out.println("[TAX DELETE] DELETE TAX INFORMATION");
        System.out.println("[TIME] TIME INFO");
        System.out.println("[ATTN] ATTENDANCE");
        System.out.println("[DEP] DEPARTMENT");
        System.out.println("[JOB] JOB");
        System.out.println("[LOC] LOCATION");
        System.out.println("[TRAIN] TRAINING");

        System.out.println("--------------------------------");
        String input = scan.next();
        if (input.equalsIgnoreCase("inf")) {
            Employees.getEmployeeData();
        }
        if (input.equalsIgnoreCase("pay")) {
            //insert pay getter function here
        }
        if (input.equalsIgnoreCase("ben")) {
            //insert benefit getter function here
        }
        if (input.equalsIgnoreCase("attn")) {
            Attendance.getAttendanceData();
        }
        if (input.equalsIgnoreCase("time")) {
            Time.getTimeData();
        }
        if (input.equalsIgnoreCase("tax delete")) {
            Tax.removeTaxData();
        }
        if (input.equalsIgnoreCase("dep")) {
            Department.getDepartmentData();
        }
        if (input.equalsIgnoreCase("job")) {
            Job.getJobData();
        }
        if (input.equalsIgnoreCase("loc")) {
            Location.getLocationData();
        }
        if (input.equalsIgnoreCase("train")) {
            Training.getTrainingData();
        } else {
            if (!input.equalsIgnoreCase("pay")) {
                if (!input.equalsIgnoreCase("inf")) {
                    if (!input.equalsIgnoreCase("attn")) {
                        if (!input.equalsIgnoreCase("ben")) {
                            if (!input.equalsIgnoreCase("time")) {
                                if (!input.equalsIgnoreCase("tax delete")) {
                                    if (!input.equalsIgnoreCase("dep")) {
                                        if (!input.equalsIgnoreCase("job")) {
                                            if (!input.equalsIgnoreCase("loc")) {
                                                if (!input.equalsIgnoreCase("train")) {
                                                    input = "invalid";
                                                    System.out.println("Input Invalid. Please enter a valid selection from the menu.");
                                                    while (input == "invalid") {
                                                        essmenu();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
                        return "--------------------------------";
    }
}
