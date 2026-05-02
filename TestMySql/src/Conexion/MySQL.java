package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL {

    public static Connection conectar() throws SQLException {
        return MySQLPool.getConnection();
    }
}