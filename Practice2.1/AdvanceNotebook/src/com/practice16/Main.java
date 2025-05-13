package com.practice16;


import java.util.Scanner;
import com.practice16.utils.RW;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Чи хочете імпортувати щоденник з файлу(натисність Enter щоб пропустити, + щоб імпортувати)?");

        while (true) {
            String fname = s.nextLine();
            try {
                if (fname.isEmpty()) {
                    Body.mainmenu();
                    break;
                } else if (fname.equals("+")) {
                    RW.readnotebook();
                    Body.mainmenu();
                    break;
                } else {
                    throw new IllegalArgumentException("Невірна опція");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Введіть знову:");
            }
        }
    }
}
