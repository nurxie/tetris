import java.awt.*;
public class FigureMonitor {
     Color color = Color.WHITE;
     int xCenter = 20;
     int yCenter = 40;
     int pixDem = 10;

    int typeOfFigure = 1;

    public void draw(Graphics g) {
    switch (typeOfFigure){
        case 1:
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 4 * pixDem + 4, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 6 * pixDem + 6, 2 * pixDem, 2 * pixDem);
            break;

        case 2:
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 4 * pixDem + 4, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem + 4 * pixDem + 4, 2 * pixDem, 2 * pixDem);
            break;

        case 3:
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem + 4 * pixDem + 4, 2 * pixDem, 2 * pixDem);
            break;

        case 4:
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            break;

        case 5:
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
            g.fillRect(xCenter - pixDem + 2 * pixDem + 2, yCenter - pixDem + 2 * pixDem + 2, 2 * pixDem, 2 * pixDem);
            break;
    }

    }

    public void setColor(int color) {
        switch (color){
            case 1:
                this.color = Color.red;
                break;
            case 2:
                this.color = Color.gray;
                break;
            case 3:
                this.color = Color.green;
                break;
            case 4:
                this.color = Color.magenta;
                break;
            case 5:
                this.color = Color.blue;
                break;
            case 6:
                this.color = Color.yellow;
                break;
            case 7:
                this.color = Color.cyan;
                break;
            case 8:
                this.color = Color.orange;
                break;
            case 9:
                this.color = Color.WHITE;
                break;
        }
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public void setPixDem(int pixDem) {
        this.pixDem = pixDem;
    }

    public void setTypeOfFigure(int typeOfFigure) {
        this.typeOfFigure = typeOfFigure;
    }
}
