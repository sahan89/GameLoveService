package com.gamelove.service;

import com.gamelove.model.Game;
import com.gamelove.model.Player;
import com.gamelove.model.request.LoveResponse;
import com.gamelove.model.request.MostLovedGamesResponse;
import com.gamelove.repository.GameRepository;
import com.gamelove.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sahan on 2022-04-26.
 */
@Service
public class LoveService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public LoveService(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public LoveResponse lovedGame(Integer gameId, Integer playerId) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Player> player = playerRepository.findById(playerId);

        if (!game.isPresent() || !player.isPresent()) {
            return new LoveResponse("Input data incorrect.!");
        }

        Set<Game> gameSet = new HashSet<>();
        Set<Game> games = player.get().getGames();
        for (Game listOfGame : games) {
            gameSet.add(listOfGame);
            if (listOfGame.getId() == gameId) {
                return new LoveResponse("Player " + player.get().getName() + " already Loved to this Game.!");
            }
        }

        gameSet.add(game.get());
        Player updatedPlayer = player.get();
        updatedPlayer.setGames(gameSet);
        playerRepository.save(updatedPlayer);

        return new LoveResponse("Player " + player.get().getName() + " Loved to " + game.get().getName());
    }

    public LoveResponse unloveGame(int gameId, int playerId) {
        String unlovedGame = "";
        Optional<Player> player = playerRepository.findById(playerId);

        if (!player.isPresent()) {
            return new LoveResponse("Input data incorrect.!");
        }

        Set<Game> gameSet = new HashSet<>();
        Set<Game> games = player.get().getGames();
        for (Game listOfGame : games) {
            gameSet.add(listOfGame);
            if (listOfGame.getId() == gameId) {
                gameSet.remove(listOfGame);
                unlovedGame = listOfGame.getName();
            }
        }

        Player updatedPlayer = player.get();
        updatedPlayer.setGames(gameSet);
        playerRepository.save(updatedPlayer);

        return new LoveResponse("Player " + player.get().getName() + " unlove to " + unlovedGame);
    }

    public List<String> playerLovedGames(int playerId) {
        Optional<Player> player = playerRepository.findById(playerId);

        List<String> gameList = new ArrayList<>();
        Set<Game> games = player.get().getGames();

        for (Game listOfGame : games) {
            System.out.println(listOfGame.getName());
            gameList.add(listOfGame.getName());
        }
        return gameList;
    }

    public List<MostLovedGamesResponse> mostLoved(int topCount) {
        List<String> mostLovedGamesResponses = playerRepository.findMostLovedGames(topCount);
        List<MostLovedGamesResponse> gameCount = new ArrayList<>();
        for (String mlr : mostLovedGamesResponses) {
            MostLovedGamesResponse response = new MostLovedGamesResponse();

            String[] arrOfStr = mlr.split(",");
            response.setGameCount(Integer.parseInt(arrOfStr[1]));
            response.setGameName(arrOfStr[2]);
            gameCount.add(response);
        }

        return gameCount;
    }
}
