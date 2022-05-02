package com.gamelove.controller;

import com.gamelove.model.Player;
import com.gamelove.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sahan on 2022-04-26.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/savePlayer")
    public Player savePlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }
}
