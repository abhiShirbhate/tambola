package com.sahaj.tambola;

public class Player {
    String name;
    int[][] ticket = new int[5][3];

    public Player(String player1, int[][] ticket1) {
        name = player1;
        ticket = ticket1;
    }
}
