/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class koneksi {
    
    private static Connection conn;
    
    public static Connection getConnection() {
        if(conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/mahasiswa";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        } 
        return conn;
    }
    
}
