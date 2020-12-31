import java.awt.*;
public class Cadre {
    boolean isSelected = true;
    public void draw(Graphics g) {
        if (isSelected) {
            g.setColor(Color.CYAN);
            g.drawRect(20, 40, 400, 638);
        }else{
            g.setColor(Color.BLACK);
        }
    }
}
