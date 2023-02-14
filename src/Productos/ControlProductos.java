package Productos;


import SQL.Sentencias_sql;
import javax.swing.JOptionPane;


public class ControlProductos 
{
    Sentencias_sql sensql;
    public ControlProductos() 
    {
        sensql = new Sentencias_sql();
    }


    public boolean agregarProductos(String Codigo, String Descripcion, String Presentacion,String Id_Proveedor, String PrecioCompra, String PrecioVenta)
    {               
        String datos[] = {Codigo,Descripcion,Presentacion,Id_Proveedor,PrecioCompra,PrecioVenta};           
        return sensql.insertar(datos, "{CALL SP_Agregar_Producto(?,?,?,?,?,?)}");                         
    }
    
    public boolean actualizar_productos(String Codigo,String Descripcion,String Presentacion,String Empresa,String Existencias,String PrecioCompra,String PrecioVenta)
    {
        String campos[] = {Codigo,Descripcion,Presentacion,Empresa,Existencias,PrecioCompra,PrecioVenta};           
        return sensql.insertar(campos, "{CALL SP_Update_Producto (?,?,?,?,?,?,?)}");
    }
    
    public boolean eliminarProducto(String Codigo)
    {
        String campos[] = {Codigo};           
        return sensql.insertar(campos, "{CALL SP_Borrar_Producto(?)}");
    } 
    
    public Object[][] mostrarProductos()
    {
        String[] columnas={"Codigo","Descripcion","Presentacion","Empresa","Existencias","PrecioUnitarioCompra","PrecioUnitarioVenta","Estatus"};
        Object[][] datos = sensql.GetTabla(columnas, "View_Productos", "{CALL SP_Mostrar_Productos}",false);
        return datos;
    }
    
    public Object[][] mostrarBusquedaProductos(String codigo)
    {
        String[] columnas={"Codigo","Descripcion","Presentacion","Empresa","Existencias","PrecioUnitarioCompra","PrecioUnitarioVenta","Estatus"};
        Object[][] datos = sensql.GetTablaCondicion(columnas, "View_Productos", "{CALL SP_Buscar_Producto_Codigo(?)}",codigo,false);
        return datos;
    }
    
    //JCRR
    public Object[][] mostrarBusquedaProductosLike(String nombre)
    {
        String[] columnas={"Codigo","Descripcion","Presentacion","Empresa","Existencias","PrecioUnitarioCompra","PrecioUnitarioVenta","Estatus"};
        Object[][] datos = sensql.GetTablaCondicion(columnas, "View_Productos", "{CALL SP_Buscar_Producto_Codigo_Like(?)}",nombre,false);
        return datos;
    }
    
    public Object[][] datos_producto(String codigo_Producto)
    {
        String[] columnas={"Descripcion","Presentacion","Empresa","Existencias","PrecioUnitarioCompra","PrecioUnitarioVenta"};
        Object[][] resultado = sensql.GetTabla(columnas, "Productos", "exec usp_ConsultaProductoActivo '" + codigo_Producto + "';",true);
        return resultado;
    }
    
    public Object[][] datos_producto_ACTIVOS(String codigo_Producto)
    {
        String[] columnas={"Descripcion","Presentacion","Empresa","Existencias","PrecioUnitarioCompra","PrecioUnitarioVenta"};
        Object[][] resultado = sensql.GetTabla(columnas, "Productos", "select Descripcion, Presentacion, Empresa, Existencias, PrecioUnitarioCompra, PrecioUnitarioVenta from Productos where Codigo= '"+codigo_Producto+"' AND Id_Estatus_Objeto=1;",true);
        return resultado;
    } 
}