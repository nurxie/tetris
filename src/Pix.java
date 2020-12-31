import java.awt.*;

public class Pix {
    private Color color = Color.BLACK;
    private int xCenter = 20;
    private int yCenter = 40;
    private int pixDem = 10;
    boolean isSelected = true;
    public void draw(Graphics g) {
        if (isSelected) {
            g.setColor(color);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
        }else{
            g.setColor(Color.BLACK);
            g.fillRect(xCenter - pixDem, yCenter - pixDem, 2 * pixDem, 2 * pixDem);
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

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
