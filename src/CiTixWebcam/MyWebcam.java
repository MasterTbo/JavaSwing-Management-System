package CiTixWebcam;

//imports
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

/**
 * CiTix Programme Management System Application
 *
 * @author matjele7@gmail.com
 * @version 1.3.1
 */
public class MyWebcam extends javax.swing.JFrame {

    //private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    /**
     * Creates new form Webcam
     */
    public MyWebcam() {
        initComponents();
//        this.frame = new Mat();
//        mem = new MatOfByte();
        //openWebCam();
    }

//    class DaemonThread implements Runnable {
//
//        protected volatile boolean runnable = false;
//
//        Mat frame = new Mat();
//        MatOfByte mem = new MatOfByte();
//
//        @Override
//        public void run() {
//            synchronized (this) {
//                while (runnable) {
//                    if (webSource.grab()) {
//                        try {
//                            webSource.retrieve(frame);
//                            HighGui.imshow("name", frame);
//                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
//
//                            BufferedImage buff = (BufferedImage) im;
//                            Graphics g = pnlWebcam.getGraphics();
//
//                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
//                                if (runnable == false) {
//                                    JOptionPane.showMessageDialog(null, "Going to wait()");
//                                    this.wait();
//                                }
//                            }
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(null, ex.getMessage());
//                        }
//                    }
//                }
//            }
//        }
//    }

    public void openWebCam() {
        Thread webCam = new Thread() {
            @Override
            public void run() {
                BufferedImage img;
                CvCapture capture = opencv_highgui.cvCreateCameraCapture(0);
                opencv_highgui.cvSetCaptureProperty(capture, opencv_highgui.CV_CAP_PROP_FRAME_HEIGHT, 720);
                opencv_highgui.cvSetCaptureProperty(capture, opencv_highgui.CV_CAP_PROP_FRAME_WIDTH, 1280);

                IplImage grabbedImage = opencv_highgui.cvQueryFrame(capture);
                CanvasFrame frame = new CanvasFrame("CiTix MyWebcam");
//                pnlWebcam = new JPanel();
//                pnlWebcam.imageUpdate(grabbedImage.getBufferedImage(), WIDTH, 0, 0, getWidth(), getHeight()-150);
//                pnlWebcam.getGraphics();
                //ImageObserver ob = new ImageObserver();
                //Graphics g = pnlWebcam.getGraphics();
                //g.drawImage(this.img, 10, 10, this.img.getWidth(), this.img.getHight(), null);

                if (frame.isVisible()) {
                    JOptionPane.showMessageDialog(null, "Connected");
                    while (frame.isVisible() && (grabbedImage = opencv_highgui.cvQueryFrame(capture)) != null) {
                        frame.showImage(grabbedImage);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Not Connected");
                }
            }

        };
        webCam.start();
//        webSource = new VideoCapture(0);
//        myThread = new DaemonThread();
//        Thread t = new Thread(myThread);
//        t.setDaemon(true);
//        myThread.runnable = true;
//        t.start();

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
        pnlWebcam = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnVideo = new javax.swing.JButton();
        btnImage = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CiTix Webcam");

        pnlWebcam.setBackground(new java.awt.Color(204, 255, 255));
        pnlWebcam.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlWebcamLayout = new javax.swing.GroupLayout(pnlWebcam);
        pnlWebcam.setLayout(pnlWebcamLayout);
        pnlWebcamLayout.setHorizontalGroup(
            pnlWebcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        pnlWebcamLayout.setVerticalGroup(
            pnlWebcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVideo.setText("Video record");

        btnImage.setText("Image Capture");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        btnSave.setText("Save");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(42, 42, 42)
                .addComponent(btnVideo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVideo)
                    .addComponent(btnImage)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWebcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        openWebCam();
//        MyWebcam w = MyWebcam.getDefault();
//
//        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
//        try{
//            grabber.start();
//            IplImage img = grabber.grab();
//            if(img != null){
//                cvSaveImage("webcam.png", img);
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }

//        IplImage img = cvLoadImage("‪C:\\Users\\matje\\OneDrive\\Pictures\\citix.png");
//        final CanvasFrame canvas = new CanvasFrame("Test JavaCV"); 
//        canvas.showImage(img);
//        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btnImageActionPerformed

    //Definition
//    private DaemonThread myThread = null;
//    int count = 0;
//    VideoCapture webCam = null;

//    static {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // load native library of opencv
        //System.load("C:\\opencv\\build\\java\\x64\\opencv_java341.dll");
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
            java.util.logging.Logger.getLogger(MyWebcam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyWebcam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyWebcam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyWebcam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyWebcam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVideo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlWebcam;
    // End of variables declaration//GEN-END:variables
}
