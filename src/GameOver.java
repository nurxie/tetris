import java.awt.*;

public class GameOver {
    private int score = 0;
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Score: " + String.valueOf(score), 20, 50);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
