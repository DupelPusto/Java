import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menupos;
        int pzsize = 3;
        while (true) {
            System.out.println("\nГоловне меню \n");
            System.out.println("1.Грати (Нова гра)");
            System.out.println("2.Налаштування");
            System.out.println("3.Вихід \n");
            System.out.println("Для вибору введіть номер 1-3");

            while (true) {
                if (sc.hasNextInt()) {
                    menupos = sc.nextInt();
                    break;
                }
                System.out.println("Введіть коректне значення");
                sc.next();
            }

            if (menupos == 1) {
                System.out.println("Гра почалась \n");
                int boardsize = 2 * pzsize + 1;
                char[][] board = initializeBoard(boardsize);
                printBoard(board);
                playGame(sc, board, pzsize);
            } else if (menupos == 2) {
                pzsize = configureSettings(sc);
            } else if (menupos == 3) {
                System.out.println("Вихід з гри...");
                break;
            }
        }
    }

    public static char[][] initializeBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void playGame(Scanner sc, char[][] board, int pzsize) {
        char currentpl;
        int pos1, pos2, counter = 1;
        int boardsize = 2 * pzsize + 1;

        while (true) {
            currentpl = (counter % 2 != 0) ? 'X' : 'O';
            System.out.println("Хід гравця " + currentpl);
            System.out.println("Введіть координати комірки через пробіл");

            while (true) {
                if (sc.hasNextInt()) {
                    pos1 = sc.nextInt();
                    pos2 = sc.nextInt();

                    if (pos1 >= 1 && pos1 <= pzsize && pos2 >= 1 && pos2 <= pzsize) {
                        int boardRow = 2 * (pos1 - 1) + 2;
                        int boardCol = 2 * (pos2 - 1) + 2;

                        if (board[boardRow][boardCol] == ' ') {
                            board[boardRow][boardCol] = currentpl;
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

            printBoard(board);

            if (checkWin(board, pzsize, currentpl)) {
                System.out.println(currentpl + " переміг!");
                break;
            }

            if (counter == pzsize * pzsize) {
                System.out.println("Нічия!");
                break;
            }
            counter++;
        }
    }

    public static boolean checkWin(char[][] board, int pzsize, char player) {
        int winlength = 3;
        for (int i = 0; i < pzsize; i++) {
            for (int j = 0; j <= pzsize - winlength; j++) {
                if (board[2 * i + 2][2 * j + 2] == player &&
                        board[2 * i + 2][2 * (j + 1) + 2] == player &&
                        board[2 * i + 2][2 * (j + 2) + 2] == player) {
                    return true;
                }
            }
        }
        for (int j = 0; j < pzsize; j++) {
            for (int i = 0; i <= pzsize - winlength; i++) {
                if (board[2 * i + 2][2 * j + 2] == player &&
                        board[2 * (i + 1) + 2][2 * j + 2] == player &&
                        board[2 * (i + 2) + 2][2 * j + 2] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int configureSettings(Scanner sc) {
        System.out.println("Налаштування\n");
        System.out.println("1.Розмір ігрового поля\n");
        System.out.println("Для виходу в головне меню натисніть 0");
        int pzsize = 3;
        while (true) {
            if (sc.hasNextInt() && sc.nextInt() == 1) {
                System.out.println("Оберіть бажаний розмір поля");
                System.out.println("1. 3x3");
                System.out.println("2. 5x5");
                System.out.println("3. 7x7");
                System.out.println("4. 9x9");
                while (true){
                    if(sc.hasNextInt()){
                        int size = sc.nextInt();
                        if (size == 1){
                            pzsize = 3;
                            break;
                        } else if (size == 2) {
                            pzsize = 5;
                            break;
                        } else if (size == 3) {
                            pzsize = 7;
                            break;
                        } else if (size == 4) {
                            pzsize = 9;
                            break;
                        }
                    }
                    System.out.println("Введіть існуючий параметр");

                }

                break;
            }
            System.out.println("Некоректне значення, спробуйте ще раз");
            sc.next();
        }
        return pzsize;
    }
}
