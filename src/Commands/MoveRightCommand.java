package Commands;
import Pieces.TetrisPiece;

public class MoveRightCommand implements TetrisCommand {
    private TetrisPiece tetrisPiece;
    public MoveRightCommand(TetrisPiece tetrisPiece) {
        this.tetrisPiece = tetrisPiece;
    }

    @Override
    public void execute() {
        tetrisPiece.moveRight();
    }
}