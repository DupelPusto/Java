package com.TicTacToe.util;

import com.TicTacToe.Constants;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Statistic {
    public static void writestatistic(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.statisticfile, true))){
            bw.newLine();
            bw.write("Дата гри: " + Constants.st.getDate());
            bw.newLine();
            bw.write("Розмір поля: " + Constants.cnf.getFieldsize());
            bw.newLine();
            if(Constants.st.getDraw().equals("Нічия")){
                bw.write("Результат гри: " + Constants.st.getDraw());
                bw.newLine();
            } else {
                bw.write("Результат гри: переміг гравець " + Constants.st.getWinnername() + "(" + Constants.st.getWinner() + ")");
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
