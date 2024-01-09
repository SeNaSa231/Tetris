package Pieces;
import java.util.List;
import java.util.ArrayList;
import Commands.TetrisCommand;

public abstract class TetrisPiece {
    protected int[][] coordinates;
    protected int x;
    protected int y;
    protected int currentRotation;
    protected int borderRangeX;
    protected int borderRangeY;


    protected List<TetrisCommand> commands;

    public TetrisPiece(int[][] coordinates, int x, int y, int borderRangeX, int borderRangeY) {
        this.coordinates = coordinates;
        this.x = x;
        this.y = y;
        this.commands = new ArrayList<>();
        this.borderRangeX = borderRangeX;
        this.borderRangeY = borderRangeY;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int[][] getCoordinates() { return coordinates; }

    public void addCommand(TetrisCommand command) {
        commands.add(command);
    }

    public void moveLeft() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if(coordinates[i][j] != 0 && x + i <= 0) {
                    System.out.println(getClass().getSimpleName() + ": Reached the edge!");
                    return;
                }
            }
        }
        System.out.println(getClass().getSimpleName() + ": Moving left");
        x--;
    }

    public void moveRight() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                if(coordinates[i][j] != 0 && x + j >= borderRangeX - 1) {
                    System.out.println(getClass().getSimpleName() + ": Reached the edge!");
                    return;
                }
            }
        }
        System.out.println(getClass().getSimpleName() + ": Moving right");
        x++;
    }

    public void moveDown() {
        System.out.println(getClass().getSimpleName() + ": Moving down");
        y++;
    }

    public void rotate() {
        System.out.println(getClass().getSimpleName() + ": Rotating");
    }

    public void displayCoordinates() {
        System.out.println(getClass().getSimpleName() + " Coordinates: " + "(" + x + ", " + y + ")");
    }

    public void executeCommand() {
        while (!commands.isEmpty()) {
            TetrisCommand command = commands.remove(0);
            command.execute();
        }
    }
}