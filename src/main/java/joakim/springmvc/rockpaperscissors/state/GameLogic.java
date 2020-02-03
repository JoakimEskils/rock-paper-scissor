package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import joakim.springmvc.rockpaperscissors.model.Player;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    private Player fstPlayer;
    private Player sndPlayer;
    //private Game game;
    private Result result;

    public GameLogic() {
        this.fstPlayer = null;
        this.sndPlayer = null;
    }

    public void setFstPlayer(Player fstPlayer) {
        this.fstPlayer = fstPlayer;
    }

    public void setSndPlayer(Player sndPlayer) {
        this.sndPlayer = sndPlayer;
    }

    public Player getFstPlayer() {
        return fstPlayer;
    }

    public Player getSndPlayer() {
        return sndPlayer;
    }

    public Boolean hasTwoPlayers() {
        if(this.fstPlayer != null && this.sndPlayer != null) {
            return true;
        }
        return false;
    }

    public Result startGame() {
        this.result = Result.Draw;

        Move fstMove = fstPlayer.getMove();
        Move sndMove = sndPlayer.getMove();

        if(fstMove.isBetterThan(sndMove)) {
            result = result.FstPlayerWin;
        }
        else if(sndMove.isBetterThan(fstMove)) {
            result = result.SndPlayerWin;
        }

        return result;
    }

    public Result getResult() {
        return result;
    }
}
