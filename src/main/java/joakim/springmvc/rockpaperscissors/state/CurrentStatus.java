package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import org.springframework.stereotype.Service;

//DÖP OM DENnA TILL GAMESTATE
@Service
public class CurrentStatus {

    public CurrentStatus() {
    }

    public String receiveStatus(Game game) {

        Result result = game.getResult();
        String stringValue;
        //Ta ut nnames här på playerone o två, dubbelkolla om de existerar, om inte så returnera det att väntar på player1/player2

        switch(result) {
            case Draw:
                stringValue = "It's a draw!";
                break;
            case FirstPlayerWin:
                stringValue = game.getFirstPlayer().getName() + " won!";
                break;
            case SecondPlayerWin:
                stringValue = game.getSecondPlayer().getName() + " won!";
                break;
            case WaitingPlayers:
                stringValue = "Waiting for both players to make their moves";
                break;
            case WaitingFirstPlayer:
                stringValue = "Waiting for " + game.getFirstPlayer().getName()  + " to make a move";
                break;
            case WaitingSecondPlayer:
                stringValue = "Waiting for " + game.getSecondPlayer().getName() + " to make a move";
                break;
            default:
                stringValue = "Waiting...";
        }
        return stringValue;
    }
}
