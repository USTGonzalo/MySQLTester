package Conexion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigDB {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigDB.class
                .getClassLoader()
                .getResourceAsStream("configs/config.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró config.properties");
            }

            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Error cargando configuración", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}