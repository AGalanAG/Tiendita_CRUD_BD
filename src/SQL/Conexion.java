/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection con = null;
    //private final String url = "jdbc:sqlserver://LAPTOP-201MM1BF;databaseName=TiendaEjercicio;integratedSecurity=true";
    private final String url = "jdbc:sqlserver://DESKTOP-42151EK;databaseName=TiendaEjercicio;user=Alan;password=spiderman;";
    //private final String usuario = "ProyectoBD";
    //private final String contraseña = "Contraseña";

    public Conexion() {
        try 
        {
            //con = DriverManager.getConnection(url, usuario, contraseña);
            con = DriverManager.getConnection(url);
            if (con != null) 
            {
                System.out.println("Conexión a base de datos Tienda listo");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error de Conexion" + e.getMessage());
        } 
    }

    public Connection Conectar() 
    {
        return con;
    }

    public void desconectar() 
    {
        con = null;
        System.out.println("Conexion terminada");
    }
}
