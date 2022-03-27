package hiber.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public Connection conection(){
        final String URL = "jdbc:mysql://localhost:3306/2_2_1_shema?serverTimezone=Europe/Moscow&useSSL=false";
        final String USER = "root";
        final String PASS = "qwerty123Ffd";
        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер не найден");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
        System.out.println("Соединение не выполнено");
        return conn;
    }
}
