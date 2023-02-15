/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Productos.Pantalla_agregar_productos;
import Productos.Pantalla_actualizar_productos;
import Productos.Pantalla_eliminar_productos;
import Productos.Pantalla_consultar_productos;


public class Pantalla_Principal extends javax.swing.JFrame 
{
    
     private String Id_Empleado;
     
    public Pantalla_Principal(String Id_Empleado) 
    {
        initComponents();
        setSize(800,600);
        setBounds(0,0,800,600);
        setResizable(false);
        setVisible(true);
        this.Id_Empleado=Id_Empleado;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuProductos = new javax.swing.JMenu();
        AltaProductos = new javax.swing.JMenuItem();
        EdiciónProductos = new javax.swing.JMenuItem();
        CancelacionProductos = new javax.swing.JMenuItem();
        ConsultaProductos = new javax.swing.JMenuItem();
        MenuProveedores2 = new javax.swing.JMenu();
        cerrarSesion1 = new javax.swing.JMenuItem();
        MenuProveedores1 = new javax.swing.JMenu();
        cerrarSesion = new javax.swing.JMenuItem();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(973, 601));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MI Tiendita");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 0, 360, 70);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Tiendita.jpg"))); // NOI18N
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 1030, 550);

        MenuProductos.setBorder(new javax.swing.border.MatteBorder(null));
        MenuProductos.setText("Productos");
        MenuProductos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        MenuProductos.setPreferredSize(new java.awt.Dimension(200, 50));

        AltaProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AltaProductos.setText("Alta Productos");
        AltaProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AltaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(AltaProductos);

        EdiciónProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EdiciónProductos.setText("Edición Productos");
        EdiciónProductos.setActionCommand("Consultar Pedidos");
        EdiciónProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EdiciónProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdiciónProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(EdiciónProductos);

        CancelacionProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CancelacionProductos.setText("Baja Productos");
        CancelacionProductos.setActionCommand("Consultar Pedidos");
        CancelacionProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelacionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelacionProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(CancelacionProductos);

        ConsultaProductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ConsultaProductos.setText("Consulta Productos");
        ConsultaProductos.setActionCommand("Consultar Pedidos");
        ConsultaProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConsultaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(ConsultaProductos);

        jMenuBar1.add(MenuProductos);

        MenuProveedores2.setBorder(new javax.swing.border.MatteBorder(null));
        MenuProveedores2.setText("Proveedores");
        MenuProveedores2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        MenuProveedores2.setPreferredSize(new java.awt.Dimension(200, 50));

        cerrarSesion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cerrarSesion1.setText("Administración de Proveedores");
        cerrarSesion1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cerrarSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesion1ActionPerformed(evt);
            }
        });
        MenuProveedores2.add(cerrarSesion1);

        jMenuBar1.add(MenuProveedores2);

        MenuProveedores1.setBorder(new javax.swing.border.MatteBorder(null));
        MenuProveedores1.setText("Salir");
        MenuProveedores1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        MenuProveedores1.setPreferredSize(new java.awt.Dimension(200, 50));

        cerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cerrarSesion.setText("Cerrar Sesión");
        cerrarSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        MenuProveedores1.add(cerrarSesion);

        jMenuBar1.add(MenuProveedores1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void ConsultaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaProductosActionPerformed
        Pantalla_consultar_productos ConsultaProductos = new Pantalla_consultar_productos();
    }//GEN-LAST:event_ConsultaProductosActionPerformed

    private void CancelacionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelacionProductosActionPerformed
        Pantalla_eliminar_productos BajaProducto = new Pantalla_eliminar_productos();
    }//GEN-LAST:event_CancelacionProductosActionPerformed

    private void EdiciónProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdiciónProductosActionPerformed
        Pantalla_actualizar_productos CambiaProducto = new Pantalla_actualizar_productos();
    }//GEN-LAST:event_EdiciónProductosActionPerformed

    private void AltaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaProductosActionPerformed
        Pantalla_agregar_productos NuevoProducto = new Pantalla_agregar_productos();
    }//GEN-LAST:event_AltaProductosActionPerformed

    private void cerrarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarSesion1ActionPerformed

    public static void main(String[] args) 
    {
        Pantalla_Principal pantalla = new Pantalla_Principal("2");
        pantalla.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AltaProductos;
    private javax.swing.JMenuItem CancelacionProductos;
    private javax.swing.JMenuItem ConsultaProductos;
    private javax.swing.JMenuItem EdiciónProductos;
    private javax.swing.JLabel Fondo;
    private javax.swing.JMenu MenuProductos;
    private javax.swing.JMenu MenuProveedores1;
    private javax.swing.JMenu MenuProveedores2;
    private javax.swing.JMenuItem cerrarSesion;
    private javax.swing.JMenuItem cerrarSesion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
