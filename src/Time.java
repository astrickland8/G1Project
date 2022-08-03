import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Time {
    public static String getTimeData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println("Please enter your Time ID:");
        int time_id = Integer.parseInt(scan.nextLine());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "SELECT * FROM time WHERE time_id = " + time_id + ";";
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
                System.out.println("Employee ID: " + result.getString("employee_id"));
                System.out.println("Clock in: " + result.getString("clock_in"));
                System.out.println("Clock out: " + result.getString("clock_out"));
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

    public static String setTimeData() {
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
        System.out.println("To update an employee's clock in time, please enter their time ID:");
        int time_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the employees clock in time:");
        String clock_in = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the employees clock in time:");
        String clock_out = scan.nextLine();
        System.out.println("\n");

        String sql = "UPDATE time SET clock_in=?, clock_out=? WHERE time_id = " + time_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setString(1, clock_in);
            statement.setString(2, clock_out);
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
            System.out.println("An existing user was updated successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String newTimeData() {
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
        System.out.println("Please enter new employee's clock in time:");
        String clock_in = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new employee's clock out time:");
        String clock_out = scan.nextLine();
        System.out.println("\n");


        String sql = "INSERT INTO time SET clock_in=?, clock_out=?";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setString(1, clock_in);
            statement.setString(2, clock_out);
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
            System.out.println("A new user was added successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String removeTimeData() {
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
        System.out.println ("Enter the time ID for the record you would like to delete.");
        int time_id = scan.nextInt ();

        String sql = "DELETE  from time where time_id = " + time_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, String.valueOf (time_id));
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
            System.out.println ("A time record was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}

