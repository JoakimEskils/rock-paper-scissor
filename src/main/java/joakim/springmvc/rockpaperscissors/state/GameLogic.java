package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Choice;
import joakim.springmvc.rockpaperscissors.enums.Result;

public class GameLogic {
    Choice fstPlayerChoice;
    Choice sndPlayerChoice;

    public Result calculate(Choice fstPlayer, Choice sndPlayer) {

        //IFsats if playerchoices exists

        Result result = Result.Draw;

        if(fstPlayer.isBetterThan(sndPlayer)) {
            result = result.FstPlayerWin;
        }
        else if(sndPlayer.isBetterThan(fstPlayer)) {
            result = result.SndPlayerWin;
        }

        return result;
    }
}
