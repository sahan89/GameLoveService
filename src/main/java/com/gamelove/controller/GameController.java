package com.gamelove.controller;

import com.gamelove.model.Game;
import com.gamelove.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by sahan on 2022-04-26.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/saveGame")
    public Game saveGame(@RequestBody Game game){
        return gameService.saveGame(game);
    }
}
