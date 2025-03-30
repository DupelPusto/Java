import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;


import java.io.FileNotFoundException;


public class Main {

    public static void Readfile(){
        FileReader fr = null;
        Scanner s;
        try{
            s = new Scanner(System.in);
            System.out.print("Введіть ім'я файлу для читання: ");
            String filename = s.nextLine();

            fr = new FileReader(filename + ".txt");
            String filecontent = "";
            while (fr.ready()){
                char c = (char) fr.read();
                filecontent += c;
            }
            System.out.println("Зчитаний вміст:\n" + filecontent);

        } catch (FileNotFoundException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            try{
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e){
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    public static void FileWrite(){
        FileWriter fw = null;
        Scanner s;

        try{
            s = new Scanner(System.in);
            System.out.print("Введіть назву файлу: ");
            String filename = s.nextLine() + ".txt";

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
                    fw = new FileWriter(filename,true);
                    break;
                case 2:
                    fw = new FileWriter(filename);
                    break;

            }


            System.out.println("Введіть текст для запису у файл(для виходу натисніть 0): ");
            while (true) {
                String text = s.nextLine();
                if (text.equals("0")){
                    System.out.println("Запис збережено у файлі " + filename);
                    break;
                }
                String towrite = text.trim();
                fw.write(towrite + "\n");
            }
        } catch (IOException | InputMismatchException e) {
            System.out.println("Помилка: " + e.getMessage());
        }catch (NullPointerException e){
            System.out.println("Помилка" + e.getMessage());
        } finally {
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e){
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    public static void Menu(){
        Scanner s = new Scanner(System.in);
        while(true) {

            System.out.println("\nГоловне меню\n");
            System.out.println("1.Записати до файлу");
            System.out.println("2.Прочитати зміст файлу");
            System.out.println("3.Вихід\n");
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