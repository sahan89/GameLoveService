package com.gamelove.service;

import com.gamelove.model.Game;
import com.gamelove.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by sahan on 2022-04-26.
 */
@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
}
