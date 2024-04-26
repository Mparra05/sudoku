package org.example.sudoku.model;

public class BoardGame {

    private final int[][] boardGame;

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

    //Matriz que representa el tablero del juego Sudoku.
    public BoardGame() {
        boardGame = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardGame[i][j] = 0;
            }
        }
    // Inicializa todas las celdas del tablero como vacias (0)

        setDefaultNumbers();
    }
    /*Constructor de la clase BoardGame
     *Inicializa el tablero del juego Sudoku en varias celdas.
     */
    public int[][] getBoardGame() {
        return this.boardGame;
    }
    // Metodo getter para obtener el tablero del juego sudoku

    public void setBoardGame(int number, int row, int column) {
        boardGame[row][column] = number;
    }
    /**
     * Método setter para establecer un número en una celda del tablero.
     *  number el número que se va a establecer.
     *  row la fila de la celda en el tablero.
     *  column la columna de la celda en el tablero.
     */

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
    /*
    intialrow la fila inicial del cuadrante
    finalrow la fila final del cuadrante
    initialcolumn la columna incial del cuadrante
    finalcolumn la columna final del cuandrate
    return true si el numero cumple la regla en la columna, false si es lo opuesto.
     */
    public boolean validateNumberGrid(int number, int initialRow, int finalRow, int initialColumn, int finalColumn) {
        boolean validatedGrid = false;

        for (int i = initialRow; i <= finalRow; i++) {
            for (int j = initialColumn; j <= finalColumn; j++) {
                if (this.boardGame[i][j] == number) validatedGrid = true;
            }
        }
    //Evento de la validacion del numero en cada GridPane de el trablero de Sudoku
        return validatedGrid;
    }

    public boolean validateNumberRow(int number, int row, int columnIndexNumber) {
        boolean validatedRow = false;
        // Implementación para validar el número en la fila especificada
        for (int i = 0; i < 9; i++) {
            if (this.boardGame[row][i]==number && i!=columnIndexNumber) validatedRow = true;
        }

        return validatedRow;
    }

    public boolean validateNumberColumn(int number, int column, int rowIndexNumber) {
        boolean validatedColumn = false;
        // Implementación para validar el número en la columna especificada
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
        // Implementación para obtener el índice inicial de la fila o columna en el cuadrante
    }

    public int getFinalRowOrColumnIndex(int index) {
        int finalRowOrColumnIndex;

        if (index == 0 || index == 1 || index == 2) finalRowOrColumnIndex = 2;
        else if (index == 3 || index == 4 || index == 5) finalRowOrColumnIndex = 5;
        else finalRowOrColumnIndex = 8;

        return finalRowOrColumnIndex;
        // Implementación para obtener el índice final de la fila o columna en el cuadrante
    }

    public boolean isIndexEmpty(int row, int column) {
        boolean indexEmpty = false;

        if (this.boardGame[row][column] != 0) indexEmpty = true;

        return indexEmpty;
        // Implementación para verificar si la celda está vacía
    }

    public void printBoardGame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.boardGame[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
        // Implementación para imprimir el tablero del juego Sudoku en la consola
    }

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
        //Método para verificar si el tablero del juego Sudoku está completo. True si coincide, false si es lo opuesto.

        return validatedBoardComplete;
        // Implementación para verificar si el tablero está completo
    }
}
