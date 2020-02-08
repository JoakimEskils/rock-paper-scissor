package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;

/*
    Maps the output of a started game depending on players moves.
 */
public class GameLogic {
    private Game game;

    public GameLogic(Game game) {
        this.game = game;
    }

    // startGame is only called by GameController if there are two players with set moves.
    public Result startGame() {
        try {
            Move fstMove = game.getFirstPlayer().getMove();
            Move sndMove = game.getSecondPlayer().getMove();

            if (fstMove.isBetterThan(sndMove)) {
                game.setResult(Result.FirstPlayerWin);
            } else if (sndMove.isBetterThan(fstMove)) {
                game.setResult(Result.SecondPlayerWin);
            } else {
                game.setResult(Result.Draw);
            }
        } catch (Exception e) {
            System.out.println("startGame was called, but an error has occurred. Perhaps it was called without players making their moves?");
        }

        return game.getResult();
    }
}
