package com.gamelove;

import com.gamelove.model.Game;
import com.gamelove.model.Player;
import com.gamelove.repository.GameRepository;
import com.gamelove.repository.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GameLoveServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GameLoveServiceApplication.class, args);

        GameRepository gameRepository = context.getBean(GameRepository.class);
        PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
        gameRepository.saveAll(games());
        playerRepository.saveAll(players());
    }

    private static List<Game> games() {
        List<Game> games = new ArrayList<>();
        games.add(createGame("Age of Empires"));
        games.add(createGame("Call of Duty"));
        games.add(createGame("FIFA 2020"));
        games.add(createGame("Street Fighter"));
        games.add(createGame("Resident Evil"));

        return games;
    }

    private static List<Player> players() {
        List<Player> players = new ArrayList<>();
        players.add(createPlayer("Bela"));
        players.add(createPlayer("Max"));
        players.add(createPlayer("Jenny"));
        players.add(createPlayer("Henrik"));
        players.add(createPlayer("Anders"));
        players.add(createPlayer("Sandra"));

        return players;
    }

    private static Game createGame(String name) {
        Game game = new Game();
        game.setName(name);
        return game;
    }

    private static Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return player;
    }
}
