package org.example.sudoku.model;

public class BoardGame {

    private final int[][] boardGame;

    public BoardGame() {
        boardGame = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardGame[i][j] = 0;
            }
        }

        setDefaultNumbers();
    }

    public int[][] getBoardGame() {
        return this.boardGame;
    }

    public void setBoardGame(int number, int row, int column) {
        boardGame[row][column] = number;
    }

    public void setDefaultNumbers() {
        for (int i = 0; i < 9; i++) {
            int defaultNumbers = 4;

            while (defaultNumbers > 0) {
                int randomRow = 0, randomColumn = 0;
                int initialRow = 0, finalRow = 0;
                int initialColumn = 0, finalColumn = 0;
                int randomNumber = (int) (Math.random() * 8) + 1;

                switch (i) {
                    case 0:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2);
                        initialRow = 0;
                        finalRow = 2;
                        finalColumn = 0;
                        finalColumn = 2;
                        break;
                    case 1:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2) + 3;
                        initialRow = 0;
                        finalRow = 2;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 2:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2) + 6;
                        initialRow = 0;
                        finalRow = 2;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                    case 3:
                        randomRow = (int) (Math.random() * 2) + 3;
                        randomColumn = (int) (Math.random() * 2);
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 0;
                        finalColumn = 2;
                        break;
                    case 4:
                        randomRow = (int) (Math.random() * 2) + 3;
                        randomColumn = (int) (Math.random() * 2) + 3;
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 5:
                        randomRow = (int) (Math.random() * 2) + 3;
                        randomColumn = (int) (Math.random() * 2) + 6;
                        initialRow = 3;
                        finalRow = 5;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                    case 6:
                        randomRow = (int) (Math.random() * 2) + 6;
                        randomColumn = (int) (Math.random() * 2);
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 0;
                        finalColumn = 2;
                        break;
                    case 7:
                        randomRow = (int) (Math.random() * 2) + 6;
                        randomColumn = (int) (Math.random() * 2) + 3;
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 8:
                        randomRow = (int) (Math.random() * 2) + 6;
                        randomColumn = (int) (Math.random() * 2) + 6;
                        initialRow = 6;
                        finalRow = 8;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                }

                if (!(validateNumberGrid(randomNumber, initialRow, finalRow, initialColumn, finalColumn))
                        && !(validateNumberRow(randomNumber, randomRow, randomColumn))
                        && !(validateNumberColumn(randomNumber, randomColumn, randomRow))
                        && !isIndexEmpty(randomRow, randomColumn)) {

                    this.boardGame[randomRow][randomColumn] = randomNumber;
                    defaultNumbers--;
                }

            }
        }
    }

    public boolean validateNumberGrid(int number, int initialRow, int finalRow, int initialColumn, int finalColumn) {
        boolean validatedGrid = false;

        for (int i = initialRow; i <= finalRow; i++) {
            for (int j = initialColumn; j <= finalColumn; j++) {
                if (this.boardGame[i][j] == number) validatedGrid = true;
            }
        }

        return validatedGrid;
    }

    public boolean validateNumberRow(int number, int row, int columnIndexNumber) {
        boolean validatedRow = false;

        for (int i = 0; i < 9; i++) {
            if (this.boardGame[row][i]==number && i!=columnIndexNumber) validatedRow = true;
        }

        return validatedRow;
    }

    public boolean validateNumberColumn(int number, int column, int rowIndexNumber) {
        boolean validatedColumn = false;

        for (int i = 0; i < 9; i++) {
            if (this.boardGame[i][column]==number && i!=rowIndexNumber) validatedColumn = true;
        }

        return validatedColumn;
    }

    public int getInitialRowOrColumnIndex(int index) {
        int initialRowOrColumnIndex;

        if (index == 0 || index == 1 || index == 2) initialRowOrColumnIndex = 0;
        else if (index == 3 || index == 4 || index == 5) initialRowOrColumnIndex = 3;
        else initialRowOrColumnIndex = 6;

        return initialRowOrColumnIndex;
    }

    public int getFinalRowOrColumnIndex(int index) {
        int finalRowOrColumnIndex;

        if (index == 0 || index == 1 || index == 2) finalRowOrColumnIndex = 2;
        else if (index == 3 || index == 4 || index == 5) finalRowOrColumnIndex = 5;
        else finalRowOrColumnIndex = 8;

        return finalRowOrColumnIndex;
    }

    public boolean isIndexEmpty(int row, int column) {
        boolean indexEmpty = false;

        if (this.boardGame[row][column] != 0) indexEmpty = true;

        return indexEmpty;
    }
}
