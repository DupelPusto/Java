package com.TicTacToe.Types;

public class Field {

    private int boardsize;
    char[][] board;


    public void setBoardsize(int boardsize) {
        this.boardsize = boardsize;
    }

    public char[][] getBoard() {
        return board;
    }

    public char[][] initializeBoard() {
        board = new char[this.boardsize][this.boardsize];
        for (int i = 0; i < this.boardsize; i++) {
            for (int j = 0; j < this.boardsize; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = ' ';
                } else if (i == 0 && j % 2 == 0) {
                    board[i][j] = (char) ('1' + j / 2 - 1);
                } else if (j == 0 && i % 2 == 0) {
                    board[i][j] = (char) ('1' + i / 2 - 1);
                } else if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = ' ';
                } else if (i % 2 == 1 && j % 2 == 1) {
                    board[i][j] = '+';
                } else if (i % 2 == 1) {
                    board[i][j] = '-';
                } else {
                    board[i][j] = '|';
                }
            }
        }
        return board;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void setBoardchars(char player, int row, int col) {
        board[row][col] = player;
    }
}
