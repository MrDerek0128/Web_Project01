package JAVA.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@SuppressWarnings("all")
public class JdbcUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        Properties p = new Properties();
        ClassLoader classLoader = JdbcUtils.class.getClassLoader();
        URL u = classLoader.getResource("pro.properties");
        String path = null;
        try {
            path = u.toURI().getPath();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        try {
            p.load(new FileReader(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        url = p.getProperty("url");
        username = p.getProperty("user");
        password = p.getProperty("password");
        driver = p.getProperty("driver");
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close (Statement statement,Connection connection){
        try {
            if (statement != null){
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
