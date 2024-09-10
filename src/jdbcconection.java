import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcconection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String host = "localhost";
        String port = "3306";
        String dbName = "demo";
        String username = "root";
        String password = "admin123";
        	
        try {
        
            // Establishing the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, username, password);
            // Creating a statement
            Statement statement = con.createStatement();
            // Executing the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Credentials WHERE scenario='zerobalancecard'");
            // Processing the result set
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
         // Closing resources
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
