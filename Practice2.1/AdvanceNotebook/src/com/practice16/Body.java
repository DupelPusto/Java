package com.practice16;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.practice16.utils.RW;


public class Body {
    public static void mainmenu(){
        Scanner s = new Scanner(System.in);
        int counter = 0;
        while(true) {
            System.out.println("Головне меню");
            System.out.println();
            System.out.println("1.Додати запис");
            System.out.println("2.Видалити запис");
            System.out.println("3.Переглянути запис");
            System.out.println("4.Вихід");
            System.out.println("Для вибору введіть номер пункту");

            try {
                int menu = s.nextInt();
                s.nextLine();

                switch (menu) {
                    case 1:
                        ++counter;
                        addnotate(counter);
                        break;
                    case 2:
                        deletenotate();
                        break;
                    case 3:
                        printNotates();
                        break;
                    case 4:
                        RW.writenotate();
                        s.close();
                        System.out.println("Вихід...");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: " + e.getMessage());
                s.nextLine();
            }

        }
    }

    public static void datetimeFormats(Scanner s, LocalDate ld){

        System.out.println("Оберіть формат дати(введіть його номер):");
        System.out.println("1. За замовчуванням(" + ld.format(DateTimeFormatter.ISO_LOCAL_DATE) + ")");
        System.out.println("2." + ld.format(DateTimeFormatter.BASIC_ISO_DATE));


        while(true) {
            try {
                int menu = s.nextInt();
                s.nextLine();
                switch (menu) {
                    case 1:
                        Values.DATEFORMAT = Values.RES;
                        return;
                    case 2:
                        Values.DATEFORMAT = DateTimeFormatter.BASIC_ISO_DATE;
                        return;
                    default:
                        System.out.println("Неіснуючий пункт, спробуйте ще раз");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некоректне введення, спробуйте ще раз");
                s.nextLine();
            }
        }
    }

    private static void printNotates(){
        for(int i = 0; i < Values.SIZE; i++){
            if(Values.DATA[i] != null){
                System.out.println(Values.DATA[i]);
                System.out.println(Values.NOTATES[i]);
                System.out.println();
            }
        }
    }

    public static void addnotate(int counter){
        Scanner s = new Scanner(System.in);
        LocalDate ld = LocalDate.now();

        if(counter == 1) datetimeFormats(s, ld);

        LocalDate date;
        while(true) {
            try {
                System.out.println("Введіть дату в обраному форматі: ");
                String date1 = s.nextLine();
                date = LocalDate.parse(date1,Values.DATEFORMAT);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DateTimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        String notate = "";
        String buf;
        System.out.println("Введіть зміст нотатки(для виходу натисніть 0): ");

        while(true) {
            buf = s.nextLine();
            if(buf.equals("0")){
                break;
            }
            notate += buf  + "\n";


        }
        int i;
        for (i = 0; i < Values.SIZE; i++) {

            if(Values.DATA[i] == null){
                Values.DATA[i] = date;
                Values.NOTATES[i] = notate;
                System.out.println("Вміст успішно записано");
                break;
            }
        }
        if(i == Values.SIZE){
            System.out.println("Немає вільних місць для запису. Видаліть попередні та спробуйте ще раз");
        }

    }

    public static void deletenotate(){
        Scanner s = new Scanner(System.in);
        LocalDate date;
        System.out.println("Введіть дату для видалення нотатки: ");
        String buferdate = s.nextLine();
        date = LocalDate.parse(buferdate,Values.DATEFORMAT);

        for (int i = 0; i < Values.SIZE; i++) {
            if(date.equals(Values.DATA[i])){
                Values.DATA[i] = null;
                Values.NOTATES[i] = null;
                System.out.println("Запис за датою " + date + " успішно видалено");
                break;
            }
            if(i == Values.SIZE - 1) {
                System.out.println("Запису за заданою датою не знайдено, спробуйте ще раз");
            }
        }
    }
}