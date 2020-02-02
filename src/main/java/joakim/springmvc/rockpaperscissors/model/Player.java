package joakim.springmvc.rockpaperscissors.model;

import joakim.springmvc.rockpaperscissors.enums.Move;

public class Player {
    private String name;
    private Move move;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMove(Move move) {
        System.out.println("hmmmmmmmakiojasiofj");
        System.out.println(move);
        this.move = move;
        System.out.println(move);
    }

    public Move getMove() {
        return move;
    }
}
