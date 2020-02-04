package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;

//DÖP OM TILL STATE?
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

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }

    public Move getMove() {
        return move;
    }
}
