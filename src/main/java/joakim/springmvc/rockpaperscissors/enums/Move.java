package joakim.springmvc.rockpaperscissors.enums;

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
    NoMove {
        @Override
        public boolean isBetterThan(Move move) {
            return false;
        }
    };


    public abstract boolean isBetterThan(Move move);
}
