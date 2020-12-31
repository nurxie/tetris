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
    final Random random = new Random();
    int xDefine;  //width
    int yDefine;  //height
    int pixDem = 16;
    int yField = 16;
    int xField = 16;
    int delay;
    int UNFILLED = 0;

    Pix[][] pix = new Pix[yField+1][xField+1];
    int[][] area = new int[yField+1][xField+1];

    int generatedColor = 3;
    int generatedFigure = 3;
    int xSpawn = 4;
    int ySpawn = 0;

    public void createFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Tetris");
        setSize(xDefine, yDefine);
        setResizable(false);
        setVisible(true);
    }

    private void pixInit(){
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

    void coutArea(){
        for(int y = 0; y < yField; y++){
            for(int x = 0; x < xField; x++) {
                if (area[y][x] != 0) {
                    pix[y][x].setColor(area[y][x]);
                }
                System.out.print(area[y][x]);
                //if(x == 2) pix[y][x].setColor(3); //test the drawer
            }
            System.out.println();
        }
    }

    void arrayInit(){
        for(int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                area[y][x] = 0;
            }
        }
    }

    void drawFigure(int generatedColor, int typeOfFigure, int xSpawn, int ySpawn) {
        switch (typeOfFigure) {
            case 1:  //stick
                for (int y = ySpawn; y < ySpawn + 4; y++) {
                    area[y][xSpawn] = generatedColor;
                }
                break;
            case 2:
                for(int y = ySpawn; y < ySpawn + 4; y++){
                    if(y == ySpawn+3){
                        area[y-1][xSpawn+1] = generatedColor;
                        break;
                    }
                    area[y][xSpawn] = generatedColor;
                }
                break;
        }
    }

    public void startGame(){
        generatedColor = random.nextInt(9)+1;
        generatedFigure = random.nextInt(6)+1;
        arrayInit();
        pixInit();
        coutArea();
        repaint();
        System.out.println(generatedColor);
        System.out.println(generatedFigure);
        System.out.println(xSpawn);
        System.out.println(ySpawn);
        drawFigure(generatedColor, 2, xSpawn, ySpawn);
        pixInit();
        coutArea();
        repaint();
    }
    public void setxDefine(int xDefine) { this.xDefine = xDefine; }
    public void setyDefine(int yDefine) { this.yDefine = yDefine; }
    public void setPixDem(int pixDem) { this.pixDem = pixDem; }
    public void setyField(int yField) { this.yField = yField; }
    public void setxField(int xField) { this.xField = xField; }
    public void setUNFILLED(int UNFILLED) { this.UNFILLED = UNFILLED; }
    public void setDelay(int delay) { this.delay = delay; }
}
