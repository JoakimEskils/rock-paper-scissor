package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GameState {
    private int text;
    private HashMap<Long, Game> games = new HashMap<Long, Game>();

    public GameState() {
        this.text = 505;
    }

    public Game createGame() {
        Game game = new Game();
        Long id = game.getGameId();
        games.put(id, game);
        return game;
    }

    public Game getGame(Long id) {
        return games.get(id);
    }

    public Player getPlayer(Long id, String name) {
        Game game = games.get(id);
        System.out.println("game");
        System.out.println(game);
        return game.getPlayer(name);
    }
}
