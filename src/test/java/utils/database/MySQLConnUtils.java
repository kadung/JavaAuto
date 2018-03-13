package utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    String hostName = "localhost";
    String dbName   = "simplehr";
    String userName = "root";
    String password = "1234";

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException,ClassNotFoundException {
        /** Khai báo class Driver cho DB MySQL: Việc này cần thiết với Java 5, Java6 tự động tìm kiếm Driver thích hợp.
         *  Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
         */
        // Class.forName("com.mysql.jdbc.Driver");

        /** Cấu trúc URL Connection dành cho Oracle
         *  Ví dụ: jdbc:mysql://localhost:3306/simplehr
         */

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection con = DriverManager.getConnection(connectionURL, userName, password);
        return con;
    }
}
