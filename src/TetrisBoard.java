import java.util.Random;
import java.util.Scanner;

import Commands.MoveDownCommand;
import Commands.MoveLeftCommand;
import Commands.MoveRightCommand;
import Commands.RotateCommand;
import Commands.TetrisCommand;

import Pieces.SShape;
import Pieces.ZShape;
import Pieces.IShape;
import Pieces.LShape;
import Pieces.MLShape;
import Pieces.Square;
import Pieces.TShape;
import Pieces.TetrisPiece;


// Tetris Board class responsible for managing the game board (Singleton)
public class TetrisBoard {
    private static TetrisBoard instance;
    private TetrisPiece currentPiece;
    private char[][] gameBoard;
    private int score;
    private boolean gameInProgress;
    private Scanner scanner;

    private TetrisBoard(int rows, int cols) {
        gameBoard = new char[rows][cols];
        scanner = new Scanner(System.in);
        gameInProgress = true;
        score = 0;
        initializeBoard();
    }

    public static TetrisBoard getInstance() {
        if (instance == null) {
            instance = new TetrisBoard(10, 10); // Adjust the board size as needed
        }
        return instance;
    }

    private void initializeBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }

    private void displayBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                char cellContent;

                // Check if the current cell is part of the Tetris piece
                if (currentPiece != null && i >= currentPiece.getY() && i < currentPiece.getY() + currentPiece.getCoordinates().length &&
                        j >= currentPiece.getX() && j < currentPiece.getX() + currentPiece.getCoordinates()[0].length &&
                        currentPiece.getCoordinates()[i - currentPiece.getY()][j - currentPiece.getX()] != 0) {
                    cellContent = 'X';
                } else {
                    cellContent = gameBoard[i][j];
                }

                System.out.print(cellContent + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void checkAndClearRows() {
        for (int i = gameBoard.length - 1; i >= 0; i--) {
            boolean rowFilled = true;
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    rowFilled = false;
                    break;
                }
            }
            if (rowFilled) {
                clearRow(i);
                score ++;
            }
        }
    }

    private void clearRow(int row) {
        System.out.println("Row " + row + " is filled. Clearing the row.");
        for (int j = 0; j < gameBoard[row].length; j++) {
            gameBoard[row][j] = ' ';
        }

        for (int i = row - 1; i >= 0; i--)
        {
            for (int j = gameBoard[row].length - 1; j >= 0; j--)
            {
                if(gameBoard[i][j] == 'X')
                {
                    gameBoard[i][j] = ' ';
                    gameBoard[i + 1][j] = 'X';
                }
            }
        }
    }

    public boolean canMoveDown() {
        for (int i = 0; i < currentPiece.getCoordinates().length; i++) {

            for (int j = 0; j < currentPiece.getCoordinates()[0].length; j++) {

                if (currentPiece.getCoordinates()[i][j] != 0) {
                    int col = i + currentPiece.getY() + 1;
                    int row = j + currentPiece.getX();

                    if (col >= gameBoard.length || gameBoard[col][row] != ' ') {
                        if (isAtTop()) { gameInProgress = false; }
                        return false; // Collision detected
                    }
                }
            }
        }
        return true; // No collision
    }
    public boolean isAtTop() { return currentPiece.getY() == 0; }
    public void landPiece() {
        System.out.println("Piece landed!");
        updateGameBoard();
        checkAndClearRows();
    }

    private void updateGameBoard() {
        int[][] pieceCoordinates = currentPiece.getCoordinates();

        for (int i = 0; i < pieceCoordinates.length; i++) {
            for (int j = 0; j < currentPiece.getCoordinates()[0].length; j++) {
                if (pieceCoordinates[i][j] != 0)
                {
                    int row = i + currentPiece.getY();
                    int col = j + currentPiece.getX();

                    gameBoard[row][col] = 'X'; // Assuming 'X' represents a part of the landed piece
                }
            }
        }
    }

    public void createNewPiece() {
        System.out.println("Creating a new piece...");
        Random random = new Random();
        int randomType = random.nextInt(7);

        switch (randomType) {
            case 0:
                currentPiece = new TShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 1:
                currentPiece = new Square(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 2:
                currentPiece = new LShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 3:
                currentPiece = new MLShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 4:
                currentPiece = new IShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 5:
                currentPiece = new ZShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
            case 6:
                currentPiece = new SShape(3, 0, gameBoard.length, gameBoard[0].length);
                break;
        }
    }

    public void playGame() {
        createNewPiece();

        while(gameInProgress)
        {
            displayBoard();
            currentPiece.displayCoordinates();

            if (!canMoveDown()) {
                landPiece();
                createNewPiece();
            } else {
                processUserInput();
                if(gameInProgress) {
                    currentPiece.executeCommand();
                }
            }

            // Simulate some delay or user input
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processUserInput() {
        System.out.println("Your score: " + score);
        System.out.println("Enter your move (L: Move Left, R: Move Right, D: Move Down, U: Rotate, E: Exit): ");
        String userInput = scanner.next().toUpperCase();

        if (currentPiece != null) {
            TetrisCommand command = null;

            switch (userInput) {
                case "L":
                    command = new MoveLeftCommand(currentPiece);
                    break;
                case "R":
                    command = new MoveRightCommand(currentPiece);
                    break;
                case "D":
                    command = new MoveDownCommand(currentPiece);
                    break;
                case "U":
                    command = new RotateCommand(currentPiece);
                    break;
                case "E":
                    gameInProgress = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    processUserInput();
                    return;
            }

            currentPiece.addCommand(command);
        }
    }
}