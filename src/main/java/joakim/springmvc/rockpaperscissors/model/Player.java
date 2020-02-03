package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Move;
import joakim.springmvc.rockpaperscissors.enums.Result;

public class Player {
    private String name;
    private Move move;
    private Result result;

    public Player(String name) {
        this.name = name;
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
