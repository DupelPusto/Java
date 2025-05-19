package com.TicTacToe.util;

import java.io.*;
import com.TicTacToe.Constants;

public class Config {
    public static void writesettings(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.settingsfile))){
            bw.write(Integer.toString(Constants.pzsize));
            bw.newLine();
            bw.write("X");
            bw.newLine();
            bw.write("0");
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void readsettings(){
        try(BufferedReader br = new BufferedReader(new FileReader(Constants.settingsfile))){
            String buf;
            int count = 1;
            while(br.ready()){
                buf = br.readLine();
                switch(count){
                    case 1:
                        Constants.pzsize = Integer.parseInt(buf);

                    case 2:
                        Constants.nameX = buf;
                    case 3:
                        Constants.name0 = buf;
                }
                count++;
            }
            if(Constants.pzsize > 9){
                throw new NumberFormatException("Неіснуюче значеня розміру поля");
            }
        }catch(FileNotFoundException e){
            System.out.println("Помилка: " + e.getMessage());
            Constants.pzsize = 3;
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Невірний формат поля, встановлено розмір 3х3 за замовчуванням");
            Constants.pzsize = 3;
        }
    }
}
