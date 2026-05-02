package Conexion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLPool {

    private static final HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(ConfigDB.get("db.url"));
        config.setUsername(ConfigDB.get("db.user"));
        config.setPassword(ConfigDB.get("db.password"));

        // Driver (opcional en versiones nuevas, pero lo dejamos)
        config.setDriverClassName(ConfigDB.get("db.driver"));

        // 🔥 CONFIGURACIÓN IMPORTANTE
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);

        // 🚀 OPTIMIZACIONES PARA MYSQL
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");

        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}