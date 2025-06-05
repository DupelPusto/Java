package com.TicTacToe;

import com.TicTacToe.util.Config;
import com.TicTacToe.util.Statistic;
import com.TicTacToe.Constants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Config.readsettings();
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
                Constants.field.setBoardsize(2 * Constants.cnf.getFieldsize() + 1);
                Constants.field.initializeBoard();
                Constants.field.printBoard();
                Gameplay.playGame(sc);
            } else if (menupos == 2) {
                Gameplay.configureSettings(sc);
            }else if(menupos == 3){
                Statistic.readstatistic();
            } else if (menupos == 4) {
                System.out.println("Вихід з гри...");
                Config.writesettings();
                break;
            }
        }
    }
}
