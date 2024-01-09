package Commands;
import Pieces.TetrisPiece;

public class MoveLeftCommand implements TetrisCommand {
    private TetrisPiece tetrisPiece;
    public MoveLeftCommand(TetrisPiece tetrisPiece) {
        this.tetrisPiece = tetrisPiece;
    }

    @Override
    public void execute() {
        tetrisPiece.moveLeft();
    }
}