package com.gamelove.model.request;


import java.io.Serializable;

/**
 * Created by sahan on 2022-05-01.
 */
public class MostLovedGamesResponse implements Serializable{
    private int gameCount;
    private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
