package joakim.springmvc.rockpaperscissors.enums;

public enum Choice {

    Rock {
        @Override
        public boolean isBetterThan(Choice choice) {
            return (Scissors == choice);
        }
    },
    Paper {
        @Override
        public boolean isBetterThan(Choice choice) {
            return (Rock == choice);
        }
    },
    Scissors {
        @Override
        public boolean isBetterThan(Choice choice) {
            return (Paper == choice);
        }
    };

    public abstract boolean isBetterThan(Choice choice);
}
