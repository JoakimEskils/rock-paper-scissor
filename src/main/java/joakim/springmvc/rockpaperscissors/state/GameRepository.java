package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/*
    Keeps track and stores all initialized games.
 */
@Service
public class GameRepository {
    private HashMap<Long, Game> games;

    public GameRepository() {
        games = new HashMap<Long, Game>();
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
        return game.getPlayer(name);
    }
}
