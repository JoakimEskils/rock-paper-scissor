package joakim.springmvc.rockpaperscissors.model;

public class Player {
    private String name;
    private Choice choice;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public makeMove(String move) {
        this.choice = move;
    }
}
