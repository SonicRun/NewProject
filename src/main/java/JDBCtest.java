import java.sql.*;
import java.util.logging.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Scanner;
public class JDBCtest {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
        final String USER = "user";
        final String PASS = "123456";
        Scanner in = new Scanner(System.in);
        System.out.println("Testing connection to PostgreSQL JDBC");
        PreparedStatement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        stmt = connection.prepareStatement(" INSERT INTO users (login, password) values (?, ?)");
        System.out.print(" Input a login of your user: ");
        String g  = in.next();
        System.out.print("\n");
        stmt.setString(1, g);
        System.out.print(" Input a password of your user: ");
        String r  = in.next();
        System.out.print("\n");
        stmt.setString(2, r);
        if (stmt.execute()) {
            System.out.print(" Add user complate ");
        }

        stmt = connection.prepareStatement("SELECT * FROM users ");
        ResultSet set = stmt.executeQuery();
        while (set.next()) {
            System.out.println(set.getString(1) + " " + set.getString(2) + " " + set.getInt(3));
        }

    }
}