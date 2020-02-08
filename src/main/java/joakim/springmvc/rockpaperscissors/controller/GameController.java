package joakim.springmvc.rockpaperscissors.controller;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import joakim.springmvc.rockpaperscissors.state.GameState;
import joakim.springmvc.rockpaperscissors.state.GameLogic;
import joakim.springmvc.rockpaperscissors.state.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
    Maps GET and POST requests to proper logic and methods.
 */
@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameState gameState;

    // Initialize a new game.
    @RequestMapping(value = "/api/games", method = RequestMethod.POST)
    @ResponseBody
    public Long newGame(@RequestBody Map<String, String> firstPlayer) {
        String name = firstPlayer.get("name");
        Game game = gameRepository.createGame();
        game.setFirstPlayer(name);
        return game.getGameId();
    }

    // Receive current status of game.
    @RequestMapping(value = "/api/games/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getState(@PathVariable Long id) {
        Game game = gameRepository.getGame(id);
        String status = gameState.receiveStatus(game);
        return status;
    }

    // Join game, maximum two players allowed.
    @RequestMapping(value = "/api/games/{id}/join", method = RequestMethod.POST)
    @ResponseBody
    public String joinGame(@RequestBody Map<String, String> secondPlayer, @PathVariable Long id) {
        Game game = gameRepository.getGame(id);
        String name = secondPlayer.get("name");

        if(game.isFull()) {
            return("Sorry, this lobby is full!");
        }
        else if(game.getFirstPlayer().getName().equals(name)) {
            return("Name already taken!");
        }
        else {
            game.setSecondPlayer(name);
            return("Successfully joined the game!");
        }
    }

    // Player makes its move, starts game if both players made their moves.
    @RequestMapping(value = "/api/games/{id}/move", method = RequestMethod.POST)
    @ResponseBody
    public String move(@RequestBody Map<String, String> playerParam, @PathVariable Long id) {
        try {
            Game game = gameRepository.getGame(id);
            String name = playerParam.get("name");
            Move move = Move.valueOf(playerParam.get("move"));

            Player player = gameRepository.getPlayer(id, name);
            player.setMove(move);
            game.setReadyPlayer(player);
            GameLogic gameLogic = new GameLogic(game);

            if (game.getResult().equals(Result.BothReady)) {
                gameLogic.startGame();
                return("Game started!");
            }
        } catch(IllegalArgumentException e) {
            return("Not a valid move!");
        }
        return("Move added!");
    }
}
