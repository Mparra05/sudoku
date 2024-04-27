package org.example.sudoku.model;

/**
 * Class representing a sudoku board
 */
public class BoardGame implements IBoardGame {

    /**
     * The board game
     */
    private final int[][] boardGame;

    /**
     * Example of a board game almost complete to test the win method faster
     */
    /*private final int[][] boardGame = new int[][] {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {0, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 0},
    };*/

    /**
     * Class constructor initialize the board game
     * @see #setDefaultNumbers()
     */
    public BoardGame() {
        boardGame = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardGame[i][j] = 0;
            }
        }

        setDefaultNumbers();
    }

    /**
     * Gets the board game
     * @return The board game
     */
    @Override
    public int[][] getBoardGame() {
        return this.boardGame;
    }

    /**
     * Sets the number typed on the board game
     * @param number Number typed
     * @param row Row of the field typed
     * @param column Column of the field typed
     */
    @Override
    public void setNumberBoardGame(int number, int row, int column) {
        boardGame[row][column] = number;
    }

    /**
     * Removes a number of the board game
     * @param row Row f the field to remove
     * @param column Column of the field to remove
     */
    @Override
    public void removeNumberBoardGame(int row, int column) {
        boardGame[row][column] = 0;
    }

    /**
     * Sets the default numbers on the board game
     * @see #validateNumberGrid(int, int, int, int, int, int, int)
     * @see #validateNumberRow(int, int, int)
     * @see #validateNumberColumn(int, int, int)
     * @see #isIndexEmpty(int, int)
     */
    @Override
    public void setDefaultNumbers() {
        for (int i = 0; i < 9; i++) {
            int defaultNumbers = 4;

            while (defaultNumbers > 0) {
                int randomRow = 0, randomColumn = 0;
                int initialRow = 0, finalRow = 0;
                int initialColumn = 0, finalColumn = 0;
                int randomNumber = (int) (Math.random() * 9) + 1;

                switch (i) {
                    case 0:
                        randomRow = (int) (Math.random() * 3);
                        randomColumn = (int) (Math.random() * 3);
                        initialRow = 0;
                        finalRow = 2;
                        finalColumn = 0;
                        finalColumn = 2;
                        break;
                    case 1:
                        randomRow = (int) (Math.random() * 3);
                        randomColumn = (int) (Math.random() * 3) + 3;
                        initialRow = 0;
                        finalRow = 2;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 2:
                        randomRow = (int) (Math.random() * 3);
                        randomColumn = (int) (Math.random() * 3) + 6;
                        initialRow = 0;
                        finalRow = 2;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                    case 3:
                        randomRow = (int) (Math.random() * 3) + 3;
                        randomColumn = (int) (Math.random() * 3);
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 0;
                        finalColumn = 2;
                        break;
                    case 4:
                        randomRow = (int) (Math.random() * 3) + 3;
                        randomColumn = (int) (Math.random() * 3) + 3;
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 5:
                        randomRow = (int) (Math.random() * 3) + 3;
                        randomColumn = (int) (Math.random() * 3) + 6;
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                    case 6:
                        randomRow = (int) (Math.random() * 3) + 6;
                        randomColumn = (int) (Math.random() * 3);
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 0;
                        finalColumn = 2;
                        break;
                    case 7:
                        randomRow = (int) (Math.random() * 3) + 6;
                        randomColumn = (int) (Math.random() * 3) + 3;
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 8:
                        randomRow = (int) (Math.random() * 3) + 6;
                        randomColumn = (int) (Math.random() * 3) + 6;
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                }

                if (!(validateNumberGrid(randomNumber, randomRow, randomColumn, initialRow, finalRow, initialColumn, finalColumn))
                        && !(validateNumberRow(randomNumber, randomRow, randomColumn))
                        && !(validateNumberColumn(randomNumber, randomColumn, randomRow))
                        && !isIndexEmpty(randomRow, randomColumn)) {

                    this.boardGame[randomRow][randomColumn] = randomNumber;
                    defaultNumbers--;
                }
            }
        }
    }

    /**
     * Validates if the number typed is already used on the same grid
     * @param number Number typed
     * @param row Row of the field typed
     * @param column Column of the field typed
     * @param initialRow First row of the grid
     * @param finalRow Last row of the grid
     * @param initialColumn First column of the grid
     * @param finalColumn Last column of the grid
     * @return If the number typed is already used on the same grid or not
     */
    @Override
    public boolean validateNumberGrid(int number, int row, int column, int initialRow, int finalRow, int initialColumn, int finalColumn) {
        boolean validatedGrid = false;

        for (int i = initialRow; i <= finalRow; i++) {
            for (int j = initialColumn; j <= finalColumn; j++) {
                if (this.boardGame[i][j] == number && i != row && j != column) validatedGrid = true;
            }
        }

        return validatedGrid;
    }

    /**
     * Validates if the number typed is already used on the same row of the board game
     * @param number Number typed
     * @param row Row of the field typed
     * @param columnIndexNumber Column of the field typed
     * @return If the number typed is already used on the same row of the board game or not
     */
    @Override
    public boolean validateNumberRow(int number, int row, int columnIndexNumber) {
        boolean validatedRow = false;

        for (int i = 0; i < 9; i++) {
            if (this.boardGame[row][i]==number && i!=columnIndexNumber) validatedRow = true;
        }

        return validatedRow;
    }

    /**
     * Validates if the number typed is already used on the same column of the board game
     * @param number Number typed
     * @param column Column of the field typed
     * @param rowIndexNumber Row of the field typed
     * @return If the number typed is already used on the same column of the board game or not
     */
    @Override
    public boolean validateNumberColumn(int number, int column, int rowIndexNumber) {
        boolean validatedColumn = false;

        for (int i = 0; i < 9; i++) {
            if (this.boardGame[i][column]==number && i!=rowIndexNumber) validatedColumn = true;
        }

        return validatedColumn;
    }

    /**
     * Gets the first row or column of the grid where a specific field is located
     * @param index Index of the row or column of the specific field
     * @return The index first row or column of the grid
     */
    @Override
    public int getInitialRowOrColumnIndex(int index) {
        int initialRowOrColumnIndex;

        if (index == 0 || index == 1 || index == 2) initialRowOrColumnIndex = 0;
        else if (index == 3 || index == 4 || index == 5) initialRowOrColumnIndex = 3;
        else initialRowOrColumnIndex = 6;

        return initialRowOrColumnIndex;
    }

    /**
     * Gets the last row or column of the grid where a specific field is located
     * @param index Index of the row or column of the specific field
     * @return The index last row or column of the grid
     */
    @Override
    public int getFinalRowOrColumnIndex(int index) {
        int finalRowOrColumnIndex;

        if (index == 0 || index == 1 || index == 2) finalRowOrColumnIndex = 2;
        else if (index == 3 || index == 4 || index == 5) finalRowOrColumnIndex = 5;
        else finalRowOrColumnIndex = 8;

        return finalRowOrColumnIndex;
    }

    /**
     * Validates if a field of the board game is empty
     * @param row Row of the field
     * @param column Column of the field
     * @return If the field of the board game is empty or not
     */
    @Override
    public boolean isIndexEmpty(int row, int column) {
        boolean indexEmpty = false;

        if (this.boardGame[row][column] != 0) indexEmpty = true;

        return indexEmpty;
    }

    /**
     * Shows the current numbers of the board game in the shell to make testing
     */
    @Override
    public void printBoardGame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.boardGame[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * Validates if the board game is already complete
     * @return If the board game is already complete or not
     */
    @Override
    public boolean validateBoardComplete() {
        boolean validatedBoardComplete = true;

        for (int i = 0; i < 9 && validatedBoardComplete; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.boardGame[i][j] == 0) {
                    validatedBoardComplete = false;
                    break;
                }
            }
        }

        return validatedBoardComplete;
    }
}
