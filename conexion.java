/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonatof;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conexion {
     Connection conexion = null; 
    public Connection conectar(){
        try {
         
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","CAMPE","CAMPE");
       //      JOptionPane.showMessageDialog(null,"conectado ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Fallo la conexion ");
        }
        return conexion;
    }
    
}
