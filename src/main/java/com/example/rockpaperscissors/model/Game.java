package com.example.rockpaperscissors.model;

public class Game {

    private static int idCounter = 1;
    private int id;
    private Player player1;
    private Player player2;
    private String winner;
    private boolean completed = false;

    public Game(Player player) {
        id = generateId();
        setPlayer1(player);
    }

    public int getId() {
        return id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private int generateId() {
        return idCounter++;
    }

    public void makeMove(Player player) {
        if (player1.getName().equals(player.getName())) {
            player1.setMove(player.getMove());
        } else if (player2.getName().equals(player.getName())) {
            player2.setMove(player.getMove());
        }

        if (player1.getMove() != null && player2.getMove() != null) {
            calculateWinner();
        }
    }

    public void calculateWinner() {
        winner = player1.getName();

        if (player1.getMove().equalsIgnoreCase("rock") && player2.getMove().equalsIgnoreCase("paper")
                || player1.getMove().equalsIgnoreCase("paper") && player2.getMove().equalsIgnoreCase("scissors")
                || player1.getMove().equalsIgnoreCase("scissors") && player2.getMove().equalsIgnoreCase("rock")) {
            winner = player2.getName();
        } else if (player1.getMove().equalsIgnoreCase(player2.getMove())) {
            winner = "Tie";
        }
        completed = true;
    }
}
