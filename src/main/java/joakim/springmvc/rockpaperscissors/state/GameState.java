package joakim.springmvc.rockpaperscissors.state;

import joakim.springmvc.rockpaperscissors.enums.Result;
import joakim.springmvc.rockpaperscissors.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameState {

    public String receiveStatus(Game game) {

        Result result = game.getResult();
        String stringValue = "Something has gone wrong..."; //Default value
        if(game.isFull()) {
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
                    stringValue = "Waiting for players to make their moves.";
                    break;
                case WaitingFirstPlayer:
                    stringValue = "Waiting for " + game.getFirstPlayer().getName()  + " to make a move.";
                    break;
                case WaitingSecondPlayer:
                    stringValue = "Waiting for " + game.getSecondPlayer().getName() + " to make a move.";
                    break;
            }
        }
        else {
            stringValue = "Waiting for other player to connect.";
        }

        return stringValue;
    }
}
