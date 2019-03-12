package CiTixChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *  Demonstrates a chat class
 * @author tbo
 */
public class Chat {
    
    static Socket s;
    static ServerSocket ss;
    static DataInputStream din;
    static DataOutputStream dout;
    
    private String txtMessage, txtChatMessage;
    public Chat(){
        
        try {
            //if(ss.isClosed()){
                //ss.accept();
                s = new Socket("localhost", 1201);
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                String msgin = "";
                while (!msgin.equals("exit")) {
                    msgin = din.readUTF();
                    this.txtMessage += ("\rServer: " + msgin + "\n");
                }
            //}else{
              //  JOptionPane.showMessageDialog(null, "No connection to Server");
            //}
            
        } catch (Exception e) {
        
        }
        
    }

    public String getTxtMessage() {
        return txtMessage;
    }

    public void setTxtMessage(String txtMessage) {
        this.txtMessage = txtMessage;
    }
    
    public void sendMessage(){
        try {
            String msgout = txtMessage.trim();
         //   msgout = txtMessage.trim();
        //    getTxtMessage();
            dout.writeUTF(msgout);
            txtChatMessage += ("\rClient: " + msgout + "\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
}
