package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.UUID;


public class Game {

    private Long gameId;
    private Player firstPlayer;
    private Player secondPlayer;
    private Result result;
    private int rdyPlayers;
    private int players;

    public Game() {
        Long generatedLong = new Random().nextLong();
        this.gameId = generatedLong;
        this.result = Result.WaitingPlayers;
    }

    public void setFirstPlayer(String name) {
        this.firstPlayer = new Player(name);
        this.players += 1;
    }

    public void setSecondPlayer(String name) {
        this.secondPlayer = new Player(name);
        this.players += 1;
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
/*
    public void setResult(Player player) { //GÖR DETTA I GAMESTATE
        //player.s
        if(player.equals(firstPlayer)) {
            firstPlayer.setResult(result);
            this.result = Result.FstPlayerWin;
        }
        else if(player.equals(this.secondPlayer)) {
            this.result = Result.SndPlayerWin;
        }
    }*/
    public void setResult(Result result) { //GÖR DETTA I GAMESTATE
        this.result = result;
}

    public Player getPlayer(String name) {
        if(name.equals(firstPlayer.getName())) {
            return firstPlayer;
        }
        else if(name.equals(secondPlayer.getName())) {
            return secondPlayer;
        }
        //ILLEGAL EXPRESSION
        return null;
    }

    public Result getResult() {
        return result;
    }

    public void setRdyPlayers(int num) {
        this.rdyPlayers += num;
    }

    public int getRdyPlayers() {
        return this.rdyPlayers;
    }

    public void setRdyPlayer(Player player) {
        if(player.getName().equals(firstPlayer.getName())) {
            if(!secondPlayer.gotMove()) {
                this.result = Result.WaitingSecondPlayer;
            }
        }
        else if(player.getName().equals(firstPlayer.getName())) {
            if(!firstPlayer.gotMove()) {
                this.result = Result.WaitingFirstPlayer;
            }
        }
        if(firstPlayer.gotMove() && secondPlayer.gotMove()) {
            this.result = Result.BothReady;
        }
    }

    public boolean isFull() {
        if(this.players == 2) {
            return true;
        }
        return false;
    }
}
