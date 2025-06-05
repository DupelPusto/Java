package com.TicTacToe.Types;

public class Configure {
    private static int fieldsize;
    private static String nameX = "X";
    private static String name0 = "0";

    public void setFieldsize(int fieldsize) {
        Configure.fieldsize = fieldsize;
    }

    public void setNameX(String nameX) {
        Configure.nameX = nameX;
    }

    public void setName0(String name0) {
        Configure.name0 = name0;
    }

    public int getFieldsize() {
        return fieldsize;
    }

    public String getNameX(){
        return nameX;
    }

    public String getName0() {
        return name0;
    }
}
