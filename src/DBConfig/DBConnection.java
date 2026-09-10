package DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL="jdbc:mysql://localhost:3306/FoodCaterinService";
    private static final String User="root";

    private static final String Pass="Root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,User,Pass);
    }
}

