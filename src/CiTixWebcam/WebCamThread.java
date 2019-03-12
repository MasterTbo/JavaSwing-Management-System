package CiTixWebcam;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
/**
 *
 * @author matje
 */
class WebCamThread implements Runnable {
    protected volatile boolean runnable = false;
    VideoCapture webCam;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    //Object obj = new Object();
    Graphics obj;

    @Override
    public void run(){
        webCam = new VideoCapture(0);
        synchronized(this){
            while(runnable){
                if(webCam.grab()){
                    try {
                        webCam.retrieve(frame);
                        Image img = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                        BufferedImage imgBuff = (BufferedImage)img;
//                        Graphics imgGrp = obj.getGraphics();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }       
}
