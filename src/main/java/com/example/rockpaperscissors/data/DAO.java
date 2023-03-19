package com.example.rockpaperscissors.data;

import com.example.rockpaperscissors.model.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface DAO {
    ArrayList<Game> getGames();
}
