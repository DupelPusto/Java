package com.TicTacToe;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static char winner;
    public static String winnername;
    public static String draw = "";
    public static int pzsize;
    public static String settingsfile = "config.txt";
    public static String statisticfile = "statistic.txt";
    public static String nameX = "X";
    public static String name0 = "0";
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm");
}
