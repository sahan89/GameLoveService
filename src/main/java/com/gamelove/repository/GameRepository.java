package com.gamelove.repository;

import com.gamelove.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahan on 2022-04-26.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findGameById(int gameId);
}
