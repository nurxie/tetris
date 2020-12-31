import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;

public class Game extends JFrame  {
    int xDefine;  //width
    int yDefine;  //height
    int pixDem = 16;
    int yField = 16;
    int xField = 16;
    int delay;
    char FILLED = '#';
    char UNFILLED = '*';

    Pix[][] pix = new Pix[yField][xField];

    public void createFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Tetris");
        setSize(xDefine, yDefine);
        setResizable(false);
        setVisible(true);
        initPix();
        repaint();
    }
    private void initPix(){
        for (int y = 0; y < yField; y++){
            for (int x = 0; x < xField; x++){
                pix[y][x] = new Pix();
                pix[y][x].setxCenter(60 + x*2*pixDem + x);
                pix[y][x].setyCenter(80 + y*2*pixDem + y);
                pix[y][x].setPixDem(pixDem);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                pix[y][x].draw(g);
            }
        }
    }

    public void setxDefine(int xDefine) { this.xDefine = xDefine; }
    public void setyDefine(int yDefine) { this.yDefine = yDefine; }
    public void setPixDem(int pixDem) { this.pixDem = pixDem; }
    public void setyField(int yField) { this.yField = yField; }
    public void setxField(int xField) { this.xField = xField; }
    public void setDelay(int delay) { this.delay = delay; }

}
