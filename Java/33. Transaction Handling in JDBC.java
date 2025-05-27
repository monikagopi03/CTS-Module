import java.sql.*;

public class TransactionDemo {
    private final String url = "jdbc:mysql://localhost:3306/testdb";
    private final String user = "root";
    private final String password = "password";

    public void transferMoney(int fromAccount, int toAccount, double amount) throws SQLException {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();

                conn.commit();
                System.out.println("Transfer successful!");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transfer failed, rolled back.");
                throw e;
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        TransactionDemo demo = new TransactionDemo();
        demo.transferMoney(1, 2, 500.0);
    }
}
