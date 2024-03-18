import java.sql.*;

public class Main {
    public static String url = "jdbc:postgresql://localhost:5432/Assignment3";
    public static String user = "postgres";
    public static String password = "postgres";
    public static void main(String[] args) {
        /**
        System.out.println("Test 1: getAllStudent");
        getAllStudents();
        System.out.println("\nTest 2: addStudent");
        addStudent("Alex", "Hum", "alex.hum@example.com", "2024-01-01");
        System.out.println("\nTest 3: updateStudentEmail");
        updateStudentEmail(36, "changed@example.com");
        System.out.println("\nTest 4: deleteStudent");
        deleteStudent(36);
         */
    }

    private static void getAllStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM Students");
            ResultSet resultSet = statement.getResultSet();
            printColumnNames();
            while(resultSet.next()) {
                System.out.print(resultSet.getInt("student_id") + " \t\t\t");
                System.out.print(resultSet.getString("first_name") + " \t\t");
                System.out.print(resultSet.getString("last_name") + " \t\t");
                System.out.print(resultSet.getString("email") + " \t");
                System.out.println(resultSet.getString("enrollment_date") + " \t");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void addStudent(String firstName, String lastName, String emailAddress, String enrollmentDate) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sqlQuery = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, emailAddress);
            preparedStatement.setDate(4, Date.valueOf(enrollmentDate));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        getAllStudents();
    }

    private static void updateStudentEmail(int studentId, String emailAddress) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sqlQuery = "UPDATE students SET email = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        getAllStudents();
    }

    private static void deleteStudent(int studentId) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sqlQuery = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        getAllStudents();
    }
    private static void printColumnNames() {
        for(int i=0; i<5; i++) {
            if(i==0) {
                System.out.print("student_id" +"\t");
            } else if (i==1) {
                System.out.print("first_name" +"\t");
            } else if(i==2) {
                System.out.print("last_name" + "\t");
            } else if(i==3) {
                System.out.print("email" + "\t\t\t\t\t");
            } else if(i==4) {
                System.out.println("enrollment_date" + "\t");
            }
        }
    }
}
