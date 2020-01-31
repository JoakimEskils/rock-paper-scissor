package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.model.Game;
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
        Game game = games.get(id);
        return game;
    }
}
