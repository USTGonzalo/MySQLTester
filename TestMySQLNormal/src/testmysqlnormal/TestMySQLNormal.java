/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testmysqlnormal;

import database.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author usuario
 */
public class TestMySQLNormal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        try (Connection conn = MySQL.conectar()) {

            System.out.println("Conectado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 20; i++) {
            try (Connection conn = BaseDeDatos.conectar()) {

                PreparedStatement ps = conn.prepareStatement("SELECT * FROM test_performance");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    rs.getInt("id");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (fin - inicio) + " ms");
    }

}
