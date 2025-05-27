import java.sql.*;

public class JdbcBasic {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Change accordingly
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("Student: " + id + ", " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
