package com.TicTacToe.util;

import com.TicTacToe.Constants;

import java.io.*;

public class Config {
    public static void writesettings(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.settingsfile))){
            bw.write(Integer.toString(Constants.cnf.getFieldsize()));
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
                        Constants.cnf.setFieldsize(Integer.parseInt(buf));

                    case 2:
                        Constants.cnf.setNameX(buf);
                    case 3:
                        Constants.cnf.setName0(buf);
                }
                count++;
            }
            if(Constants.cnf.getFieldsize() > 9){
                throw new NumberFormatException("Неіснуюче значеня розміру поля");
            }
        }catch(FileNotFoundException e){
            System.out.println("Помилка: " + e.getMessage());
            Constants.cnf.setFieldsize(3);
        }catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Невірний формат поля, встановлено розмір 3х3 за замовчуванням");
            Constants.cnf.setFieldsize(3);
        }
    }
}
