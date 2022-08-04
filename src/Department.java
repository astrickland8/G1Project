import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Department {

    public static String getDepartmentData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println("Please enter your Department ID:");
        int department_id = Integer.parseInt(scan.nextLine());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "SELECT * FROM department WHERE department_id = " + department_id + ";";
        Statement statement;
        try {
            statement = Objects.requireNonNull(conn).createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet result;
        try {
            result = statement.executeQuery(query);


            while (result.next()) {
                System.out.println("Department ID: " + result.getInt("department_id"));
                System.out.println("Department: " + result.getString("department"));
                System.out.println("Location: " + result.getInt("location_id"));
                System.out.println("Manager: " + result.getInt("manager_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";
    }

    public static String setDepartmentData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
            if (conn != null) {
                System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("To update a Department's information, please enter the Department ID:");
        int department_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Department:");
        String department = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location Id:");
        int location_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Manager ID:");
        int manager_id = scan.nextInt();
        System.out.println("\n");

        String sql = "UPDATE department SET department=?, location_id=?, manager_id=? WHERE department_id = " + department_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, department_id);
            statement.setString(1, department);
            statement.setInt(2, location_id);
            statement.setInt(3, manager_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int rowsUpdated;
        try {
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (rowsUpdated > 0) {
            System.out.println("An existing department was updated successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String newDepartmentData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
            if (conn != null) {
                System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Please enter new Department ID:");
        Integer department_id = scan.nextInt();
        System.out.println("Please enter new Department:");
        String department = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location:");
        Integer location_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Enter new Manager ID:");
        Integer manager_id = scan.nextInt();
        System.out.println("\n");

        String sql = "INSERT INTO department SET department_id=?, department=?, location_id=?, manager_id=?";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, department_id);
            statement.setString(1, department);
            statement.setInt(3, location_id);
            statement.setInt(3, manager_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int rowsUpdated;
        try {
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (rowsUpdated > 0) {
            System.out.println("A new department was added successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String removeDepartmentData() {
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
        System.out.println ("Enter the Department ID for the record you would like to delete.");
        int department_id = scan.nextInt();

        String sql = "DELETE  from department where department_id = " + department_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setInt (1, Integer.valueOf (department_id));
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
            System.out.println ("A department was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}
