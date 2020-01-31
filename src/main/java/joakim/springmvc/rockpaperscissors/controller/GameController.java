package joakim.springmvc.rockpaperscissors.controller;

import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import joakim.springmvc.rockpaperscissors.state.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//@RequestMapping("/api/games")
@RestController
public class GameController {

    @Autowired
    private GameState gameState;

    //@Autowired
    //HttpSession session;
/*
    @RequestMapping(value = "/hello")
    public String hej() {
        String namn = "5";
        return namn;
    }*/

    @RequestMapping(value = "/api/games", method = RequestMethod.POST)
    @ResponseBody
    public Long newGame(@RequestBody String name) {
        Game game = gameState.createGame();
        game.setFirstPlayer(name);
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
    public Player joinGame(@RequestBody String name, @PathVariable Long id) {
        Game game = gameState.getGame(id);
        game.setSecondPlayer(name);
        return game.getSecondPlayer();
    }

    @RequestMapping(value = "/api/games/{id}/move", method = RequestMethod.POST)
    @ResponseBody
    public Player move(@RequestBody String name, @RequestBody String move, @PathVariable Long id) {
        Player player = gameState.getPlayer(id, name); //få ut om det är first eller sndplayer
        //ELLER HA choice i playerclassen, och gör så JSON inte printar ut denna under första gången iaf
        player.makeChoice(move);
        GameLogic.set//fst eller snd PLAYERs choice.
        return
    }
}
