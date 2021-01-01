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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
    final Random random = new Random();
    int xDefine;  //width
    int yDefine;  //height
    int pixDem = 16;
    int yField = 16;
    int xField = 16;
    int delay;
    int UNFILLED = 0;

    Pix[][] pix = new Pix[yField][xField];
    Cadre cadre = new Cadre();
    int[][] mainLayer = new int[yField][xField];
    int[][] figuresLayer = new int[yField][xField];
    int[][] duplicate = new int[yField][xField];

    int generatedColor = 3;
    int generatedFigure = 3;
    int xSpawn = 4;
    int ySpawn = 0;

    public void createFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Tetris");
        setSize(xDefine, yDefine);
        setResizable(false);
        setVisible(true);
    }

    private void pixInit() {
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                pix[y][x] = new Pix();
                pix[y][x].setxCenter(57 + x * 2 * pixDem + x);
                pix[y][x].setyCenter(72 + y * 2 * pixDem + y);
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
            cadre.draw(g);
    }

    void coutArea() {
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                //pix[y][x].setColor(3); //test the drawer
                if (figuresLayer[y][x] != 0) {
                    pix[y][x].setColor(figuresLayer[y][x]);
                }
                System.out.print(figuresLayer[y][x]);
                //if(x == 2) pix[y][x].setColor(3); //test the drawer
            }
            System.out.println();
        }
        System.out.println("=====================");
    }

    void arrayInit() {
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                mainLayer[y][x] = 0;
            }
        }
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                figuresLayer[y][x] = 0;
            }
        }
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                duplicate[y][x] = 0;
            }
        }
    }

    void drawFigure(int generatedColor, int typeOfFigure, int xSpawn, int ySpawn) {
        switch (typeOfFigure) {
            case 1:  //stick
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 3][xSpawn] = generatedColor;
                break;

            case 2: //hook
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn + 1] = generatedColor;
                break;

            case 3:  //bench
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn + 1] = generatedColor;
                break;

            case 4:  //box
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                break;

            case 5: //bridge
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 2] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 2] = generatedColor;
                break;

            case 6: //bird
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
        }
    }

    boolean gravitation() {
        for (int y = yField; y >= 0; y--) {
            for (int x = 0; x < xField; x++) {
                if (figuresLayer[y][x] != UNFILLED) {
                    if (mainLayer[y][x] == UNFILLED) {
                        if (figuresLayer[y][x] != 0 && y == yField - 1) return false;
                        figuresLayer[y + 1][x] = figuresLayer[y][x];
                        figuresLayer[y][x] = UNFILLED;
                    }
                }
            }
        }
        return true;
    }

    boolean moveLeft() {
        int value = 0;
        for (int y1 = 0; y1 < yField; y1++) {
            value = value + figuresLayer[y1][0];
            System.out.println(value);
            if (value != 0) {
                return false;
            }
        }
        for (int x = 1; x < xField; x++) {
            for (int y = 0; y < yField; y++) {
                figuresLayer[y][x - 1] = figuresLayer[y][x];
            }
        }
        for (int i = yField; i > 0; i--) {
            figuresLayer[i][xField - 1] = 0;
        }
        return true;
    }

    boolean moveRight() {
        int value = 0;
        for (int y1 = 0; y1 < yField; y1++) {
            value = value + figuresLayer[y1][xField - 1];
            if (value != 0) {
                return false;
            }
        }
        for (int x = xField; x >= 0; x--) {
            for (int y = 0; y < yField; y++) {
                figuresLayer[y][x + 1] = figuresLayer[y][x];

            }
        }
        for (int i = yField; i > 0; i--) {
            figuresLayer[i][0] = 0;
        }
        return true;
    }

    boolean rollFigure(){
        int c = 0;
        int[][] figure = {    {0, 0, 0, 0},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0} };

        int[][] dupFigure = {     {0, 0, 0, 0},
                                  {0, 0, 0, 0},
                                  {0, 0, 0, 0},
                                  {0, 0, 0, 0} };
        int xCut = 0;
        int yCut = 0;
        for (int y = 0; y < yField; y++) {  //cut fragment with figure
            for (int x = 0; x < xField; x++) {
                if (figuresLayer[y][x] != 0 && c == 0) {
                    c++;
                    for (int y1 = 0; y1 < 4; y1++) {
                        for (int x1 = 0; x1 < 4; x1++) {
                            figure[y1][x1] = figuresLayer[y + y1][x + x1];
                        }
                    }
                    xCut = x;
                    yCut = y;
                    break;
                }
            }
        }
        for(int y = 0; y < yField; y++){ //clear figureLayer
            for(int x = 0; x < xField; x++){
                figuresLayer[y][x] = 0;
            }
        }

        for (int y = 0; y < 4; y++) {  //roll the figure
            for (int x = 0; x < 4; x++) {
                dupFigure[x][y] = figure[y][x];
            }
        }

        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                System.out.print(dupFigure[y][x]);
            }
            System.out.println();
        }

        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                figuresLayer[yCut + y][xCut + x] = dupFigure[y][x];
            }
        }

        return false;
    }

    public void startGame() {
        generatedColor = random.nextInt(9) + 1;
        generatedFigure = random.nextInt(6) + 1;
        arrayInit();
        pixInit();
        coutArea();
        repaint();
        System.out.println(generatedColor);
        System.out.println(generatedFigure);
        System.out.println(xSpawn);
        System.out.println(ySpawn);
        drawFigure(generatedColor, 1, xSpawn, ySpawn);
        pixInit();
        coutArea();
        repaint();
        waiting();
        gravitation();
        pixInit();
        coutArea();
        repaint();
        while (true) {
            gravitation();
            pixInit();
            coutArea();
            repaint();
            waiting();
        }
    }

    public void waiting() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setxDefine(int xDefine) { this.xDefine = xDefine; }
    public void setyDefine(int yDefine) { this.yDefine = yDefine; }
    public void setPixDem(int pixDem) { this.pixDem = pixDem; }
    public void setyField(int yField) { this.yField = yField; }
    public void setxField(int xField) { this.xField = xField; }
    public void setUNFILLED(int UNFILLED) { this.UNFILLED = UNFILLED; }
    public void setDelay(int delay) { this.delay = delay; }

    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
            if (KeyEvent.getKeyText(e.getKeyCode()) == "Left") {
                moveLeft();
            }
            if (KeyEvent.getKeyText(e.getKeyCode()) == "Right") {
                moveRight();
            }
            if(KeyEvent.getKeyText(e.getKeyCode()) == "Up") {
                rollFigure();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
