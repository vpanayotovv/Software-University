package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static Connection connection;

    public static void createConnection(String username,String password,String dbName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user",username);
        properties.setProperty("password",password);
        connection = DriverManager.getConnection(DB_URL + dbName,properties);
    }

    public static Connection getConnection() {
        return connection;
    }
}
