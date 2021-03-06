package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Move;

/*
    Player class to control the necessary attributes of a player.
 */
public class Player {
    private String name;
    private Move move;

    public Player(String name) {
        this.name = name;
        this.move = Move.NoMove;
    }

    public Boolean gotMove() {
        if(this.move.equals(Move.NoMove)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
