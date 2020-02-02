package joakim.springmvc.rockpaperscissors.controller;

import joakim.springmvc.rockpaperscissors.enums.Move;
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

    @Autowired
    private GameLogic gameLogic;

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
        System.out.println("hmmmmm");
        System.out.println(name);
        return game.getGameId();
    }

    @RequestMapping(value = "/api/games/{id}")
    @ResponseBody
    public Game getState(@PathVariable Long id) {
        Game game = gameState.getGame(id);
        return game;
    }

    @RequestMapping(value = "/api/games/{id}/join", method = RequestMethod.POST)
    @ResponseBody
    public Player joinGame(@RequestBody Map<String, String> secondPlayer, @PathVariable Long id) {
        String name = secondPlayer.get("name");
        Game game = gameState.getGame(id);
        game.setSecondPlayer(name);
        return game.getSecondPlayer();
    }

    @RequestMapping(value = "/api/games/{id}/move", method = RequestMethod.POST)
    @ResponseBody
    public Player move(@RequestBody Map<String, String> playerParam, @PathVariable Long id) {
        String name = playerParam.get("name");

        Move move = Move.valueOf(playerParam.get("move"));


        System.out.println("kmr iaf hit");
        Player player = gameState.getPlayer(id, name); //få ut om det är first eller sndplayer


        System.out.println("kmr iaf hit!!!!!!");
        System.out.println(player);
        player.setMove(move);

        System.out.println("crash");
        System.out.println(playerParam.get("name"));
        System.out.println(move);

        //ändra gamelogic att ta in move ist?
        System.out.println("crash0");
        if(gameLogic.getFstPlayer() == null) {
            System.out.println("crash1");
            gameLogic.setSndPlayer(player);
        }
        else {
            System.out.println("crash2");
            gameLogic.setFstPlayer(player);
        }
        System.out.println("crash2.5");
        if(gameLogic.hasTwoPlayers()) {
            System.out.println("crash3");
            gameLogic.startGame();
        }
        return player;
    }
}
