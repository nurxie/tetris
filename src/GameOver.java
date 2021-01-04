import java.awt.*;

public class GameOver {
    Color color = Color.BLACK;
    public void draw(Graphics g) {
        if (color == color.red) {
            int fontSize = 50;
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
            g.setColor(color);
            g.drawString("GAMEOVER!", 70, 230);
        }
    }

    public void setColor(int color) {
        switch (color) {
            case 1:
                this.color = Color.RED;
                break;
            case 2:
                this.color = Color.BLACK;
                break;
        }
    }
}
