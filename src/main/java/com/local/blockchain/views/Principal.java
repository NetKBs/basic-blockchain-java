
package com.local.blockchain.views;

import com.local.blockchain.Nodo;
import com.local.blockchain.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Principal extends javax.swing.JFrame {

    Sistema sistema;
    
    public Principal() {
        this.sistema = Sistema.getInstancia();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelDeNodos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        crearNodo = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        panelDeNodos.setBackground(new java.awt.Color(204, 204, 204));
        panelDeNodos.setLayout(new java.awt.GridLayout(0, 6));
        jScrollPane1.setViewportView(panelDeNodos);

        jLabel1.setFont(new java.awt.Font("Noto Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("RED DE NODOS");

        crearNodo.setBackground(new java.awt.Color(0, 255, 255));
        crearNodo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crearNodo.setForeground(new java.awt.Color(0, 0, 0));
        crearNodo.setText("CREAR NODO");
        crearNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearNodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(crearNodo))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(crearNodo)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearNodoActionPerformed
        Nodo nodo = sistema.crearNodo();
        JButton botonNodo = new JButton("nodo "+Nodo.getId());
        panelDeNodos.add(botonNodo);
        panelDeNodos.revalidate();
        panelDeNodos.repaint();
    }//GEN-LAST:event_crearNodoActionPerformed


    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton crearNodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDeNodos;
    // End of variables declaration//GEN-END:variables
}
