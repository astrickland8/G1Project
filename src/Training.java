import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Training {

    public static String getTrainingData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println("Please enter your Course ID:");
        int course_id = Integer.parseInt(scan.nextLine());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "SELECT * FROM training WHERE course_id = " + course_id + ";";
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
                System.out.println("Course ID: " + result.getInt("course_id"));
                System.out.println("Employee ID: " + result.getString("employee_id"));
                System.out.println("Manager ID: " + result.getInt("manager_id"));
                System.out.println("Course name: " + result.getString("course_name"));
                System.out.println("Course date: " + result.getDate("course_date"));
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

    public static String setTrainingData() {
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
        System.out.println("To update a Training's information, please enter the Course ID:");
        int course_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Employee ID:");
        int employee_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Manager ID:");
        int manager_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Course name:");
        String course_name = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Course date:");
        String course_date = scan.nextLine();
        System.out.println("\n");

        String sql = "UPDATE training SET course_id=?, employee_id=?, manager_id=?, course_name=?, course_date=? WHERE course_id = " + course_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, course_id);
            statement.setInt(1, employee_id);
            statement.setInt(2, manager_id);
            statement.setString(3, course_name);
            statement.setString(2, course_date);
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
            System.out.println("An existing training was updated successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String newTrainingData() {
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
        System.out.println("Please enter new Course ID:");
        int course_id = scan.nextInt();
        System.out.println("Please enter new Employee ID:");
        int employee_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Enter new Manager ID:");
        int manager_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Enter new Course name :");
        String course_name = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Course date :");
        String course_date = scan.nextLine();
        System.out.println("\n");

        String sql = "INSERT INTO location SET course_id=?, employee_id=?, manager_id=?, course_name=?, course_date=?";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, course_id);
            statement.setInt(1, employee_id);
            statement.setInt(3, manager_id);
            statement.setString(3, course_name);
            statement.setString(3, course_date);
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
            System.out.println("A new training was added successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String removeTrainingData() {
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
        System.out.println ("Enter the Course ID for the record you would like to delete.");
        int course_id = scan.nextInt();

        String sql = "DELETE  from training where course_id = " + course_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setInt (1, Integer.valueOf (course_id));
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
            System.out.println ("A training was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}
