package com.local.blockchain.views;

import com.local.blockchain.Bloque;
import com.local.blockchain.Nodo;
import com.local.blockchain.Sistema;
import com.local.blockchain.Transaccion;
import com.local.exepciones.FirmaException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ClienteView extends javax.swing.JFrame {

    private Nodo nodo;
    private Timer timer;

    public ClienteView(Nodo nodo) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.nodo = nodo;

        setTitle("" + nodo.getId());
        cartera.setText(nodo.getDireccionCartera());

        buscarData();
    }

    public void detenerTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        btnConsultarCadena = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cartera = new javax.swing.JTextField();
        fondos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelHistorialTrans = new javax.swing.JPanel();
        btnTransaccion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        destinatario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContenedor.setBackground(new java.awt.Color(255, 204, 51));

        btnConsultarCadena.setBackground(new java.awt.Color(255, 153, 51));
        btnConsultarCadena.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnConsultarCadena.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultarCadena.setText("Consultar Cadena");
        btnConsultarCadena.setBorderPainted(false);
        btnConsultarCadena.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultarCadena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCadenaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fondos");

        cartera.setEditable(false);
        cartera.setBackground(new java.awt.Color(255, 204, 51));
        cartera.setForeground(new java.awt.Color(0, 0, 0));
        cartera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cartera.setText("Eg13Hr8Rqd17o4QggkwhRA39NNE9KGcKznSkc2X1SnFu");
        cartera.setBorder(null);

        fondos.setBackground(new java.awt.Color(250, 250, 250));
        fondos.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        fondos.setForeground(new java.awt.Color(0, 0, 0));
        fondos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondos.setText("0.00");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Historial de transacciones");

        PanelHistorialTrans.setBackground(new java.awt.Color(204, 204, 204));
        PanelHistorialTrans.setLayout(new javax.swing.BoxLayout(PanelHistorialTrans, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(PanelHistorialTrans);

        btnTransaccion.setBackground(new java.awt.Color(255, 153, 51));
        btnTransaccion.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnTransaccion.setForeground(new java.awt.Color(0, 0, 0));
        btnTransaccion.setText("Hacer Transaccion");
        btnTransaccion.setBorderPainted(false);
        btnTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cliente");

        monto.setBackground(new java.awt.Color(255, 255, 255));
        monto.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cartera del destinatario");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Monto");

        destinatario.setBackground(new java.awt.Color(255, 255, 255));
        destinatario.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fondos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2))))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel9))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnTransaccion))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 42, Short.MAX_VALUE))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(destinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartera, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnConsultarCadena)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(fondos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnConsultarCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarCadenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCadenaActionPerformed

        CadenaView cadenaV = new CadenaView(nodo.getCadena());
        cadenaV.setVisible(true);
    }//GEN-LAST:event_btnConsultarCadenaActionPerformed

    private void btnTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionActionPerformed

        String receptor = destinatario.getText();
        String cantidad = monto.getText();

        if (receptor.isEmpty() || cantidad.isEmpty()) {
            mensajeEmergente("Llene todos los campos");
            return;
        }
        try {
            float cantidadInt = Float.parseFloat(cantidad);
            String msg = Sistema.getInstancia().propagarTransaccion(nodo.crearTransaccion(receptor, cantidadInt));

            if (msg.isEmpty()) {
                mensajeEmergente("Transacción verificada y en proceso");
                return;
            }

            mensajeEmergente(msg);
        } catch (NumberFormatException ex) {
            mensajeEmergente("El monto debe ser numérico");
        } catch (FirmaException ex) {
        }
    }//GEN-LAST:event_btnTransaccionActionPerformed

    private void buscarData() {
        timer = new Timer();
        ArrayList<Transaccion> transPropias = new ArrayList<>();
        ArrayList<Transaccion> transAmi = new ArrayList<>();
        String carteraDir = cartera.getText();

        TimerTask task = new TimerTask() {
            public void run() {
                String head = nodo.getCadena().obtenerHeadMayor();
                Bloque bloque = nodo.getCadena().obtenerBloque(head);
                transPropias.clear();
                transAmi.clear();

                while (bloque != null) {
                    for (Transaccion transaccion : bloque.getTransacciones()) {
                        if (carteraDir.equals(transaccion.getEmisor())) {
                            transPropias.add(transaccion);
                        } else if (carteraDir.equals(transaccion.getReceptor())) {
                            transAmi.add(transaccion);
                        }
                    }

                    bloque = nodo.getCadena().obtenerBloque(bloque.getHashAnterior());
                }

                if (!transPropias.isEmpty() || !transAmi.isEmpty()) {
                    mostrarData(nodo.getFondos(), transPropias, transAmi);
                }

                System.out.println("Buscando data cliente: " + nodo.getId());
            }
        };
        timer.scheduleAtFixedRate(task, 0, 5000);
    }

    private void mostrarData(float fondosCantidad, ArrayList<Transaccion> transPropias, ArrayList<Transaccion> transAmi) {
        PanelHistorialTrans.removeAll();

        for (Transaccion trans : transPropias) {
            JLabel labelTrans = new JLabel(trans.getCantidad() + "$ -> " + trans.getReceptor());
            PanelHistorialTrans.add(labelTrans);
        }

        for (Transaccion trans : transAmi) {
            JLabel labelTrans = new JLabel(trans.getCantidad() + "$ <- " + trans.getReceptor());
            PanelHistorialTrans.add(labelTrans);
        }

        fondos.setText("" + fondosCantidad);
        fondos.revalidate();
        fondos.repaint();
        PanelHistorialTrans.revalidate();
        PanelHistorialTrans.repaint();

    }

    private void mensajeEmergente(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHistorialTrans;
    private javax.swing.JButton btnConsultarCadena;
    private javax.swing.JButton btnTransaccion;
    private javax.swing.JTextField cartera;
    private javax.swing.JTextField destinatario;
    private javax.swing.JLabel fondos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField monto;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
