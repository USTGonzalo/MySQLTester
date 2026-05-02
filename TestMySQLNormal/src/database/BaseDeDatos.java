package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

    public static Connection conectar() throws SQLException, ClassNotFoundException {

        String url = ConfigDB.get("db.url");
        String user = ConfigDB.get("db.user");
        String password = ConfigDB.get("db.password");
        String driver = ConfigDB.get("db.driver");

        Class.forName(driver);

        return DriverManager.getConnection(url, user, password);
    }
}