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

    public void setDefaultNumbers() {
        for (int i = 0; i < 9; i++) {
            int defaultNumbers = 4;
            int randomRow = 0, randomColumn = 0, initialRow = 0, finalRow = 0, initialColumn = 0, finalColumn = 0;
            int randomNumber = (int) (Math.random() * 8) + 1;

            while (defaultNumbers > 0) {
                switch (i) {
                    case 0:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2);
                        finalRow = 2;
                        finalColumn = 2;
                        break;
                    case 1:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2) + 3;
                        finalRow = 2;
                        initialColumn = 3;
                        finalColumn = 5;
                        break;
                    case 2:
                        randomRow = (int) (Math.random() * 2);
                        randomColumn = (int) (Math.random() * 2) + 6;
                        finalRow = 2;
                        initialColumn = 6;
                        finalColumn = 8;
                        break;
                    case 3:
                        randomRow = (int) (Math.random() * 2) + 3;
                        randomColumn = (int) (Math.random() * 2);
                        initialRow = 3;
                        finalRow = 5;
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

                if (!(validateNumberGrid(randomNumber, initialRow, finalRow, initialColumn, finalColumn)) && !(validateNumberRow(randomNumber, randomRow, randomColumn)) && !(validateNumberColumn(randomNumber, randomColumn, randomRow))) {
                    this.boardGame[randomRow][randomColumn] = randomNumber;
                    defaultNumbers--;
                    System.out.println("Prueba");
                }

                /*if (!(validateNumberGrid(randomNumber, initialRow, finalRow, initialColumn, finalColumn))) {
                    System.out.println(validateNumberGrid(randomNumber, initialRow, finalRow, initialColumn, finalColumn));
                }
                if (!(validateNumberRow(randomNumber, randomRow, randomColumn))) {
                    //System.out.println(validateNumberRow(randomNumber, randomRow, randomColumn));
                }
                if (!(validateNumberColumn(randomNumber, randomColumn, randomRow))) {
                    //System.out.println(validateNumberColumn(randomNumber, randomColumn, randomRow));
                }

                defaultNumbers--;*/
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
}
