package com.gamelove.model.request;

import java.io.Serializable;

/**
 * Created by sahan on 2022-04-26.
 */
public class LoveRequest implements Serializable {
    private int playerId;
    private int gameId;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
