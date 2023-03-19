package com.example.rockpaperscissors.data;

import com.example.rockpaperscissors.model.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GameData implements DAO {

    private ArrayList<Game> games = new ArrayList<>();

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
