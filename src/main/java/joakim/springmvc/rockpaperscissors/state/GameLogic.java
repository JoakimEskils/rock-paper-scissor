package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;

public class GameLogic {
    private Game game;

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

        Result result = game.getResult();
        return result;
    }
}
