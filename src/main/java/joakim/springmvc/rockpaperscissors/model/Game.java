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

    public Game() {
        Long generatedLong = new Random().nextLong();
        this.gameId = generatedLong;
        this.result = Result.Draw;
    }

    public void setFirstPlayer(String name) {
        this.firstPlayer = new Player(name);
    }

    public void setSecondPlayer(String name) {
        this.secondPlayer = new Player(name);
        System.out.println(secondPlayer.getName());
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

    public void setResult(Player player) { //GÖR DETTA I GAMESTATE
        //player.s
        if(player.equals(firstPlayer)) {
            firstPlayer.setResult(result);
            this.result = Result.FstPlayerWin;
        }
        else if(player.equals(this.secondPlayer)) {
            this.result = Result.SndPlayerWin;
        }
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
}
