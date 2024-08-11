package SnakesAndLadders;

import java.util.UUID;

public class Player {

    private String playerId;
    private String playerName;
    private int currentPosition;

    public Player(String playerName) {
        this.playerId = UUID.randomUUID().toString();
        this.playerName = playerName;
        currentPosition = 0;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
