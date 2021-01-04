import java.awt.*;

public class GameOver {
    public void draw(Graphics g) {
        int fontSize = 20;
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
        g.setColor(Color.RED);
        g.drawString("GAMEOVER!", 400, 230);
    }
}
