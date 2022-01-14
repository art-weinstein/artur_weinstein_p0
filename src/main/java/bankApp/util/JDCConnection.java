package bankApp.util;

// imports from java.sql -> JDVC
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDCConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            // establish a new connection

            Properties props = new Properties();
            try {


                props.load(JDCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));

//                props.load(new FileReader("src/main/resources/connection.properties"));



                String endpoint = "artfirstdatabase.cv1aa0d5fhug.us-east-1.rds.amazonaws.com";
                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                String username = props.getProperty("username");
                String password = props.getProperty("password");
                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException e) {
                e.printStackTrace();

                return conn;

            }

        /*
            }
        THIS IS FOR TESTING PURPOSES ONLY
        NOT NEEDED TO ACTUALLY USE JDBC
         */
            }
        return conn;
        }
            public static void main (String[]args){
                Connection conn1 = getConnection();
                System.out.println(conn1);
    }
}

