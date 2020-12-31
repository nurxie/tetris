public class MainClass {
    Game game = new Game();

    final int xDefine = 700;  //width
    final int yDefine = 700;  //height
    final int pixDem = 20;
    final int yField = 15;
    final int xField = 9;
    final int delay = 1000; //ms
    final int UNFILLED = 0;

    public void initGame() {
        game.setxDefine(xDefine);
        game.setyDefine(yDefine);
        game.setPixDem(pixDem);
        game.setyField(yField);
        game.setxField(xField);
        game.setDelay(delay);
        game.setUNFILLED(UNFILLED);
        game.createFrame();
        game.startGame();
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.initGame();
    }
}
