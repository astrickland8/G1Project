import java.util.Scanner;
public class ESSMenu {
    /* drafting the employee self-service menu AE [7/18/2022]*/

    public static String essmenu() {
        Scanner scan = new Scanner (System.in);

        System.out.println ("--------------------------------");
        System.out.println ("WELCOME TO THE MCMILLAN EMPLOYEE SELF-SERVICE SYSTEM");
        System.out.println ("Please select from the following options and enter the");
        System.out.println ("associated keyword! I.E. (for [PAY] PAYROLL, you would enter \"PAY\").");
        System.out.println ("[INF] PERSONAL INFO");
        System.out.println ("[PAY] PAYROLL");
        System.out.println ("[BEN] BENEFITS");
        System.out.println ("[TAX] TAX INFORMATION");
        System.out.println ("--------------------------------");
        String input = scan.next ();
        if (input.equalsIgnoreCase ("inf")) {
            Employees.getEmployeeData ();
            }
        if (input.equalsIgnoreCase ("pay")) {
                //insert pay getter function here
            }
        if (input.equalsIgnoreCase ("ben")) {
                //insert benefit getter function here
            }
        if (input.equalsIgnoreCase ("tax")) {
                //insert tax getter function here
            }
        else {
            if (!input.equalsIgnoreCase ("pay")) {
                if (!input.equalsIgnoreCase ("inf")) {
                    if (!input.equalsIgnoreCase ("ben")) {
                        if (!input.equalsIgnoreCase ("tax")) {
                            input = "invalid";
                            System.out.println ("Input Invalid. Please enter a valid selection from the menu.");
                            while (input == "invalid") {
                                essmenu ();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return "--------------------------------";
    }
}
