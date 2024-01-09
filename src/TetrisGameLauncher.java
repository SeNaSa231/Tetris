public class TetrisGameLauncher {

    public static void main(String[] args) {
        TetrisBoard tetrisBoard = TetrisBoard.getInstance();
        tetrisBoard.playGame();
    }
}