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
    private int xCenter = 20;
    private int yCenter = 40;
    boolean isSelected = true;
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Image img1 = Toolkit.getDefaultToolkit().getImage("src\\pictures\\button.png");
       // g2.drawImage(img1, 200, 200,this);
        g2.drawImage(img1, 495, 280, 125, 50, this);
        g2.finalize();
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
