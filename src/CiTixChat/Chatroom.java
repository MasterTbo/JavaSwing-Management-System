package CiTixChat;

import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * CiTix Programme Management System Application Client
 *
 * @author matjele7@gmail.com
 * @version 1.0
 */
public class Chatroom extends javax.swing.JFrame {

//    static Socket s;
//    static ServerSocket ss;
//    static DataInputStream din;
//    static DataOutputStream dout;

    /**
     * Creates new form Chatroom
     */
    public Chatroom() {
        initComponents();
        txtTypeMessage.grabFocus();
        this.setTitle("Client Machine");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatMessage = new javax.swing.JTextArea();
        txtTypeMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CiTix Chatroom Server");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtChatMessage.setEditable(false);
        txtChatMessage.setColumns(20);
        txtChatMessage.setRows(5);
        jScrollPane1.setViewportView(txtChatMessage);

        txtTypeMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeMessageActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTypeMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTypeMessage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void serverThread() throws IOException {
        
//        try {
//            //if(ss.isClosed()){
//                //ss.accept();
//                s = new Socket("localhost", 1201);
//                din = new DataInputStream(s.getInputStream());
//                dout = new DataOutputStream(s.getOutputStream());
//                String msgin = "";
//                while (!msgin.equals("exit")) {
//                    msgin = din.readUTF();
//                    txtChatMessage.append("\rServer: " + msgin + "\n");
//                }
//            //}else{
//              //  JOptionPane.showMessageDialog(null, "No connection to Server");
//            //}
//            
//        } catch (Exception e) {
//        }
    }

    public void sendMessage() {
        Chat ct = new Chat();
        ct.setTxtMessage(txtTypeMessage.getText());
        txtChatMessage.append(ct.getTxtMessage());
        
        
        
        
        
//        try {
//            String msgout = "";
//            msgout = txtTypeMessage.getText().trim();
//            dout.writeUTF(msgout);
//            txtChatMessage.append("\rClient: " + msgout + "\n");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
//        txtTypeMessage.setText("");
//        txtTypeMessage.requestFocus();
    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        sendMessage();
        txtTypeMessage.setText("");
        txtTypeMessage.requestFocus();
    }//GEN-LAST:event_btnSendActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void txtTypeMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeMessageActionPerformed
        sendMessage();
        txtTypeMessage.setText("");
        txtTypeMessage.requestFocus();

    }//GEN-LAST:event_txtTypeMessageActionPerformed

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
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chatroom().setVisible(true);
            }
        });
        try {
            serverThread();
        } catch (IOException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea txtChatMessage;
    private javax.swing.JTextField txtTypeMessage;
    // End of variables declaration//GEN-END:variables
}
