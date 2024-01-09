package Pieces;

public class TShape extends TetrisPiece {
    private int currentRotation; // Keep track of the current rotation state

    public TShape(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 1, 0}}, x, y, borderRangeX, borderRangeY);
        currentRotation = 0; // Initialize rotation state
    }

    @Override
    public void rotate() {
        System.out.println("T-shape: Rotating");

        // Example of a simple rotation logic for demonstration
        if (currentRotation == 0) {
            coordinates = new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 1}};
            currentRotation = 1;
        } else if (currentRotation == 1) {
            coordinates = new int[][]{{0, 1, 0}, {0, 1, 0}, {1, 1, 1}};
            currentRotation = 2;
        } else if (currentRotation == 2) {
            coordinates = new int[][]{{1, 0, 0}, {1, 1, 1}, {1, 0, 0}};
            currentRotation = 3;
        } else if (currentRotation == 3) {
            coordinates = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 1, 0}};
            currentRotation = 0;
        }
    }

    @Override
    public void displayCoordinates() {
        System.out.println("T-shape Coordinates: " + "(" + x + ", " + y + ")");
    }
}