package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            // Get the connection from ConnectionProvider
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            // Creating the product table
            // Check if the table already exists
            //    st.executeUpdate("CREATE TABLE IF NOT EXISTS appuser (appuser_pk INT PRIMARY KEY AUTO_INCREMENT, userRole VARCHAR(50), name VARCHAR(200), mobilenumber VARCHAR(50), email VARCHAR(50), password VARCHAR(50), address VARCHAR(200), status VARCHAR(50))");
            //  st.executeUpdate("INSERT INTO appuser (userRole, name, mobilenumber, email, password, address, status) VALUES ('SuperAdmin', 'Super Admin', '12345', 'sa@testemail.com', 'test', 'India', 'Active')");
            // st.executeUpdate("CREATE TABLE category (category_pk INT PRIMARY KEY AUTO_INCREMENT, name varchar(200))");
            //st.executeUpdate("CREATE TABLE product (product_pk INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(200), quantity INT, price INT, description VARCHAR(500), category_fk INT)");
            //st.executeUpdate("CREATE TABLE customer (customer_pk INT AUTO_INCREMENT PRIMARY KEY, name varchar(50),mobilenumber varchar(50),email varchar(100))");
            st.executeUpdate("CREATE TABLE orderDetails(order_pk INT AUTO_INCREMENT PRIMARY KEY, orderId varchar(200),customer_fk int,orderDate varchar(200),totalPaid int)");
// Success message
            
            JOptionPane.showMessageDialog(null, "Table created successfully.");
        } catch (Exception e) {
            // Show only the error message for user-friendliness
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Always close resources in the finally block
            try {
                if (st != null) {
                    st.close(); // Close statement if it's not null
                }
                if (con != null) {
                    con.close(); // Close connection if it's not null
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error closing connection: " + e.getMessage());
            }
        }
    }
}
