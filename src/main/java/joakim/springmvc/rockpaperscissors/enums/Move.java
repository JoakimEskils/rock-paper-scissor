package joakim.springmvc.rockpaperscissors.enums;

/*
    Enum with the possible actions in the game.
 */
public enum Move {

    Rock {
        @Override
        public boolean isBetterThan(Move move) {
            return (Scissors == move);
        }
    },
    Paper {
        @Override
        public boolean isBetterThan(Move move) {
            return (Rock == move);
        }
    },
    Scissors {
        @Override
        public boolean isBetterThan(Move move) {
            return (Paper == move);
        }
    },
    // NoMove is the default status when a player joins the game.
    NoMove {
        @Override
        public boolean isBetterThan(Move move) {
            return false;
        }
    };


    public abstract boolean isBetterThan(Move move);
}
