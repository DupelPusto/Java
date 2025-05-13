package com.practice16.utils;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import com.practice16.Values;

public class RW {
    public static void readnotebook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть назву файлу з щоденником для зчитування:");
        String filename = s.nextLine() + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {


            String line;
            String entry = "";
            LocalDate date = null;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (date != null && !entry.isEmpty() && Values.VALUE < Values.SIZE) {
                        Values.DATA[Values.VALUE] = date;
                        Values.NOTATES[Values.VALUE] = entry;
                        Values.VALUE++;
                    }
                    entry = "";
                    date = null;
                } else if (date == null) {
                    date = LocalDate.parse(line);
                } else {
                    entry += line + "\n";
                }
            }
            if (date != null && !entry.isEmpty() && Values.VALUE < Values.SIZE) {
                Values.DATA[Values.VALUE] = date;
                Values.NOTATES[Values.VALUE] = entry;
                Values.VALUE++;
            }
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void writenotate() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть назву для файлу з щоденником:");
        String filename = s.nextLine() + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < Values.SIZE; i++) {
                if(Values.DATA[i] != null){
                    bw.write(Values.DATA[i].toString());
                    bw.newLine();
                    bw.write(Values.NOTATES[i]);
                    bw.newLine();
                }
            }
        }catch(IOException e){
            System.out.println("Помилка:" + e.getMessage());
        }

    }
}
