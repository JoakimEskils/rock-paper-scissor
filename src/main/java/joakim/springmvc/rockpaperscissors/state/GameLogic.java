package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Player;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    Player fstPlayer;
    Player sndPlayer;

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

    public Boolean hasTwoPlayers() {
        if(this.fstPlayer != null && this.sndPlayer != null) {
            return true;
        }
        return false;
    }

    public Result startGame() {
        Result result = Result.Draw;

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
}
