package joakim.springmvc.rockpaperscissors.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.UUID;

public class Game {

    private Long gameId;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game() {
        Long generatedLong = new Random().nextLong();
        this.gameId = generatedLong;
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

    public Player getPlayer(String name) {
        if(name == firstPlayer.getName()) {
            return firstPlayer;
        }
        else if(name == secondPlayer.getName()) {
            return secondPlayer;
        }
        //ILLEGAL EXPRESSION
        return null;
    }
}
