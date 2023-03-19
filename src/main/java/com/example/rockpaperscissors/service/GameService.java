package com.example.rockpaperscissors.service;

import com.example.rockpaperscissors.data.DAO;
import com.example.rockpaperscissors.data.GameData;
import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    private DAO dao;
    private ArrayList<Game> games;

    @Autowired
    public GameService(GameData gameData) {
        dao = gameData;
        games = dao.getGames();
    }

    public Game findGameBasedOnId(int gameId) {
        for (Game game : games) {
            if (game.getId() == gameId) {
                return game;
            }
        }
        return null;
    }

    public Game startNewGame(Player player) {
        Game game = new Game(player);
        games.add(game);
        return game;
    }

    public Game enterPlayer2(int gameId, Player player) {
        Game game = findGameBasedOnId(gameId);
        verifyGame(game);
        game.setPlayer2(player);
        return game;
    }

    public Game makeMove(int gameId, Player player) {
        verifyMove(player.getMove());
        Game game = findGameBasedOnId(gameId);
        verifyGame(game);
        verifyPlayer(game, player.getName());

        if (!game.isCompleted()) {
            game.makeMove(player);
        }
        return game;
    }

    private void verifyMove(String move){
        if(!move.equalsIgnoreCase("rock") && !move.equalsIgnoreCase("paper") && !move.equalsIgnoreCase("scissors")){
            throw new IllegalArgumentException("Invalid move! Should be rock, paper or scissors.");
        }
    }

    private void verifyGame(Game game) {
        if (game == null){
            throw new IllegalArgumentException("Invalid game! This game does not exists.");
        }
    }

    private void verifyPlayer(Game game, String name){
        if (!game.getPlayer1().getName().equalsIgnoreCase(name) && !game.getPlayer2().getName().equalsIgnoreCase(name)){
            throw new IllegalArgumentException("Invalid player! This player does not exists in this game.");
        }
    }

    public Game getGameState(int gameId) {
        Game game = findGameBasedOnId(gameId);
        verifyGame(game);
        return game;
    }

}
