package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import org.springframework.stereotype.Service;

//@Service
public class GameLogic {
    private Game game;
    //private Result result;

    public GameLogic(Game game) {
        this.game = game;
    }

    public Result startGame() {

        Move fstMove = game.getFirstPlayer().getMove();
        Move sndMove = game.getSecondPlayer().getMove();

        if(fstMove.isBetterThan(sndMove)) {
            game.setResult(Result.FirstPlayerWin);
        }
        else if(sndMove.isBetterThan(fstMove)) {
            game.setResult(Result.SecondPlayerWin);
        }
        else {
            game.setResult(Result.Draw);
        }
        /*
        if(fstMove.isBetterThan(sndMove)) {
            fstPlayer.setResult(Result.Win);
            //game.setResult(fstPlayer);
        }
        else if(sndMove.isBetterThan(fstMove)) {
            sndPlayer.setResult(Result.Win);
            //game.setResult(sndPlayer);
        }



        Result playerOneResult = fstPlayer.getResult();
        Result playerTwoResult = sndPlayer.getResult();

        if(playerOneResult.equals(Result.Win)) {
            return ()
        }*/
        Result result = game.getResult();
        return result;
    }
}
