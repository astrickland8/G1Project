import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Employees {


    public static String getEmployeeData(){
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println ("Please enter your employee ID:");
        int employee_id = Integer.parseInt (scan.nextLine ());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
            if (conn != null) {
                System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }

        String query = "SELECT * FROM employees WHERE employee_id = " + employee_id + ";";
        Statement statement;
        try {
            statement = Objects.requireNonNull (conn).createStatement();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        ResultSet result;
        try {
            result = statement.executeQuery(query);

            while(result.next()) {
                System.out.println ("Name: " + result.getString ("firstname") +" " + result.getString("lastname"));
                System.out.println ("Address: " + result.getString ("emp_address") + ", " + result.getString ("emp_address2"));
                System.out.println (result.getString ("city") + ", " + result.getString ("state") + ", " + result.getString ("zip"));
                System.out.println ("Email: " + result.getString ("email"));
                System.out.println ("Phone: "+ result.getString ("phone"));
            }}
        catch (SQLException e) {
            throw new RuntimeException (e);
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";
    }

    public static String setEmployeeData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("To update your information, please enter your employee ID:");
        int employee_id = scan.nextInt ();
        System.out.println ("Please enter new first name:");
        String fname = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter new last name:");
        String lname = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter updated first line of address:");
        String address1 = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter updated second line of address:");
        String address2 = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter city:");
        String city = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter state 2 letter abbreviation:");
        String state = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter zip code:");
        int zip = Integer.parseInt (scan.nextLine ());
        System.out.println ("\n");
        System.out.println ("Enter email:");
        String email = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter phone number:");
        String phone = scan.nextLine ();
        System.out.println ("\n");

        String sql = "UPDATE employees SET firstname=?, lastname=?, emp_address=?, emp_address2=?, city=?, state=?, zip=?, email=?, phone=? WHERE employee_id = " + employee_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, fname);
            statement.setString (2, lname);
            statement.setString (3, address1);
            statement.setString (4, address2);
            statement.setString (5, city);
            statement.setString (6, state);
            statement.setString (7, String.valueOf (zip));
            statement.setString (8, email);
            statement.setString (9, phone);
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }

        int rowsUpdated;
        try {
            rowsUpdated = statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        if (rowsUpdated > 0) {
            System.out.println ("An existing user was updated successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }

    public static String newEmployeeData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("Please enter new employee's first name:");
        String fname = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter new employee's last name:");
        String lname = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter first line of address:");
        String address1 = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter second line of address:");
        String address2 = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter city:");
        String city = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter state 2 letter abbreviation:");
        String state = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter zip code:");
        int zip = Integer.parseInt (scan.nextLine ());
        System.out.println ("\n");
        System.out.println ("Enter email:");
        String email = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter phone number:");
        String phone = scan.nextLine ();
        System.out.println ("\n");
        System.out.println ("Enter employee's manager's id:");
        int manager_id = Integer.parseInt (scan.nextLine ());
        System.out.println ("\n");
        System.out.println ("Enter employee's department id:");
        int department_id = Integer.parseInt (scan.nextLine ());

        String sql = "INSERT INTO employees SET firstname=?, lastname=?, emp_address=?, emp_address2=?, city=?, state=?, zip=?, email=?, phone=?, manager_id=?, department_id=?;";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, fname);
            statement.setString (2, lname);
            statement.setString (3, address1);
            statement.setString (4, address2);
            statement.setString (5, city);
            statement.setString (6, state);
            statement.setString (7, String.valueOf (zip));
            statement.setString (8, email);
            statement.setString (9, phone);
            statement.setString (10, String.valueOf (manager_id));
            statement.setString (11, String.valueOf (department_id));
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }

        int rowsUpdated;
        try {
            rowsUpdated = statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        if (rowsUpdated > 0) {
            System.out.println ("A new user was added successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";
    }

    public static String removeEmployeeData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("Enter the employee ID for the record you would like to delete.");
        int employee_id = scan.nextInt ();

        String sql = "DELETE  from employees where employee_id = " + employee_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }

        int rowsUpdated;
        try {
            rowsUpdated = statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        if (rowsUpdated > 0) {
            System.out.println ("An employee record was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}
