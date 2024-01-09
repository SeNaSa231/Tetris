package Pieces;

public class Square extends TetrisPiece {
    public Square(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{1, 1}, {1, 1}}, x, y, borderRangeX, borderRangeY);
    }

    @Override
    public void rotate() {
        System.out.println("Square: Cannot rotate (not applicable)");
    }

    @Override
    public void displayCoordinates() {
        System.out.println("Square Coordinates: " + "(" + x + ", " + y + ")");
    }
}