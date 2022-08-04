import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Location {

    public static String getLocationData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println("Please enter your Location ID:");
        int location_id = Integer.parseInt(scan.nextLine());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "SELECT * FROM location WHERE location_id = " + location_id + ";";
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
                System.out.println("Location Id: " + result.getInt("location_id"));
                System.out.println("Department ID: " + result.getInt("department_id"));
                System.out.println("Location name: " + result.getString("location_name"));
                System.out.println("Location address: " + result.getString("location_address"));
                System.out.println("Location address 2: " + result.getString("location_address2"));
                System.out.println("Location city: " + result.getString("location_city"));
                System.out.println("Location state: " + result.getString("location_state"));
                System.out.println("Location zip: " + result.getString("location_zip"));
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

    public static String setLocationData() {
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
        System.out.println("To update Location information, please enter the Location ID:");
        int location_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Department Id:");
        int department_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Location name:");
        String location_name = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location address:");
        String location_address = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location address 2:");
        String location_address2 = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location city:");
        String location_city = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location state:");
        String location_state = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Location zip:");
        String location_zip = scan.nextLine();
        System.out.println("\n");

        String sql = "UPDATE location SET location_id=?, department_id=?, location_name=?, location_address=?, location_address2=?, location_city=?, location_state=?, location_zip=? WHERE location_id = " + location_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, location_id);
            statement.setInt(1, department_id);
            statement.setString(2, location_name);
            statement.setString(3, location_address);
            statement.setString(3, location_address2);
            statement.setString(3, location_city);
            statement.setString(3, location_state);
            statement.setString(3, location_zip);
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
            System.out.println("An existing location was updated successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String newLocationData() {
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
        System.out.println("Please enter new Location ID:");
        int location_id = scan.nextInt();
        System.out.println("Please enter new Department ID:");
        int department_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Enter new Location name:");
        String location_name = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location Address :");
        String location_address = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location Address 2 :");
        String location_address2 = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location city :");
        String location_city = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location state :");
        String location_state = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Location zip :");
        String location_zip = scan.nextLine();
        System.out.println("\n");

        String sql = "INSERT INTO location SET location_id=?, department_id=?, location_name=?, location_address=?, locatioin_address2=?, location_city=?, location_state=?, location_zip=?";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, location_id);
            statement.setInt(1, department_id);
            statement.setString(3, location_name);
            statement.setString(3, location_address);
            statement.setString(3, location_address2);
            statement.setString(3, location_city);
            statement.setString(3, location_state);
            statement.setString(3, location_zip);
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
            System.out.println("A new location was added successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String removeLocationData() {
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
        System.out.println ("Enter the Location ID for the record you would like to delete.");
        int location_id = scan.nextInt();

        String sql = "DELETE  from location where location_id = " + location_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setInt (1, Integer.valueOf (location_id));
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
            System.out.println ("A location was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}
