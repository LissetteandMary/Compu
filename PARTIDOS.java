/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonatof;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PARTIDOS extends javax.swing.JFrame {

    /**
     * Creates new form PARTIDOS
     */
    static Connection cn;
    static Statement st;
    static ResultSet rs;
    int cantidadColumnas;
    int cantidadFilas;
    //Variables
    int contadorDeRegistros = 0;
    int ubicacionDeRegistro = 0;
    int buscador = 0;
    boolean enter = false;
    boolean CODencontrado = false;
    int num[] = new int[25];
    float valor[] = new float[25];
    String fecha[] = new String[25];
    String estadio[] = new String[25];
    String cod1[] = new String[25];
    String cod2[] = new String[25];

    public PARTIDOS() {
        initComponents();
        this.setLocationRelativeTo(null);
        jDesktopPane1.setBorder(new ImagenFondo("partidos"));
        prin();

    }

    public void prin() {
        consultaDeTabla();
        btnPriActionPerformed(null);
    }

    public void mostrarDatos(int i) {
        TXTNP.setText(String.valueOf(num[i]));
        TXTNP.setEnabled(false);
        txtEL.setText(String.valueOf(cod1[i]));
        txtEL.setEnabled(false);
        txtEV.setText(String.valueOf(cod2[i]));
        txtEV.setEnabled(false);
        txtF.setText(String.valueOf(fecha[i]));
        txtF.setEnabled(false);
        txtEs.setText(String.valueOf(estadio[i]));
        txtEs.setEnabled(false);
//            txtCod.requestFocus();
    }

    public void conectar() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            cn = DriverManager.getConnection(url, "CAMPEONATO", "CAMPEONATO");
            st = cn.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible conectarse \n");
        }
    }

    public void consultaDeTabla() {
        int x = 0;
        try {

            conectar();
            rs = st.executeQuery("SELECT count(*) FROM PARTIDOS");

            if (rs.next()) {

                cantidadFilas = rs.getInt("count(*)");
            } else {
                cantidadFilas = 0;
            }

            rs = st.executeQuery("SELECT * FROM PARTIDOS");
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();

            Object[] fila = new Object[cantidadColumnas];
            while (rs.next()) {

                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);

                }

                num[x] = Integer.valueOf(String.valueOf(fila[0]));
                fecha[x] = String.valueOf(fila[1]);
                estadio[x] = fila[2].toString();
                cod1[x] = fila[3].toString();
                cod2[x] = fila[4].toString();
                x++;

            }

            contadorDeRegistros = cantidadFilas;
            ubicacionDeRegistro = contadorDeRegistros;
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException | NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta \nError: " + ex);
        }
    }

    public int contar() {
        int x = 0;
        try {

            conectar();
            rs = st.executeQuery("SELECT count(*) FROM PARTIDOS");

            if (rs.next()) {

                cantidadFilas = rs.getInt("count(*)");
            } else {
                cantidadFilas = 0;
            }
            rs.close();
            st.close();
            cn.close();
            return cantidadFilas;
        } catch (SQLException | NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta \nError: " + ex);
        }
        return 0;
    }

    public void ingresoEnTabla() {
        try {
            conectar();
            String result = "INSERT INTO PARTIDOS VALUES(" + num[contadorDeRegistros]
                    + ",'" + fecha[contadorDeRegistros] + "','" + estadio[contadorDeRegistros] + "','"
                    + cod1[contadorDeRegistros] + "','" + cod2[contadorDeRegistros] + "')";
            st.execute(result);

            st.close();

            cn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error ingresando datos: " + ex);
//        cmdNuevoActionPerformed(null);
        }
    }

    public void ingresoDeDatos(int Num, String Fecha, String Estadio, String eq1, String eq2) {
        TXTNP.setForeground(Color.RED);
        if (contadorDeRegistros < 24) {
            num[contadorDeRegistros] = Num;
            fecha[contadorDeRegistros] = Fecha;
            estadio[contadorDeRegistros] = Estadio;
            cod1[contadorDeRegistros] = eq1;
            cod2[contadorDeRegistros] = eq2;
            ingresoEnTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos pero no puede ingresar mas datos.");
        }

    }

    public void limpiar() {
        TXTNP.setText("");
        TXTNP.requestFocus();
        txtEL.setText("");
        txtEV.setText("");
        txtEs.setText("");
        txtF.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TXTNP = new javax.swing.JTextField();
        txtEL = new javax.swing.JTextField();
        txtEV = new javax.swing.JTextField();
        txtF = new javax.swing.JTextField();
        txtEs = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnPri = new javax.swing.JButton();
        btnSig = new javax.swing.JButton();
        btnAnt = new javax.swing.JButton();
        btnUlt = new javax.swing.JButton();
        btnNue = new javax.swing.JButton();
        btnCanc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("N° PARTIDO :");

        jLabel2.setText("EQUIPO LOCAL :");

        jLabel3.setText("EQUIPO VISITANTE :");

        jLabel4.setText("FECHA :");

        jLabel5.setText("ESTADIO :");

        txtEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtELActionPerformed(evt);
            }
        });

        txtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TXTNP)
                    .addComponent(txtEL)
                    .addComponent(txtEV)
                    .addComponent(txtF)
                    .addComponent(txtEs, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPri.setText("PRIMERO");
        btnPri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriActionPerformed(evt);
            }
        });

        btnSig.setText("SIGUIENTE");
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });

        btnAnt.setText("ANTERIOR");
        btnAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntActionPerformed(evt);
            }
        });

        btnUlt.setText("ULTIMO");
        btnUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltActionPerformed(evt);
            }
        });

        btnNue.setText("NUEVO");
        btnNue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueActionPerformed(evt);
            }
        });

        btnCanc.setText("CANCELAR");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPri, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSig, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAnt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnUlt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnNue, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCanc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnPri)
                        .addGap(12, 12, 12)
                        .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUlt))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnNue, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardar)
                .addGap(27, 27, 27)
                .addComponent(btnCanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPri)
                    .addComponent(btnSig)
                    .addComponent(btnAnt)
                    .addComponent(btnUlt))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNue)
                    .addComponent(btnCanc)
                    .addComponent(jButton1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtELActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtELActionPerformed

    private void txtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            if (CODencontrado == false) {
                ingresoDeDatos(Integer.valueOf(TXTNP.getText()), txtF.getText(), txtEs.getText(), txtEL.getText(), txtEV.getText());
                JOptionPane.showMessageDialog(null, "Dato guardado");
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            JOptionPane.showMessageDialog(null, "Error Guardando los datos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltActionPerformed
        // TODO add your handling code here:
        if (ubicacionDeRegistro < (contadorDeRegistros - 1)) {
            ubicacionDeRegistro = contadorDeRegistros - 1;
            mostrarDatos(ubicacionDeRegistro);
            TXTNP.setText("" + (ubicacionDeRegistro + 1));
        } else {
            JOptionPane.showMessageDialog(null, "Usted ya se encuentra en el último dato");
            TXTNP.requestFocus();
        }
    }//GEN-LAST:event_btnUltActionPerformed

    private void btnPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriActionPerformed
        // TODO add your handling code here:
        if (ubicacionDeRegistro != 0) {
            ubicacionDeRegistro = 0;
            mostrarDatos(ubicacionDeRegistro);
            TXTNP.setText("" + (ubicacionDeRegistro + 1));
        } else {
            JOptionPane.showMessageDialog(null, "Usted ya se encuentra en el primer dato");
            //            txtCod.requestFocus();
        }
    }//GEN-LAST:event_btnPriActionPerformed

    private void btnAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntActionPerformed
        // TODO add your handling code here:
        if (ubicacionDeRegistro != 0) {
            ubicacionDeRegistro--;
            mostrarDatos(ubicacionDeRegistro);
            TXTNP.setText("" + (ubicacionDeRegistro + 1));
        } else {
            JOptionPane.showMessageDialog(null, "Usted ya se encuentra en el primer dato");
            TXTNP.requestFocus();
        }
    }//GEN-LAST:event_btnAntActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        // TODO add your handling code here:
        if (contadorDeRegistros != 0) {
            if (ubicacionDeRegistro < (contadorDeRegistros - 1)) {
                ubicacionDeRegistro++;
                mostrarDatos(ubicacionDeRegistro);
                TXTNP.setText("" + (ubicacionDeRegistro + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Usted ya se encuentra en el último dato");
                TXTNP.requestFocus();
            }
        }
    }//GEN-LAST:event_btnSigActionPerformed

    private void btnNueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueActionPerformed
        // TODO add your handling code here:
        btnNue.setEnabled(false);
        limpiar();
        TXTNP.setEnabled(false);
        TXTNP.setText(String.valueOf(contadorDeRegistros+1));
        txtEL.setEnabled(true);
        txtEL.requestFocus();
        txtEV.setEnabled(true);
        txtEs.setEnabled(true);
        txtF.setEnabled(true);
        btnPri.setEnabled(false);
        btnAnt.setEnabled(false);
        btnSig.setEnabled(false);
        btnUlt.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCanc.setEnabled(true);

    }//GEN-LAST:event_btnNueActionPerformed

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        // TODO add your handling code here:
        limpiar();
        //         lblNRegistro.setText(""+(contadorDeRegistros));
        consultaDeTabla();
        btnGuardar.setEnabled(false);
        btnCanc.setEnabled(false);
        btnPriActionPerformed(null);
        btnPri.setEnabled(true);
        btnAnt.setEnabled(true);
        btnSig.setEnabled(true);
        btnUlt.setEnabled(true);
        btnNue.setEnabled(true);
    }//GEN-LAST:event_btnCancActionPerformed
    public void Salir() {
        int opcion = JOptionPane.showConfirmDialog(null, "Seguro quiere salir ?");
        if (opcion == 0) {
            this.dispose();
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Salir();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PARTIDOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PARTIDOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PARTIDOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PARTIDOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PARTIDOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTNP;
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNue;
    private javax.swing.JButton btnPri;
    private javax.swing.JButton btnSig;
    private javax.swing.JButton btnUlt;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEL;
    private javax.swing.JTextField txtEV;
    private javax.swing.JTextField txtEs;
    private javax.swing.JTextField txtF;
    // End of variables declaration//GEN-END:variables
}
