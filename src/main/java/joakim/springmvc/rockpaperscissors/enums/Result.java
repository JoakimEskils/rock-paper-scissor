package joakim.springmvc.rockpaperscissors.enums;

/*
    Representing the possible states of a game.
 */
public enum Result {
    Draw,
    FirstPlayerWin,
    SecondPlayerWin,
    WaitingPlayers,
    WaitingFirstPlayer,
    WaitingSecondPlayer,
    BothReady;
}
