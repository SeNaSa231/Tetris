package Pieces;

public class LShape extends TetrisPiece {
    public LShape(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 1}}, x, y, borderRangeX, borderRangeY);
    }

    @Override
    public void rotate() {
        System.out.println("L-shape: Rotating");

        // Example of a simple rotation logic for demonstration
        if (currentRotation == 0) {
            coordinates = new int[][]{{0, 0, 0}, {1, 1, 1}, {1, 0, 0}};
            currentRotation = 1;
        } else if (currentRotation == 1) {
            coordinates = new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
            currentRotation = 2;
        } else if (currentRotation == 2) {
            coordinates = new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
            currentRotation = 3;
        } else if (currentRotation == 3) {
            coordinates = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 1}};
            currentRotation = 0;
        }
    }

    @Override
    public void displayCoordinates() {
        System.out.println("L-shape Coordinates: " + "(" + x + ", " + y + ")");
    }
}