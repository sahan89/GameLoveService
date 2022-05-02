package com.gamelove.controller;

import com.gamelove.model.request.LoveRequest;
import com.gamelove.model.request.LoveResponse;
import com.gamelove.model.request.MostLovedGamesResponse;
import com.gamelove.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sahan on 2022-04-26.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class GameLoveController {

    private final LoveService loveService;

    @Autowired
    public GameLoveController(LoveService loveService) {
        this.loveService = loveService;
    }

    @PostMapping("/lovedGame")
    public LoveResponse lovedGame(@RequestBody LoveRequest loveRequest) {
        return loveService.lovedGame(loveRequest.getGameId(), loveRequest.getPlayerId());
    }

    @DeleteMapping("/unloveGame")
    public LoveResponse unloveGame(@RequestBody LoveRequest loveRequest) {
        return loveService.unloveGame(loveRequest.getGameId(), loveRequest.getPlayerId());
    }

    @GetMapping("/playerLovedGames")
    public List<String> playerLovedGames(@RequestParam int playerId) {
        return loveService.playerLovedGames(playerId);
    }

    @GetMapping("/mostLoved")
    public List<MostLovedGamesResponse> mostLoved(@RequestParam int topCount) {
        return loveService.mostLoved(topCount);
    }
}
