import java.awt.*;

public class Score {
    private int score = 0;
    public void draw(Graphics g) {
        int fontSize = 20;
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + String.valueOf(score), 520, 230);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
