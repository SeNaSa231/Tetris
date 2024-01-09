package Pieces;

public class ZShape extends TetrisPiece {
    public ZShape(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}}, x, y, borderRangeX, borderRangeY);
    }

    @Override
    public void rotate() {
        System.out.println("Z-shape: Rotating");

        // Example of a simple rotation logic for demonstration
        if (currentRotation == 0) {
            coordinates = new int[][]{{0, 0, 1}, {0, 1, 1}, {0, 1, 0}};
            currentRotation = 1;
        } else if (currentRotation == 1) {
            coordinates = new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
            currentRotation = 2;
        } else if (currentRotation == 2) {
            coordinates = new int[][]{{0, 1, 0}, {1, 1, 0}, {1, 0, 0}};
            currentRotation = 3;
        } else if (currentRotation == 3) {
            coordinates = new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
            currentRotation = 0;
        }
    }

    @Override
    public void displayCoordinates() {
        System.out.println("Z-shape Coordinates: " + "(" + x + ", " + y + ")");
    }
}
