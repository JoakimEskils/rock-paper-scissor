package joakim.springmvc.rockpaperscissors.controller;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import joakim.springmvc.rockpaperscissors.state.GameLogic;
import joakim.springmvc.rockpaperscissors.state.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@RequestMapping("/api/games")
@RestController
public class GameController {

    @Autowired
    private GameState gameState;

    //@Autowired
    //private GameLogic gameLogic;

/*
    @RequestMapping(value = "/hello")
    public String hej() {
        String namn = "5";
        return namn;
    }*/

    @RequestMapping(value = "/api/games", method = RequestMethod.POST)
    @ResponseBody
    public Long newGame(@RequestBody Map<String, String> firstPlayer) {
    //public Long newGame(@RequestParam("name") String name) {
        String name = firstPlayer.get("name");
        Game game = gameState.createGame();
        game.setFirstPlayer(name);
        return game.getGameId();
    }

    @RequestMapping(value = "/api/games/{id}")
    @ResponseBody
    public Result getState(@PathVariable Long id) {
        Game game = gameState.getGame(id);
        Result result = game.getResult();
        return game.getResult();
    }

    @RequestMapping(value = "/api/games/{id}/join", method = RequestMethod.POST)
    @ResponseBody
    public Player joinGame(@RequestBody Map<String, String> secondPlayer, @PathVariable Long id) {
        String name = secondPlayer.get("name");
        Game game = gameState.getGame(id);
        if(game.isFull()) {
            System.out.println("Sorry, this lobby is full!");
            return null;
        }
        game.setSecondPlayer(name);
        return game.getSecondPlayer();
    }

    @RequestMapping(value = "/api/games/{id}/move", method = RequestMethod.POST)
    @ResponseBody
    public Player move(@RequestBody Map<String, String> playerParam, @PathVariable Long id) {
        Game game = gameState.getGame(id);
        String name = playerParam.get("name");
        Move move = Move.valueOf(playerParam.get("move"));

        Player player = gameState.getPlayer(id, name); //få ut om det är first eller sndplayer
        player.setMove(move);
        game.setRdyPlayer(player);
        //game.setRdyPlayers(1);
        GameLogic gameLogic = new GameLogic(game);

        //if(game.getRdyPlayers() == 2) {
        //    gameLogic.startGame();
        //}
        if(game.getResult().equals(Result.BothReady)) {
            gameLogic.startGame();
        }
        return player;

        /*

        if(gameLogic.getFstPlayer() == null) {
            gameLogic.setFstPlayer(player);
        }
        else if(gameLogic.getSndPlayer() == null) {
            gameLogic.setSndPlayer(player);
        }
        System.out.println("knasus");
        System.out.println(gameLogic.getFstPlayer());
        System.out.println(gameLogic.getSndPlayer());

        if(gameLogic.hasTwoPlayers()) {
            gameLogic.startGame();
            System.out.println("km hit");
        }
        return player;*/
    }
}
