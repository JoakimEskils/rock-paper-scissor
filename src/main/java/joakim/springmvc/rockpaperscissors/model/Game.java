package joakim.springmvc.rockpaperscissors.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.UUID;

public class Game {

    private int knas;
    private Long gameId;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game() {
        Long generatedLong = new Random().nextLong();
        knas = 5;
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
}
