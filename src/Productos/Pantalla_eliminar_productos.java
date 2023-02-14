/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import SQL.Sentencias_sql;
import javax.swing.JOptionPane;


public class Pantalla_eliminar_productos extends javax.swing.JFrame {
     Sentencias_sql sen = new Sentencias_sql();
     ControlProductos control = new ControlProductos();
    /**
     * Creates new form NewJFrame
     */
    public Pantalla_eliminar_productos() 
    {
        initComponents();
        descripcion_producto.setEnabled(false);
        presentacion_producto.setEnabled(false);
        llenadoCombo();
        setBounds(100,100,500,260);
        setResizable(false);
        setVisible(true);
    }

        public void llenadoCombo()
        {
            String tabla,campo;
            tabla="Productos";
            campo="Descripcion";
            Object[] tipo = sen.poblar_combox(tabla,campo,2,true);
            combo_codigo_producto.removeAllItems();
            for(int i=0;i<tipo.length;i++)
            {
                combo_codigo_producto.addItem(tipo[i]);
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
    
            descripcion_producto.setText(datos[0][0].toString());
            presentacion_producto.setText(datos[0][1].toString());  
        } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_codigo_producto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        descripcion_producto = new javax.swing.JTextField();
        presentacion_producto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar articulo");
        setUndecorated(true);

        combo_codigo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_codigo_productoActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Presentacion");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(85, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descripcion_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(presentacion_producto))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presentacion_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_codigo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_codigo_productoActionPerformed
        if(combo_codigo_producto.getSelectedItem()!=null)
        {
            datosPuestos();
        }
    }//GEN-LAST:event_combo_codigo_productoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String codigo;
        int ini_codigo=0;
        int fin_codigo=0;
    
        ini_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf('(') + 1;
        fin_codigo = combo_codigo_producto.getSelectedItem().toString().indexOf(')');
        codigo = combo_codigo_producto.getSelectedItem().toString().substring(ini_codigo, fin_codigo);
            
        if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea dar de baja el producto?") == JOptionPane.YES_OPTION) {
            control.eliminarProducto(codigo);
            JOptionPane.showMessageDialog(this, "El producto se dio de baja");
            llenadoCombo();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JComboBox combo_codigo_producto;
    private javax.swing.JTextField descripcion_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField presentacion_producto;
    // End of variables declaration//GEN-END:variables
}
