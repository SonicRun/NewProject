import java.sql.*;
import java.util.logging.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCtest {

    public static void main(String[] args) {

        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/test";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "123456";
         final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/test";
         final String USER = "user";
         final String PASS = "123456";

        System.out.println("Testing connection to PostgreSQL JDBC");

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

    }
}