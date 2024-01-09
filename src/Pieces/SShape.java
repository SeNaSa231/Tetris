package Pieces;

public class SShape extends TetrisPiece {
    public SShape(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}}, x, y, borderRangeX, borderRangeY);
    }

    @Override
    public void rotate() {
        System.out.println("S-shape: Rotating");

        // Example of a simple rotation logic for demonstration
        if (currentRotation == 0) {
            coordinates = new int[][]{{1, 0, 0}, {1, 1, 0}, {0, 1, 0}};
            currentRotation = 1;
        } else if (currentRotation == 1) {
            coordinates = new int[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}};
            currentRotation = 2;
        } else if (currentRotation == 2) {
            coordinates = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 0, 1}};
            currentRotation = 3;
        } else if (currentRotation == 3) {
            coordinates = new int[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}};
            currentRotation = 0;
        }
    }

    @Override
    public void displayCoordinates() {
        System.out.println("S-shape Coordinates: " + "(" + x + ", " + y + ")");
    }
}
