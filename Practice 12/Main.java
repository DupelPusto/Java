import java.io.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static void Rangereader(){
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу для читання: ");
        String filename = s.nextLine();
        int startstr = 0;
        int finishstr = 0;
        try{
            System.out.println("Введіть початковий рядок: ");
            startstr = s.nextInt() - 1;
            System.out.println("Введіть кінцевий рядок: ");
            finishstr = s.nextInt() - 1;
        } catch (InputMismatchException e){
            System.out.println("Помилка: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"))){

            String textline;
            for (int i = 0; i <= finishstr; i++) {
                textline = br.readLine();
                if(i >= startstr){
                    System.out.println(i+1 + " " + textline);
                }
            }


        } catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void Readfile(){
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу для читання: ");
        String filename = s.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"))){

            String textline;
            while ((textline = br.readLine()) != null){
                System.out.println(textline);
            }


        } catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }

    }

    public static void FileWrite(){

        Scanner s = new Scanner(System.in);
        System.out.print("Введіть назву файлу: ");
        String filename = s.nextLine() + ".txt";
        boolean writemode = false;
        try {
            System.out.println("Оберіть режим запису:\n" +
                    "1.Доповнити файл\n" +
                    "2.Повний перезапис\n" +
                    "Для вибору введіть номер пункту");
            if (!s.hasNextInt()){
                throw new InputMismatchException("Неіснуючий режим запису");
            }
            int mode = s.nextInt();
            s.nextLine();

            switch (mode){
                case 1:
                    writemode = true;
                    break;
                case 2:
                    break;
            }

        } catch(InputMismatchException e){
            System.out.println("Помилка: " + e.getMessage());
        }


        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, writemode))){

            System.out.println("Введіть текст для запису у файл(для виходу натисніть 0): ");
            int linenumber = 1;
            while (true) {
                System.out.print(linenumber + " ");
                String text = s.nextLine();
                if (text.equals("0")){
                    System.out.println("Запис збережено у файлі " + filename);
                    break;
                }
                String towrite = text.trim();
                bw.write(towrite);
                bw.newLine();
                linenumber++;

            }
        } catch (IOException | InputMismatchException e) {
            System.out.println("Помилка: " + e.getMessage());
        }catch (NullPointerException e){
            System.out.println("Помилка" + e.getMessage());
        }
    }

    static void RowWriter(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть назву файлу для редагування: ");
        String file = s.nextLine() + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedReader brr = new BufferedReader(new FileReader(file))
             ){

            int lines = 0;
            String output;
            while ((output = br.readLine()) != null){
                lines++;
                System.out.println(lines + " " + output);
            }

            System.out.println("Введіть номер рядку для редагування: ");
            int row = s.nextInt() - 1;
            s.nextLine();
            System.out.println("Введіть значення для заміни: ");
            String newvalue = s.nextLine();



            String rowbufer;
            String oldrow = "";
            String[] bufer = new String[lines + 1];

            for (int i = 0; i <= lines; i++) {
                rowbufer = brr.readLine();
                bufer[i] = rowbufer;
                if (i == row) {
                    oldrow = rowbufer;
                    bufer[row] = newvalue;
                }
            }
            System.out.println(lines);
            bufer[lines] = oldrow;

            System.out.println(Arrays.toString(bufer));

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (int j = 0; j <= lines; j++) {
                bw.write(bufer[j]);
                bw.newLine();
            }
            bw.flush();
            bw.close();


        }catch (IOException | InputMismatchException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void Menu(){
        Scanner s = new Scanner(System.in);
        while(true) {

            System.out.println("\nГоловне меню\n");
            System.out.println("1.Записати до файлу");
            System.out.println("2.Прочитати зміст файлу");
            System.out.println("3.Прочитати діапазон рядків");
            System.out.println("4.Записати в конкретний рядок");
            System.out.println("5.Вихід\n");

            System.out.println("Для вибору дії введіть номер пункту");
            try {
                int choose = s.nextInt();


                switch (choose) {
                    case 1:
                        FileWrite();
                        break;
                    case 2:
                        Readfile();
                        break;
                    case 3:
                        Rangereader();
                        break;
                    case 4:
                        RowWriter();
                        break;
                    case 5:
                        System.out.println("Вихід...");
                        return;

                    default:
                        throw new InputMismatchException("Перевірте коректність введеного номера пункту");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: " + e.getMessage());
                s.nextLine();
            }

        }
    }

    public static void main(String[] args) {
        Menu();
    }
}
