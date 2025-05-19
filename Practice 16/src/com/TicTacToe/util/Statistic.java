package com.TicTacToe.util;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import com.TicTacToe.Constants;

public class Statistic {
    public static void writestatistic(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.statisticfile, true))){
            bw.newLine();
            bw.write("Дата гри: " + LocalDateTime.now().format(Constants.dtf));
            bw.newLine();
            bw.write("Розмір поля: " + Constants.pzsize);
            bw.newLine();
            if(Constants.draw.equals("Нічия")){
                bw.write("Результат гри: " + Constants.draw);
                bw.newLine();
            } else {
                bw.write("Результат гри: переміг гравець " + Constants.winnername + "(" + Constants.winner + ")");
                bw.newLine();
            }

        } catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        } catch (DateTimeException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void readstatistic(){
        try(BufferedReader br = new BufferedReader(new FileReader(Constants.statisticfile))){
            while (br.ready()){
                System.out.println(br.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Спочатку пограй, а потім дивись)");
        } catch(IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
