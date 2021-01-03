import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JFrame {
    final Random random = new Random();
    int xDefine;  //width
    int yDefine;  //height
    int pixDem = 16;
    int yField = 30;
    int xField = 30;
    int delay;
    int UNFILLED = 0;
    boolean sandMode = false;

    Pix[][] pix = new Pix[yField][xField];
    Cadre cadre = new Cadre();
    Score score = new Score();
    FigureMonitor figureMonitor = new FigureMonitor();
    NewGameButton newGameButton = new NewGameButton();
    int[][] mainLayer = new int[yField][xField];
    int[][] figuresLayer = new int[yField][xField];
    int[][] pastView = new int[yField][xField];

    int generatedColor = 3;
    int generatedFigure = 3;
    int xSpawn = 5;
    int ySpawn = 0;

    boolean itsBeDescent = false;
    int scoreCountner = 0;

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
        score.draw(g);
        figureMonitor.draw(g);
        newGameButton.draw(g);
    }

    void coutArea() {
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                //pix[y][x].setColor(3); //test the drawer
                if (mainLayer[y][x] != 0) { //!
                    pix[y][x].setColor(mainLayer[y][x]);
                } else {
                    pix[y][x].setColor(figuresLayer[y][x]);
                }
                System.out.print(mainLayer[y][x]);
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
                pastView[y][x] = 0;
            }
        }
    }

    void drawFigure(int generatedColor, int typeOfFigure, int xSpawn, int ySpawn) {
        switch (typeOfFigure) {
            case 1:  //HERO (I)
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 3][xSpawn] = generatedColor;
                break;

            case 2: //L
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn + 1] = generatedColor;
                break;

            case 3: //J
                figuresLayer[ySpawn][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                break;

            case 4:  //S
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn + 1] = generatedColor;
                break;

            case 5:  //Z
                figuresLayer[ySpawn][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn+1][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 2][xSpawn] = generatedColor;
                break;

            case 6:  //O
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                break;

            case 7: //bridge
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 2] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn + 2] = generatedColor;
                break;

            case 8: //bird
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                break;

            case 9: //birdOPPOSITE
                figuresLayer[ySpawn][xSpawn] = generatedColor;
                figuresLayer[ySpawn + 1][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn][xSpawn + 1] = generatedColor;
                break;

            case 10: //T
                figuresLayer[ySpawn][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn+1][xSpawn+1] = generatedColor;
                figuresLayer[ySpawn+1][xSpawn+2] = generatedColor;
                figuresLayer[ySpawn+1][xSpawn] = generatedColor;

                break;

        }
    }

    boolean gravitation(int[][] figuresLayer, int[][] mainLayer) {
        boolean i = false;
        for (int y = yField; y >= 0; y--) {
            for (int x = 0; x < xField; x++) {
                if (figuresLayer[y][x] != UNFILLED) {
                    if (mainLayer[y+1][x] == UNFILLED) {
                        if (figuresLayer[y][x] != 0 && y == yField - 1) return false;
                        figuresLayer[y + 1][x] = figuresLayer[y][x];
                        figuresLayer[y][x] = UNFILLED;
                        i = true;
                    }
                }
            }
        }
        return i;
    }

    boolean emptinessChek(int[][] layer){
        boolean i = false;
        for (int y = yField-1; y > 0; y--) {
            for (int x = 0; x < xField; x++) {
                if(layer[y][x] == 0){
                    if(layer[y-1][x] != 0){
                        if (figuresLayer[y][x] != 0 && y == yField - 1) return false;
                        layer[y][x] = layer[y-1][x];
                        layer[y-1][x] = UNFILLED;
                        i = true;
                    }
                }
            }
        }
        return i;
    }

    boolean moveLeft() {
        int value = 0;
        for (int y1 = 0; y1 < yField; y1++) {
            value = value + figuresLayer[y1][0];
            if (value != 0) {
                return false;
            }
        }
        for (int x = 1; x < xField; x++) {
            for (int y = 0; y < yField; y++) {
                if(figuresLayer[y][x] != 0 && mainLayer[y][x-1] != 0) return false;
                if(figuresLayer[y][x] != 0 && mainLayer[y+1][x-1] != 0 ) return false;
                figuresLayer[y][x - 1] = figuresLayer[y][x];
                figuresLayer[y][x] = 0;
            }
        }
        for (int i = yField; i >= 0; i--) {
           figuresLayer[i][xField - 1] = 0;
        }
        gravitation(figuresLayer, mainLayer);
        return true;
    }

    boolean moveRight() {
        int value = 0;
        for (int y1 = 0; y1 < yField; y1++) { // walls checks
            value = value + figuresLayer[y1][xField - 1];
            if (value != 0) {
                return false;
            }
        }
        for (int x = xField-1; x >= 0; x--) {  //move right
            for (int y = 0; y < yField; y++) {
                //if(figuresLayer[y][x] != 0 && mainLayer[y][x-1] != 0) return false;
                if(figuresLayer[y][x] != 0 && mainLayer[y+1][x+1] != 0 ) return false;
                    figuresLayer[y][x + 1] = figuresLayer[y][x];
                    figuresLayer[y][x] = 0;
            }
        }
        for (int i = yField; i >= 0; i--) { //delete near wall
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
        for (int y = yField; y > 0; y--) {  //cut fragment with figure
            for (int x = 0; x < xField; x++) {
                if (figuresLayer[y][x] != 0 && c == 0) {
                    c++;
                    for (int y1 = 0; y1 < 4; y1++) {
                        for (int x1 = 0; x1 < 4; x1++) {
                            figure[y1][x1] = figuresLayer[y - y1][x + x1];
                        }
                    }
                    xCut = x;
                    yCut = y;
                    break;
                }
            }
        }

        for (int y = 0; y < 4; ++y) {
            for (int x = 0; x < 4; ++x) {
                System.out.print(figure[y][x]);
            }
            System.out.println();
        }

        if(xCut+4<=xField && yCut+4<=yField) { // possibility check
            for (int y = 0; y < yField; y++) { //clear figureLayer
                for (int x = 0; x < xField; x++) {
                    figuresLayer[y][x] = 0;
                }
            }

            for (int y = 0; y < 4; ++y) {  //roll the figure
                for (int x = 0; x < 4; ++x) {
                    dupFigure[x][y] = figure[y][x];
                }
            }

            for (int y = 0; y < 4; y++)
                for (int x = 0; x < 4; x++)
                    System.out.println(dupFigure[y][x]);

            for (int y = 0; y < 4; y++) { //paste
                for (int x = 0; x < 4; x++) {
                    figuresLayer[yCut + y][xCut + x] = dupFigure[y][x];
                }
            }
        }
        return false;
    }

    void sharpDescent(){
        while(true) {
            gravitation(figuresLayer, mainLayer);
            if (collisionChek()) {
                mergerLayers();
                break;
            }
            repaint();
        }
        itsBeDescent = true;
    }

    boolean collisionChek(){
        for (int y = yField; y >= 0; y--) {
            for (int x = xField; x >= 0; x--) {
                if(figuresLayer[y][x] != 0) {
                    if (y + 2 <= yField) {
                        System.out.println("WOW YEAH!");
                        if (mainLayer[y + 1][x] != 0) {
                            return true;
                        }
                    }else if(y+2 >= yField){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void mergerLayers(){
        for (int y = yField; y >= 0; y--) {
            for (int x = xField; x >= 0; x--) {
                if(mainLayer[y][x] == 0) {
                    mainLayer[y][x] = figuresLayer[y][x];
                }
            }
        }
        for (int y = yField; y >= 0; y--) {
            for (int x = xField; x >= 0; x--) {
                figuresLayer[y][x] = 0;
            }
        }
    }

    boolean gameOverChek(){
        for(int x = 0; x < xField; x++){
            if(mainLayer[1][x] != 0){
                return true;
            }
        }
        return false;
    }

    boolean deletingARow() {
        int counter = 0;
        boolean ret = false;
        for (int y = 0; y < yField; y++) {
            for (int x = 0; x < xField; x++) {
                if (mainLayer[y][x] == 0) counter = 0;
                counter++;
                if (counter > xField) {
                    System.out.println("YESYESYESYESYESYESYESYESYESYESYESYESYESYESYESYESYESYESYES");
                    scoreCountner++;
                    score.setScore(scoreCountner);
                    for (int x1 = 0; x1 < xField; x1++) {
                        mainLayer[y][x1] = 0;
                    }
                    while(gravitation(mainLayer, mainLayer));
                    itsBeDescent = true;
                    ret = true;
                    while(emptinessChek(mainLayer));
                }
            }
        }
        return ret;
    }

    void figureMonitorInit(){
        figureMonitor.setPixDem(pixDem);
        figureMonitor.setxCenter(550);
        figureMonitor.setyCenter(100);
        figureMonitor.setCadre(true);
    }

    boolean genFig = true;
    public void startGame() {
        xSpawn = Math.round(xField/2);
        generatedColor = random.nextInt(9) + 1;
        generatedFigure = random.nextInt(6) + 1;
        arrayInit();
        pixInit();
        figureMonitorInit();
        coutArea();
        repaint();
        drawFigure(generatedColor, 1, xSpawn, ySpawn);
        coutArea();
        repaint();
        waiting();
        gravitation(figuresLayer, mainLayer);
        pixInit();
        coutArea();
        repaint();
        while (true) {
            boolean d = deletingARow();
            if(d){
                itsBeDescent = false;
            }
            if(genFig) {
                generatedColor = random.nextInt(9) + 1;
                generatedFigure = random.nextInt(6) + 1;
                figureMonitor.setTypeOfFigure(generatedFigure);
                figureMonitor.setColor(generatedColor);
                genFig = false;
            }
            gravitation(figuresLayer, mainLayer);
            pixInit();
            coutArea();
            repaint();
            waiting();
            boolean i = gameOverChek();
            if(i && !itsBeDescent){
                System.out.println("GAME OVER!");
                break;
            }
            i = collisionChek();
            System.out.println(i + " =colleseonchek");
            System.out.println(itsBeDescent + " =itsBeDescent");
            System.out.println(d + " =deletingARow");
            if((i || itsBeDescent && !d)){
                mergerLayers();
                genFig = true;
            }
            if((i || itsBeDescent && !d)){
                itsBeDescent = false;
                drawFigure(generatedColor, generatedFigure, xSpawn, ySpawn);
            }
            if(sandMode) {
                while (emptinessChek(mainLayer)) ;
            }
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
    public void setSandMode(boolean sandMode) { this.sandMode = sandMode; }

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
            if(KeyEvent.getKeyText(e.getKeyCode()) == "Down") {
                sharpDescent();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
