package Commands;
import Pieces.TetrisPiece;

public class RotateCommand implements TetrisCommand {
    private TetrisPiece tetrisPiece;
    public RotateCommand(TetrisPiece tetrisPiece) {
        this.tetrisPiece = tetrisPiece;
    }

    @Override
    public void execute() {
        tetrisPiece.rotate();
    }
}