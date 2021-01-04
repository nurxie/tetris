import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class NewGameButton extends JComponent{
    private int xCenter = 495;
    private int yCenter = 280;
    private int width = 125;
    private int height = 50;
    boolean buttonClick = false;
    boolean buttonMouse = false;

    public void draw(Graphics g) {
        if(!buttonClick && !buttonMouse) {
            Graphics2D g2 = (Graphics2D) g;
            Image img1 = Toolkit.getDefaultToolkit().getImage("src\\pictures\\button.png");
            g2.drawImage(img1, xCenter, yCenter, width, height, this);
        }else if(buttonClick){
            Graphics2D g2 = (Graphics2D) g;
            Image img1 = Toolkit.getDefaultToolkit().getImage("src\\pictures\\buttonClick.png");
            g2.drawImage(img1, xCenter, yCenter, width, height, this);
        }else if(buttonMouse){
            Graphics2D g2 = (Graphics2D) g;
            Image img1 = Toolkit.getDefaultToolkit().getImage("src\\pictures\\buttonMouse.png");
            g2.drawImage(img1, xCenter, yCenter, width, height, this);
        }
    }

    boolean mouseUnderMe(int yMouse, int xMouse){
        if((yMouse>yCenter && yMouse<yCenter+height)&&(xMouse>xMouse && xMouse<xMouse+width)){
           return true;
        }
        return false;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public void setButtonClick(boolean buttonClick) {
        this.buttonClick = buttonClick;
    }

    public void setButtonMouse(boolean buttonMouse) {
        this.buttonMouse = buttonMouse;
    }
}
