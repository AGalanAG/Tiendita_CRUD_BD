/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import SQL.Sentencias_sql;
import javax.swing.JOptionPane;


public class Pantalla_actualizar_productos extends javax.swing.JFrame 
{

     Sentencias_sql sen = new Sentencias_sql();
     ControlProductos control = new ControlProductos();
     
    public Pantalla_actualizar_productos()
    {
        initComponents();
        descripcion_antigua.setEnabled(false);
        presentacion_antigua.setEnabled(false);
        proveedor_antiguo.setEnabled(false);
        existencias_antigua.setEnabled(false);
        precio_compra_antiguo.setEnabled(false);
        precio_venta_antiguo.setEnabled(false);
        comboCodigoProducto();
        comboProveedor();
        setBounds(60,60,820,400);
        setResizable(false);
        setVisible(true);
        datosPuestos();
    }

public void comboCodigoProducto()
{
        String tabla,campo;
        tabla="Productos";
        campo="Descripcion";
        Object[] tipo = sen.poblar_combox(tabla,campo,2,true);
        combo_codigo_producto.removeAllItems();
        for(int i=0;i<tipo.length;i++)
        {
            System.out.println(tipo[i]);
            combo_codigo_producto.addItem(tipo[i]);
        } 
}


public void comboProveedor()
{
        String tabla,campo;
        tabla="Proveedores";
        campo="Empresa";
        Object[] tipo = sen.poblar_combox(tabla,campo,2,true);
        combo_proveedor_nuevo.removeAllItems();
        for(int i=0;i<tipo.length;i++)
        {
            combo_proveedor_nuevo.addItem(tipo[i]);
        }  
}

public void datosPuestos()
{
    int ini_codigo=0;
    int fin_codigo=0;
    
    ini_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf('(') + 1;
    fin_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf(')');
    String codigoProducto = combo_codigo_producto.getSelectedItem().toString().substring(ini_codigo, fin_codigo);
    
    Object[][] datos = control.datos_producto(codigoProducto);
    descripcion_antigua.setText(datos[0][0].toString());
    presentacion_antigua.setText(datos[0][1].toString());
    proveedor_antiguo.setText(datos[0][2].toString());
    existencias_antigua.setText(datos[0][3].toString());
    precio_compra_antiguo.setText(datos[0][4].toString());
    precio_venta_antiguo.setText(datos[0][5].toString());
    
    descripcion_nueva.setText(datos[0][0].toString());
    presentacion_nueva.setText(datos[0][1].toString());
    combo_proveedor_nuevo.getModel().setSelectedItem(datos[0][2]);
    existencias_nueva.setText(datos[0][3].toString());
    precio_compra_nuevo.setText(datos[0][4].toString());
    precio_venta_nuevo.setText(datos[0][5].toString());
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_codigo_producto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        descripcion_antigua = new javax.swing.JTextField();
        presentacion_antigua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        precio_venta_antiguo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        existencias_antigua = new javax.swing.JTextField();
        precio_compra_antiguo = new javax.swing.JTextField();
        descripcion_nueva = new javax.swing.JTextField();
        presentacion_nueva = new javax.swing.JTextField();
        combo_proveedor_nuevo = new javax.swing.JComboBox();
        existencias_nueva = new javax.swing.JTextField();
        precio_compra_nuevo = new javax.swing.JTextField();
        precio_venta_nuevo = new javax.swing.JTextField();
        proveedor_antiguo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar stock");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo_codigo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_codigo_productoActionPerformed(evt);
            }
        });
        getContentPane().add(combo_codigo_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 11, 341, -1));

        jLabel1.setText("Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));
        getContentPane().add(descripcion_antigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 72, 348, 38));
        getContentPane().add(presentacion_antigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 121, 348, 35));

        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        jLabel3.setText("Presentacion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 341, 126, 33));

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 341, 127, 33));

        jLabel4.setText("Existencias");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 109, -1));
        getContentPane().add(precio_venta_antiguo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 301, 151, 34));

        jLabel5.setText("Proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, 109, -1));

        jLabel6.setText("Precio Unitario Compra");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 256, 151, -1));

        jLabel7.setText("Precio Unitario Venta");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 301, 151, -1));
        getContentPane().add(existencias_antigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 211, 151, 34));
        getContentPane().add(precio_compra_antiguo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 256, 151, 34));
        getContentPane().add(descripcion_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 72, 309, 38));
        getContentPane().add(presentacion_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 121, 309, 35));

        getContentPane().add(combo_proveedor_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 167, 309, -1));
        getContentPane().add(existencias_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 211, 151, 34));
        getContentPane().add(precio_compra_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 256, 151, 34));
        getContentPane().add(precio_venta_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 301, 151, 34));
        getContentPane().add(proveedor_antiguo, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 167, 348, 38));

        jLabel8.setText("Actual");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 45, -1, -1));

        jLabel9.setText("Nuevo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 45, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_codigo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_codigo_productoActionPerformed
        if(combo_codigo_producto.getSelectedItem()!=null )
        {
            datosPuestos();
        } 
    }//GEN-LAST:event_combo_codigo_productoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
            String codigo,descripcion,presentacion,empresa,existencias,precio_compra,precio_venta;          
            int ini_codigo=0;
            int fin_codigo=0;
    
            ini_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf('(') + 1;
            fin_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf(')');            
            codigo=combo_codigo_producto.getSelectedItem().toString().substring(ini_codigo, fin_codigo);
            descripcion=descripcion_nueva.getText();
            presentacion=presentacion_nueva.getText();
            ini_codigo = combo_proveedor_nuevo.getSelectedItem().toString().indexOf('(') + 1;
            fin_codigo = combo_proveedor_nuevo.getSelectedItem().toString().indexOf(')');
            empresa=combo_proveedor_nuevo.getSelectedItem().toString().substring(ini_codigo, fin_codigo);
            existencias=existencias_nueva.getText();
            precio_compra=precio_compra_nuevo.getText();
            precio_venta=precio_venta_nuevo.getText();
            

            if( control.actualizar_productos(codigo,descripcion,presentacion,empresa,existencias,precio_compra,precio_venta))
            {
                JOptionPane.showMessageDialog(this, "Se actualizo correctamente el stock");
                descripcion_nueva.setText("");
                presentacion_nueva.setText("");
                existencias_nueva.setText("");
                precio_compra_nuevo.setText("");
                precio_venta_nuevo.setText("");
                comboCodigoProducto();
                datosPuestos();                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
        
    }//GEN-LAST:event_botonActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JComboBox combo_codigo_producto;
    private javax.swing.JComboBox combo_proveedor_nuevo;
    private javax.swing.JTextField descripcion_antigua;
    private javax.swing.JTextField descripcion_nueva;
    private javax.swing.JTextField existencias_antigua;
    private javax.swing.JTextField existencias_nueva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField precio_compra_antiguo;
    private javax.swing.JTextField precio_compra_nuevo;
    private javax.swing.JTextField precio_venta_antiguo;
    private javax.swing.JTextField precio_venta_nuevo;
    private javax.swing.JTextField presentacion_antigua;
    private javax.swing.JTextField presentacion_nueva;
    private javax.swing.JTextField proveedor_antiguo;
    // End of variables declaration//GEN-END:variables
}
