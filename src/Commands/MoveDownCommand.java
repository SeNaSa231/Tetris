package Commands;
import Pieces.TetrisPiece;

public class MoveDownCommand implements TetrisCommand {
    private TetrisPiece tetrisPiece;
    public MoveDownCommand(TetrisPiece tetrisPiece) { this.tetrisPiece = tetrisPiece; }

    @Override
    public void execute() {
        tetrisPiece.moveDown();
    }
}