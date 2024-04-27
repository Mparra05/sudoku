package org.example.sudoku.model;

/**
 * The interface sudoku board game
 */
public interface IBoardGame {
    /**
     * Gets the board game
     * @return The board game
     */
    int[][] getBoardGame();

    /**
     * Sets the number typed on the board game
     * @param number Number typed
     * @param row Row of the field typed
     * @param column Column of the field typed
     */
    void setNumberBoardGame(int number, int row, int column);

    /**
     * Removes a number of the board game
     * @param row Row of the field to remove
     * @param column Column of the field to remove
     */
    void removeNumberBoardGame(int row, int column);

    /**
     * Sets the default numbers on the board game
     */
    void setDefaultNumbers();

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
    boolean validateNumberGrid(int number, int row, int column, int initialRow, int finalRow, int initialColumn, int finalColumn);

    /**
     * Validates if the number typed is already used on the same row of the board game
     * @param number Number typed
     * @param row Row of the field typed
     * @param columnIndexNumber Column of the field typed
     * @return If the number typed is already used on the same row of the board game or not
     */
    boolean validateNumberRow(int number, int row, int columnIndexNumber);

    /**
     * Validates if the number typed is already used on the same column of the board game
     * @param number Number typed
     * @param column Column of the field typed
     * @param rowIndexNumber Row of the field typed
     * @return If the number typed is already used on the same column of the board game or not
     */
    boolean validateNumberColumn(int number, int column, int rowIndexNumber);

    /**
     * Gets the first row or column of the grid where a specific field is located
     * @param index Index of the row or column of the specific field
     * @return The index first row or column of the grid
     */
    int getInitialRowOrColumnIndex(int index);

    /**
     * Gets the last row or column of the grid where a specific field is located
     * @param index Index of the row or column of the specific field
     * @return The index last row or column of the grid
     */
    int getFinalRowOrColumnIndex(int index);

    /**
     * Validates if a field of the board game is empty
     * @param row Row of the field
     * @param column Column of the field
     * @return If the field of the board game is empty or not
     */
    boolean isIndexEmpty(int row, int column);

    /**
     * Shows the current numbers of the board game in the shell to make testing
     */
    void printBoardGame();

    /**
     * Validates if the board game is already complete
     * @return If the board game is already complete or not
     */
    boolean validateBoardComplete();
}
