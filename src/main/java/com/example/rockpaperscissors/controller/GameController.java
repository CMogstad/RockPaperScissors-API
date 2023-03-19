package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.model.Game;
import com.example.rockpaperscissors.model.Player;
import com.example.rockpaperscissors.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/games")
    public Game startNewGame(@RequestBody Player player) {
        return gameService.startNewGame(player);
    }

    @PutMapping("/games/{id}/join")
    public Game playerJoinsGame(@PathVariable("id") Integer gameId, @RequestBody Player player) {
        return gameService.enterPlayer2(gameId, player);
    }

    @PutMapping("/games/{id}/move")
    public Game playMove(@PathVariable("id") Integer gameId, @RequestBody Player player) {
        return gameService.makeMove(gameId, player);
    }

    @GetMapping("/games/{id}")
    public Game getGameState(@PathVariable("id") Integer gameId) {
        return gameService.getGameState(gameId);
    }
}
