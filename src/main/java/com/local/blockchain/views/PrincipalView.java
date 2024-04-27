
package com.local.blockchain.views;

import com.local.blockchain.Nodo;
import com.local.blockchain.Minero;
import com.local.blockchain.Sistema;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrincipalView extends javax.swing.JFrame {

    private Sistema sistema;
    
    public PrincipalView() {
        sistema = Sistema.getInstancia();
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
        panelContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMinero = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        panelListaNodos = new javax.swing.JPanel();

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

        panelContenedor.setBackground(new java.awt.Color(255, 204, 51));
        panelContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Mono", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Elegir Tipo De Nodo");

        btnMinero.setBackground(new java.awt.Color(255, 153, 51));
        btnMinero.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMinero.setForeground(new java.awt.Color(0, 0, 0));
        btnMinero.setText("Minero");
        btnMinero.setBorderPainted(false);
        btnMinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMineroActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(255, 153, 51));
        btnCliente.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnCliente.setText("Cliente");
        btnCliente.setBorderPainted(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Simulador");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Blockchain");

        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setAutoscrolls(true);
        scrollPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                scrollPanelComponentShown(evt);
            }
        });

        panelListaNodos.setBackground(new java.awt.Color(255, 255, 255));
        panelListaNodos.setLayout(new javax.swing.BoxLayout(panelListaNodos, javax.swing.BoxLayout.Y_AXIS));
        scrollPanel.setViewportView(panelListaNodos);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMinero, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelContenedorLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel)
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinero, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMineroActionPerformed
        Nodo nodo = sistema.crearConectarNodoRed(true);
        agregarNodoLabel("Minero", nodo.getId());
    }//GEN-LAST:event_btnMineroActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        Nodo nodo = sistema.crearConectarNodoRed(false);
        agregarNodoLabel("Cliente", nodo.getId());
    }//GEN-LAST:event_btnClienteActionPerformed

    private void agregarNodoLabel(String tipo, int id) {
        JLabel label = new JLabel("Nodo #" + id + " ("+tipo+")");
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setFont(label.getFont().deriveFont(Font.PLAIN, label.getFont().getSize() + 5));
        
        label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
            JLabel clickedLabel = (JLabel) e.getSource(); 
            String labelText = clickedLabel.getText();
            Pattern pattern = Pattern.compile("Nodo #(\\d+)");
            Matcher matcher = pattern.matcher(labelText);
            
            if (matcher.find()) {
                int nodeId = Integer.parseInt(matcher.group(1)); // Obtener el número de ID del nodo
                cargarNodoVentana(nodeId);
            }
      
        }
    });
        
        panelListaNodos.add(label);
        panelListaNodos.revalidate();
        panelListaNodos.repaint();
    }
    
private void cargarNodoVentana(int id) {
     Nodo nodo = sistema.getNodoById(id);
    
    JFrame ventana; // Declarar la variable de la ventana aquí para poder acceder al WindowListener
    
    if (nodo instanceof Minero) {
        MineroView minero = new MineroView(nodo);
        ventana = minero; 
        minero.setVisible(true);
    } else {
        ClienteView cliente = new ClienteView(nodo);
        ventana = cliente; 
        cliente.setVisible(true);
    }
    
    // Agregar el WindowListener para detener el Timer al cerrar la ventana
    ventana.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            Object source = e.getSource();
            if (source instanceof ClienteView) {
                ((ClienteView) source).detenerTimer();
            } else {
                ((MineroView) source).detenerTimer();
            }
        }
    });
    
}

    
    private void scrollPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_scrollPanelComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollPanelComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnMinero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelListaNodos;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
