package com.TicTacToe;

import com.TicTacToe.util.Statistic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameplay {

//    public static char[][] initializeBoard(int size) {
//        char[][] board = new char[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (i == 0 && j == 0) {
//                    board[i][j] = ' ';
//                } else if (i == 0 && j % 2 == 0) {
//                    board[i][j] = (char) ('1' + j / 2 - 1);
//                } else if (j == 0 && i % 2 == 0) {
//                    board[i][j] = (char) ('1' + i / 2 - 1);
//                } else if (i % 2 == 0 && j % 2 == 0) {
//                    board[i][j] = ' ';
//                } else if (i % 2 == 1 && j % 2 == 1) {
//                    board[i][j] = '+';
//                } else if (i % 2 == 1) {
//                    board[i][j] = '-';
//                } else {
//                    board[i][j] = '|';
//                }
//            }
//        }
//        return board;
//    }

//    public static void printBoard(char[][] board) {
//        for (char[] row : board) {
//            for (char cell : row) {
//                System.out.print(cell);
//            }
//            System.out.println();
//        }
//    }

    public static void playGame(Scanner sc) {
        char currentpl;

        int pos1, pos2, counter = 1;

        while (true) {
            currentpl = (counter % 2 != 0) ? 'X' : 'O';
            String player = (counter % 2 != 0) ? Constants.cnf.getNameX() : Constants.cnf.getName0();

            System.out.println("Хід гравця " + player);
            System.out.println("Введіть координати комірки через пробіл");

            while (true) {
                if (sc.hasNextInt()) {
                    pos1 = sc.nextInt();
                    pos2 = sc.nextInt();

                    if (pos1 >= 1 && pos1 <= Constants.cnf.getFieldsize() && pos2 >= 1 && pos2 <= Constants.cnf.getFieldsize()) {
                        int boardRow = 2 * (pos1 - 1) + 2;
                        int boardCol = 2 * (pos2 - 1) + 2;

                        if (Constants.field.getBoard()[boardRow][boardCol] == ' ') {
                            Constants.field.setBoardchars(currentpl,boardRow,boardCol);
                            break;
                        } else {
                            System.out.println("Ця комірка вже зайнята, спробуйте іншу");
                        }
                    } else {
                        System.out.println("Ви ввели неіснуючі координати, спробуйте ще раз");
                    }
                } else {
                    System.out.println("Некоректні координати, спробуйте ще раз");
                    sc.next();
                }
            }

            Constants.field.printBoard();

            if (checkWin(Constants.field.getBoard(), currentpl)) {
                System.out.println(player + " переміг!");
                Constants.st.setWinner(currentpl);
                Constants.st.setWinnername(player);
                Statistic.writestatistic();
                break;
            }

            if (counter == Constants.cnf.getFieldsize() * Constants.cnf.getFieldsize()) {
                System.out.println("Нічия!");
                Constants.st.setDraw("Нічия");
                Statistic.writestatistic();
                break;
            }
            counter++;
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        int winlength = 3;

        for (int i = 0; i < Constants.cnf.getFieldsize(); i++) {
            for (int j = 0; j <= Constants.cnf.getFieldsize() - winlength; j++) {
                if (board[2 * i + 2][2 * j + 2] == player &&
                        board[2 * i + 2][2 * (j + 1) + 2] == player &&
                        board[2 * i + 2][2 * (j + 2) + 2] == player) {
                    return true;
                }
            }
        }

        for (int j = 0; j < Constants.cnf.getFieldsize(); j++) {
            for (int i = 0; i <= Constants.cnf.getFieldsize() - winlength; i++) {
                if (board[2 * i + 2][2 * j + 2] == player &&
                        board[2 * (i + 1) + 2][2 * j + 2] == player &&
                        board[2 * (i + 2) + 2][2 * j + 2] == player) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= Constants.cnf.getFieldsize() - winlength; i++) {
            for (int j = 0; j <= Constants.cnf.getFieldsize() - winlength; j++) {
                if (board[2 * i + 2][2 * j + 2] == player &&
                        board[2 * (i + 1) + 2][2 * (j + 1) + 2] == player &&
                        board[2 * (i + 2) + 2][2 * (j + 2) + 2] == player) {
                    return true;
                }

                if (board[2 * i + 2][2 * (j + 2) + 2] == player &&
                        board[2 * (i + 1) + 2][2 * (j + 1) + 2] == player &&
                        board[2 * (i + 2) + 2][2 * j + 2] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void configureSettings(Scanner sc) {
        while (true) {
            System.out.println("Налаштування\n");
            System.out.println("1.Розмір ігрового поля");
            System.out.println("2.Задати імена гравців\n");
            System.out.println("Для виходу в головне меню натисніть 0");

            try {
                int set = sc.nextInt();
                sc.nextLine();
                if (set == 1){
                    System.out.println("Оберіть бажаний розмір поля");
                    System.out.println("1. 3x3");
                    System.out.println("2. 5x5");
                    System.out.println("3. 7x7");
                    System.out.println("4. 9x9");
                    int size = sc.nextInt();
                    sc.nextLine();
                    switch (size){
                        case 1:
                            Constants.cnf.setFieldsize(3);
                            return;
                        case 2:
                            Constants.cnf.setFieldsize(5);
                            return;
                        case 3:
                            Constants.cnf.setFieldsize(7);
                            return;
                        case 4:
                            Constants.cnf.setFieldsize(9);
                            return;
                        default:
                            System.out.println("Введено неіснуючий параметр, спробуйте знову");
                            break;
                    }
                } else if(set == 2){
                    System.out.println("Введіть ім'я для гравця Х: ");
                    Constants.cnf.setNameX(sc.nextLine());
                    System.out.println("Введіть ім'я для гравця 0: ");
                    Constants.cnf.setName0(sc.nextLine());
                    return;
                } else if (set == 0) {
                    return;
                }
            }catch (InputMismatchException e){
                System.out.println("Помилка: " + e.getMessage());
            }

        }
    }



}
