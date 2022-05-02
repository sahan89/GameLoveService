package com.gamelove.repository;

import com.gamelove.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by sahan on 2022-04-26.
 */
@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findPlayersById(int id);


    @Query(value = "SELECT g.id, count(id) as gameCount, g.name FROM Game g \n" +
            "INNER JOIN player_loved_games plg ON g.id = plg.game_id\n" +
            "GROUP BY g.id\n" +
            "ORDER BY gameCount DESC\n" +
            "LIMIT:topCount", nativeQuery = true)
    List<String> findMostLovedGames(@Param("topCount") int topCount);

}
