package com.gamelove.service;

import com.gamelove.model.Player;
import com.gamelove.repository.GameRepository;
import com.gamelove.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by sahan on 2022-04-26.
 */
@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private GameRepository gameRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}
