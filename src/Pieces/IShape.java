package Pieces;

public class IShape extends TetrisPiece {
    public IShape(int x, int y, int borderRangeX, int borderRangeY) {
        super(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}}, x, y, borderRangeX, borderRangeY);
    }

    @Override
    public void rotate() {
        System.out.println("I-shape: Rotating");

        // Example of a simple rotation logic for demonstration
        if (currentRotation == 0) {
            coordinates = new int[][]{{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
            currentRotation = 1;
        } else if (currentRotation == 1) {
            coordinates = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
            currentRotation = 0;
        }
    }

    @Override
    public void displayCoordinates() {
        System.out.println("I-shape Coordinates: " + "(" + x + ", " + y + ")");
    }
}
