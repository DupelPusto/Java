import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

public class Main {

    public static char winner;
    public static String winnername;
    public static String draw = "";
    public static int pzsize;
    public static String settingsfile = "config.txt";
    public static String statisticfile = "statistic.txt";
    public static String nameX = "X";
    public static String name0 = "0";
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm");

    public static void writestatistic(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(statisticfile, true))){
            bw.newLine();
            bw.write("Дата гри: " + LocalDateTime.now().format(dtf));
            bw.newLine();
            bw.write("Розмір поля: " + pzsize);
            bw.newLine();
            if(draw.equals("Нічия")){
                bw.write("Результат гри: " + draw);
                bw.newLine();
            } else {
                bw.write("Результат гри: переміг гравець " + winnername + "(" + winner + ")");
                bw.newLine();
            }

        } catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        } catch (DateTimeException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void readstatistic(){
        try(BufferedReader br = new BufferedReader(new FileReader(statisticfile))){
            while (br.ready()){
                System.out.println(br.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Спочатку пограй, а потім дивись)");
        } catch(IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void writesettings(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(settingsfile))){
            bw.write(Integer.toString(pzsize));
            bw.newLine();
            bw.write("X");
            bw.newLine();
            bw.write("0");
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void readsettings(){
        try(BufferedReader br = new BufferedReader(new FileReader(settingsfile))){
            String buf;
            int count = 1;
            while(br.ready()){
                buf = br.readLine();
                switch(count){
                    case 1:
                        pzsize = Integer.parseInt(buf);

                    case 2:
                        nameX = buf;
                    case 3:
                        name0 = buf;
                }
                count++;
            }
            if(pzsize > 9){
                throw new NumberFormatException("Неіснуюче значеня розміру поля");
            }
        }catch(FileNotFoundException e){
            System.out.println("Помилка: " + e.getMessage());
            pzsize = 3;
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Невірний формат поля, встановлено розмір 3х3 за замовчуванням");
            pzsize = 3;
        }
    }

    public static void main(String[] args) {
        readsettings();
        Scanner sc = new Scanner(System.in);
        int menupos;
        while (true) {
            System.out.println("\nГоловне меню \n");
            System.out.println("1.Грати (Нова гра)");
            System.out.println("2.Налаштування");
            System.out.println("3.Ігрова статистика");
            System.out.println("4.Вихід \n");
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
                playGame(sc, board);
            } else if (menupos == 2) {
                configureSettings(sc);
            }else if(menupos == 3){
                readstatistic();
            } else if (menupos == 4) {
                System.out.println("Вихід з гри...");
                writesettings();
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

    public static void playGame(Scanner sc, char[][] board) {
        char currentpl;

        int pos1, pos2, counter = 1;

        while (true) {
            currentpl = (counter % 2 != 0) ? 'X' : 'O';
            String player = (counter % 2 != 0) ? nameX : name0;

            System.out.println("Хід гравця " + player);
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

            if (checkWin(board, currentpl)) {
                System.out.println(player + " переміг!");
                winner = currentpl;
                winnername = player;
                writestatistic();
                break;
            }

            if (counter == pzsize * pzsize) {
                System.out.println("Нічия!");
                draw = "Нічия";
                writestatistic();
                break;
            }
            counter++;
        }
    }

    public static boolean checkWin(char[][] board, char player) {
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

        for (int i = 0; i <= pzsize - winlength; i++) {
            for (int j = 0; j <= pzsize - winlength; j++) {
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
                            pzsize = 3;
                            return;
                        case 2:
                            pzsize = 5;
                            return;
                        case 3:
                            pzsize = 7;
                            return;
                        case 4:
                            pzsize = 9;
                            return;
                        default:
                            System.out.println("Введено неіснуючий параметр, спробуйте знову");
                            break;
                    }
                } else if(set == 2){
                    System.out.println("Введіть ім'я для гравця Х: ");
                    nameX = sc.nextLine();
                    System.out.println("Введіть ім'я для гравця 0: ");
                    name0 = sc.nextLine();
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