//package com.practice16;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.time.format.DateTimeFormatter;
//import java.time.DateTimeException;
//
//public class AdvNotebook {
//
////    public static final int SIZE = 50;
////    public static LocalDate[] data = new LocalDate[SIZE];
////    public static String[] notates = new String[SIZE];
////    public static DateTimeFormatter res = DateTimeFormatter.ISO_LOCAL_DATE;
////    public static DateTimeFormatter dateformat = null;
////    public static int value = 0;
//
////    public static void readnotebook() {
////        Scanner s = new Scanner(System.in);
////        System.out.println("Введіть назву файлу з щоденником для зчитування:");
////        String filename = s.nextLine() + ".txt";
////
////        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
////
////
////            String line;
////            String entry = "";
////            LocalDate date = null;
////
////            while ((line = br.readLine()) != null) {
////                if (line.trim().isEmpty()) {
////                    if (date != null && !entry.isEmpty() && value < SIZE) {
////                        data[value] = date;
////                        notates[value] = entry;
////                        value++;
////                    }
////                    entry = "";
////                    date = null;
////                } else if (date == null) {
////                    date = LocalDate.parse(line);
////                } else {
////                    entry += line + "\n";
////                }
////            }
////            if (date != null && !entry.isEmpty() && value < SIZE) {
////                data[value] = date;
////                notates[value] = entry;
////                value++;
////            }
////        }catch (IOException e){
////            System.out.println("Помилка: " + e.getMessage());
////        }
////    }
//
////    public static void writenotate() {
////        Scanner s = new Scanner(System.in);
////        System.out.println("Введіть назву для файлу з щоденником:");
////        String filename = s.nextLine() + ".txt";
////
////        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
////            for (int i = 0; i < SIZE; i++) {
////                if(data[i] != null){
////                    bw.write(data[i].toString());
////                    bw.newLine();
////                    bw.write(notates[i]);
////                    bw.newLine();
////                }
////            }
////        }catch(IOException e){
////            System.out.println("Помилка:" + e.getMessage());
////        }
////
////    }
//
////    public static void datetimeFormats(Scanner s, LocalDate ld){
////
////        System.out.println("Оберіть формат дати(введіть його номер):");
////        System.out.println("1. За замовчуванням(" + ld.format(DateTimeFormatter.ISO_LOCAL_DATE) + ")");
////        System.out.println("2." + ld.format(DateTimeFormatter.BASIC_ISO_DATE));
////
////
////        while(true) {
////            try {
////                int menu = s.nextInt();
////                s.nextLine();
////                switch (menu) {
////                    case 1:
////                        dateformat = res;
////                        return;
////                    case 2:
////                        dateformat = DateTimeFormatter.BASIC_ISO_DATE;
////                        return;
////                    default:
////                        System.out.println("Неіснуючий пункт, спробуйте ще раз");
////                }
////            } catch (InputMismatchException e) {
////                System.out.println("Некоректне введення, спробуйте ще раз");
////                s.nextLine();
////            }
////        }
////    }
//
////    public static void addnotate(int counter){
////        Scanner s = new Scanner(System.in);
////        LocalDate ld = LocalDate.now();
////
////        if(counter == 1) datetimeFormats(s, ld);
////
////        LocalDate date;
////        while(true) {
////            try {
////                System.out.println("Введіть дату в обраному форматі: ");
////                String date1 = s.nextLine();
////                date = LocalDate.parse(date1,dateformat);
////                break;
////            } catch (InputMismatchException e) {
////                System.out.println("Error: " + e.getMessage());
////            } catch (DateTimeException e) {
////                System.out.println("Error: " + e.getMessage());
////            }
////        }
////
////        String notate = "";
////        String buf;
////        System.out.println("Введіть зміст нотатки(для виходу натисніть 0): ");
////
////        while(true) {
////            buf = s.nextLine();
////            if(buf.equals("0")){
////                break;
////            }
////            notate += buf  + "\n";
////
////
////        }
////        int i;
////        for (i = 0; i < SIZE; i++) {
////
////            if(data[i] == null){
////                data[i] = date;
////                notates[i] = notate;
////                System.out.println("Вміст успішно записано");
////                break;
////            }
////        }
////        if(i == SIZE){
////            System.out.println("Немає вільних місць для запису. Видаліть попередні та спробуйте ще раз");
////        }
////
////    }
//
////    public static void deletenotate(){
////        Scanner s = new Scanner(System.in);
////        LocalDate date;
////        System.out.println("Введіть дату для видалення нотатки: ");
////        String buferdate = s.nextLine();
////        date = LocalDate.parse(buferdate,dateformat);
////
////        for (int i = 0; i < SIZE; i++) {
////            if(date.equals(data[i])){
////                data[i] = null;
////                notates[i] = null;
////                System.out.println("Запис за датою " + date + " успішно видалено");
////                break;
////            }
////            if(i == SIZE - 1) {
////                System.out.println("Запису за заданою датою не знайдено, спробуйте ще раз");
////            }
////        }
////    }
//
////    public static void mainmenu(){
////        Scanner s = new Scanner(System.in);
////        int counter = 0;
////        while(true) {
////            System.out.println("Головне меню");
////            System.out.println();
////            System.out.println("1.Додати запис");
////            System.out.println("2.Видалити запис");
////            System.out.println("3.Переглянути запис");
////            System.out.println("4.Вихід");
////            System.out.println("Для вибору введіть номер пункту");
////
////            try {
////                int menu = s.nextInt();
////                s.nextLine();
////
////                switch (menu) {
////                    case 1:
////                        ++counter;
////                        addnotate(counter);
////                        break;
////                    case 2:
////                        deletenotate();
////                        break;
////                    case 3:
////                        printNotates();
////                        break;
////                    case 4:
////                        writenotate();
////                        s.close();
////                        System.out.println("Вихід...");
////                        return;
////                }
////            } catch (InputMismatchException e) {
////                System.out.println("Помилка: " + e.getMessage());
////                s.nextLine();
////            }
////
////        }
////    }
//
////    private static void printNotates(){
////        for(int i = 0; i < SIZE; i++){
////            if(data[i] != null){
////                System.out.println(data[i]);
////                System.out.println(notates[i]);
////                System.out.println();
////            }
////        }
////    }
//
////    public static void main(String[] args) {
////        Scanner s = new Scanner(System.in);
////
////        System.out.println("Чи хочете імпортувати щоденник з файлу(натисність Enter щоб пропустити, + щоб імпортувати)?");
////
////        while (true) {
////            String fname = s.nextLine();
////            try {
////                if (fname.isEmpty()) {
////                    mainmenu();
////                    break;
////                } else if (fname.equals("+")) {
////                    readnotebook();
////                    mainmenu();
////                    break;
////                } else {
////                    throw new IllegalArgumentException("Невірна опція");
////                }
////            } catch (IllegalArgumentException e) {
////                System.out.println(e.getMessage());
////                System.out.println("Введіть знову:");
////            }
////        }
////    }
//}
