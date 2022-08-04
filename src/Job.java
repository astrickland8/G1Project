import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Job {

    public static String getJobData() {
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://localhost:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "Nitroars8"; // update your password here

        System.out.println("Please enter your Job ID:");
        int job_id = Integer.parseInt(scan.nextLine());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "SELECT * FROM job WHERE job_id = " + job_id + ";";
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
                System.out.println("Job ID: " + result.getInt("job_id"));
                System.out.println("Employee ID: " + result.getInt("employee_id"));
                System.out.println("Job Title: " + result.getString("job_title"));
                System.out.println("Department: " + result.getString("department"));
                System.out.println("Department ID: " + result.getInt("department_id"));
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

    public static String setJobData() {
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
        System.out.println("To update a Job's information, please enter the Job ID:");
        int job_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Employee ID:");
        int employee_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Please enter the Job Title:");
        String job_title = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Department:");
        String  department = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter the Department ID:");
        int department_id = scan.nextInt();
        System.out.println("\n");

        String sql = "UPDATE job SET job_id=?, employee_id=?, job_title=?, department=?, department_id=? WHERE job_id = " + job_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, job_id);
            statement.setInt(1, employee_id);
            statement.setString(2, job_title);
            statement.setString(3, department);
            statement.setInt(3, department_id);
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
            System.out.println("An existing job was updated successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String newJobData() {
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
        System.out.println("Please enter new Job ID:");
        int job_id = scan.nextInt();
        System.out.println("Please enter new Employee ID:");
        int employee_id = scan.nextInt();
        System.out.println("\n");
        System.out.println("Enter new Job Title:");
        String job_title = scan.nextLine();
        System.out.println("\n");
        System.out.println("Enter new Department:");
        String department = scan.nextLine();
        System.out.println("\n");
        System.out.println("Please enter new Department ID:");
        int department_id = scan.nextInt();
        System.out.println("\n");

        String sql = "INSERT INTO job SET job_id=?, employee_id=?, job_title=?, department=?, department_id=?";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement(sql);
            statement.setInt(2, job_id);
            statement.setInt(1, employee_id);
            statement.setString(3, job_title);
            statement.setString(3, department);
            statement.setInt(1, department_id);
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
            System.out.println("A new job was added successfully!");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "\n-----------------------\n";

    }

    public static String removeJobData() {
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
        System.out.println ("Enter the Job ID for the record you would like to delete.");
        int job_id = scan.nextInt();

        String sql = "DELETE  from job where job_id = " + job_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setInt (1, Integer.valueOf (job_id));
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
            System.out.println ("A job was deleted successfully!");
        }
        try {
            conn.close ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";

    }
}
