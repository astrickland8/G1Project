
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class ApplicantTracking {

    public static String getApplicantData(){
        Scanner scan = new Scanner(System.in);
        String myUrl = "jdbc:mysql://127.0.0.1:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "G1Project"; // update your password here

        System.out.println ("Please enter the Application ID:");
        int app_id = Integer.parseInt (scan.nextLine ());

        Connection conn;
        try {
            conn = DriverManager.getConnection(myUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        if (conn != null) {
            System.out.println("-----------------------\nConnection Established.\n-----------------------\n");
        }

        String query = "select * from applicant_tracking join manager m on applicant_tracking.manager_id = m.manager_id where applicant_id =  " + app_id + ";";
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
                System.out.println ("Applicant ID: " + result.getString ("applicant_id"));
                System.out.println ("Reviewed By Manager: " + result.getString ("firstname") + result.getString ("lastname"));
                System.out.println ("Application Date: " + result.getString ("app_date"));
                System.out.println ("Interviewed?: " + result.getBoolean ("interviewed"));
                System.out.println ("Hired?: "+ result.getBoolean ("hired"));
            }}
        catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return "\n-----------------------\n";
    }

    public static String setApplicationData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://127.0.0.1:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "G1Project"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("To update an application, please enter the application ID:");
        int applicant_id = scan.nextInt ();

        System.out.println ("Enter new job id:");
        String jobid = scan.next ();

        System.out.println ("Enter new job title:");
        String jobtitle = scan.next ();

        System.out.println ("Have they been interviewed? 1 for true, 0 for false:");
        String interview = String.valueOf (scan.nextBoolean ());

        System.out.println ("Have they been hired? 1 for true, 0 for false:");
        String hired = String.valueOf (scan.nextBoolean ());

        System.out.println ("Enter hire date:");
        String hiredate = scan.next ();

        String sql = "UPDATE applicant_tracking SET job_id=?, job_title=?, interviewed=?, hired=?, hire_date=? WHERE applicant_id = " + applicant_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, jobid);
            statement.setString (2, jobtitle);
            statement.setString (3, interview);
            statement.setString (4, hired);
            statement.setString (5, hiredate);
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
        return "\n-----------------------\n";

    }

    public static String newApplicationData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://127.0.0.1:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "G1Project"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("Does the new applicant already have an an employee ID? If yes, enter it below, if no, enter 0:");
        int employee_id = scan.nextInt ();

        System.out.println ("Enter new job id:");
        String jobid = scan.next ();

        System.out.println ("Enter new job title:");
        String jobtitle = scan.next ();

        System.out.println ("Have they been interviewed? 1 for true, 0 for false:");
        String interview = String.valueOf (scan.nextBoolean ());

        System.out.println ("Have they been hired? 1 for true, 0 for false:");
        String hired = String.valueOf (scan.nextBoolean ());

        System.out.println ("Enter hire date:");
        String hiredate = scan.next ();

        String sql = "INSERT INTO applicant_tracking SET employee_id=?, job_id=?, job_title=?, interviewed=?, hired=?, hire_date=?;";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, String.valueOf (employee_id));
            statement.setString (2, jobid);
            statement.setString (3, jobtitle);
            statement.setString (4, interview);
            statement.setString (5, hired);
            statement.setString (6, hiredate);
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
            System.out.println ("A new application was added successfully!");
        }
        return "\n-----------------------\n";

    }

    public static String removeApplicationData() {
        Scanner scan = new Scanner (System.in);
        String myUrl = "jdbc:mysql://127.0.0.1:3306/mcmillanhrisproject";// update your url here
        String user = "root"; // update your username here
        String password = "G1Project"; // update your password here


        Connection conn;
        try {
            conn = DriverManager.getConnection (myUrl, user, password);
            if (conn != null) {
                System.out.println ("-----------------------\nConnection Established.\n-----------------------\n");
            }} catch (SQLException e) {
            throw new RuntimeException (e);
        }
        System.out.println ("Enter the application ID you would like to delete.");
        int applicant_id = scan.nextInt ();

        String sql = "DELETE  from applicant_tracking where applicant_id = " + applicant_id + ";";
        PreparedStatement statement;
        try {
            assert conn != null;
            statement = conn.prepareStatement (sql);
            statement.setString (1, String.valueOf (applicant_id));
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
            System.out.println ("An application was deleted successfully!");
        }
        return "\n-----------------------\n";

    }
}

