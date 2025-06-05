package com.TicTacToe.Types;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Statistics {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm");
    private String draw = "";
    private String winnername;
    private char winner;

    public String getDate() {
        return LocalDateTime.now().format(dtf);
    }

    public String getDraw() {
        return draw;
    }

    public String getWinnername() {
        return winnername;
    }

    public char getWinner() {
        return winner;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public void setWinnername(String winnername) {
        this.winnername = winnername;
    }

    public void setWinner(char winner) {
        this.winner = winner;
    }
}
