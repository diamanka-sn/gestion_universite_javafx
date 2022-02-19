package ConnexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnexionBase {

    private static PreparedStatement ps;
    private static ResultSet rs;
    Connection conn = null;

    public static Connection conDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/universite?autoReconnect=true&useSSL=false", "root", "");
            return conn;
        } catch (Exception e) {
            System.err.println("Echecs connexion base de donnees" + e.getMessage());
            return null;
        }

    }
}
