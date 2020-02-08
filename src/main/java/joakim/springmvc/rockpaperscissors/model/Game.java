package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Result;
import java.util.Random;

public class Game {
    private Long gameId;
    private Player firstPlayer;
    private Player secondPlayer;
    private Result result;

    public Game() {
        this.gameId = new Random().nextLong();
        this.firstPlayer = null;
        this.secondPlayer = null;
        this.result = Result.WaitingPlayers;
    }

    public void setFirstPlayer(String name) {
        this.firstPlayer = new Player(name);
    }

    public void setSecondPlayer(String name) {
        this.secondPlayer = new Player(name);
    }

    public Long getGameId() {
        return gameId;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setResult(Result result) {
        this.result = result;
}

    public Player getPlayer(String name) {
        if(name.equals(firstPlayer.getName())) {
            return firstPlayer;
        }
        else if(name.equals(secondPlayer.getName())) {
            return secondPlayer;
        }

        return null; //ILLEGAL EXPRESSION
    }

    public Result getResult() {
        return result;
    }

    public void setReadyPlayer(Player player) {
        if(player.getName().equals(firstPlayer.getName())) {
            if(!secondPlayer.gotMove()) {
                this.result = Result.WaitingSecondPlayer;
            }
        }
        else if(player.getName().equals(secondPlayer.getName())) {
            if(!firstPlayer.gotMove()) {
                this.result = Result.WaitingFirstPlayer;
            }
        }
        if(firstPlayer.gotMove() && secondPlayer.gotMove()) {
            this.result = Result.BothReady;
        }
    }

    public boolean isFull() {
        if(this.getFirstPlayer() != null && this.getSecondPlayer() != null) {
            return true;
        }
        return false;
    }
}
