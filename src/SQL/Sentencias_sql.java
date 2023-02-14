package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Sentencias_sql 
{
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    int respuesta=0;



    public boolean Logearse(String sql,String usuario,String contraseña,String nivel) 
    {
        boolean comprobacion = false;
        try 
        {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ps.setString(3, nivel);
            rs = ps.executeQuery();

            if (rs.next()) 
            {
                comprobacion = true;
            } else 
            {
                comprobacion = false;
            }
            rs.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return comprobacion;
    }
    
    public String Id_Empleado(String sql,String usuario,String contraseña,String nivel) 
    {
        String Id_Empleado ="";
        try 
        {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ps.setString(3, nivel);
            rs = ps.executeQuery();

            if (rs.next()) 
            {
                Id_Empleado = rs.getString("Id_Empleado");
            }
            rs.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return Id_Empleado;
    } 
    
    public Object[] poblar_combox(String tabla, String nombrecol, int type_salida, boolean soloactivos) 
    {
        int registros = 0;
        int activos = 0;
        
        if (soloactivos)
            activos = 1;
            
        try {
            if (soloactivos)
                ps = con.Conectar().prepareStatement("SELECT count(*) as total FROM " + tabla + " where Id_Estatus_Objeto = 1");
            else
                ps = con.Conectar().prepareStatement("SELECT count(*) as total FROM " + tabla);
            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[] datos = new Object[registros];
        if (type_salida==1) {
            try {
                String sql="select "+nombrecol+" from "+tabla;
                ps = con.Conectar().prepareStatement(sql);
                rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    datos[i] = rs.getObject(nombrecol);
                    i++;
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        else 
            try {
                String sql="exec usp_LlenaComboBox '" + tabla + "','" + nombrecol + "',"+ activos + ";";
                System.out.println(sql);
                ps = con.Conectar().prepareStatement(sql);
                rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    datos[i] = rs.getNString(1);
                    i++;
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }        
        return datos;
    }
    
    public Object[] poblar_combox_condicion(String tabla, String nombrecol,String condicion) 
    {
        int registros = 0;
        try {
            ps = con.Conectar().prepareStatement("SELECT count(*) as total FROM "+tabla+" where Empresa = "+condicion);
            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[] datos = new Object[registros];
        try {
            String sql="select "+nombrecol+" from "+tabla+" where Empresa = "+condicion;
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                datos[i] = rs.getObject(nombrecol);
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }
    public Object[] poblar_combox_condicion_inversa(String tabla, String nombrecol,String condicion) 
    {
        int registros = 0;
        try {
            ps = con.Conectar().prepareStatement("SELECT count(*) as total FROM "+tabla+" where Id_Empleado != "+condicion);
            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[] datos = new Object[registros];
        try {
            String sql="select "+nombrecol+" from "+tabla+" where Id_Empleado != "+condicion;
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                datos[i] = rs.getObject(nombrecol);
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }
    
    public boolean insertar(String datos[], String insert) 
    {
        boolean estado = false;
        try 
        {
            ps = con.Conectar().prepareStatement(insert);
            for (int i = 0; i <= datos.length - 1; i++) 
            {
                ps.setString(i + 1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return estado;
    }

    public Object[][] GetTabla(String colName[], String tabla, String sql, Boolean SoloActivos) 
    {
        int registros = 0;
        try {
            if (SoloActivos)
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla + " where Id_Estatus_Objeto = 1");
            else
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla);

            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][colName.length];
        String col[] = new String[colName.length];

        try {
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j <= colName.length - 1; j++) {
                    col[j] = rs.getString(colName[j]);
                    if (col[j] == null) {
                        col[j] = "";
                    }
                    data[i][j] = col[j];
                }
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] GetTablaCondicion(String colName[], String tabla, String sql,String codigo, Boolean SoloActivos) 
    {
        int registros = 0;
        try {
            if (SoloActivos)
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla + " where Id_Estatus_Objeto = 1");
            else
                ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla);
            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][colName.length];
        String col[] = new String[colName.length];

        try {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j <= colName.length - 1; j++) {
                    col[j] = rs.getString(colName[j]);
                    if (col[j] == null) {
                        col[j] = "";
                    }
                    data[i][j] = col[j];
                }
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    
public Object[][] GetTablaCondiciones(String colName[], String tabla, String sql,String condicion1,String condicion2) 
    {
        int registros = 0;
        try {
            ps = con.Conectar().prepareStatement("select count(*) as total from " + tabla);
            rs = ps.executeQuery();
            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][colName.length];
        String col[] = new String[colName.length];

        try {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, condicion1);
            ps.setString(2, condicion2);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j <= colName.length - 1; j++) {
                    col[j] = rs.getString(colName[j]);
                    if (col[j] == null) {
                        col[j] = "";
                    }
                    data[i][j] = col[j];
                }
                i++;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public String IdVentas()
    {
        String idVentas="";
        String sql ="select max(Id_Venta) from Ventas";
        try
        {
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                idVentas=rs.getString(1);
            }
            
            if(idVentas==null)
            {
                idVentas="0";
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return idVentas;
    }
    
        
    public int Existencias(String CodigoProducto) 
    {
        String sql ="select Existencias from Productos where Codigo=?";
        int existencias=0;
        try
        {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, CodigoProducto);
            rs = ps.executeQuery();
            while(rs.next())
            {
               existencias=rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return existencias;
    }
    
    public boolean actualizarStock(int cantidad, String CodigoProducto)
    {
        boolean comprobacion=false;
        String sql ="update Productos set Existencias=? where Codigo=?";
        try
        {
            ps = con.Conectar().prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, CodigoProducto);
            respuesta = ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
            comprobacion=true;
        }
        return comprobacion;
    }
    
    public String IdPedidos()
    {
        String idPedidos="";
        String sql ="select max(Id_Pedido) from Pedidos";
        try
        {
            ps = con.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                idPedidos=rs.getString(1);
            }
            
            if(idPedidos==null)
            {
                idPedidos="0";
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return idPedidos;
    }      
    
    public int cantidadSurtidaVieja(String id_Pedido,String CodigoProducto) 
    {
        String sql ="select CantidadSurtida from Detalle_Pedidos where Id_Pedido=? AND CodigoProducto=?";
        int cantidadSurtidaVieja=0;
        try
        {
            ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, id_Pedido);
            ps.setString(2, CodigoProducto);
            rs = ps.executeQuery();
            while(rs.next())
            {
               cantidadSurtidaVieja=rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return cantidadSurtidaVieja;
    }        
}