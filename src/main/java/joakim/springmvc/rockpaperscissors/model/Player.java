package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;

public class Player {
    private String name;
    private Move move;
    private Result result;

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
