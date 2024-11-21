/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akrent;

/**
 *
 * @author andin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        if (koneksi==null){
            try{
                String url="jdbc:mysql://localhost/akrent";
                String user="root";
                String pass="";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi=DriverManager.getConnection(url, user, pass);
            }catch (SQLException t){
                System.out.println("Error membuat koneksi");
            }
        }
        return koneksi;
    }
}
