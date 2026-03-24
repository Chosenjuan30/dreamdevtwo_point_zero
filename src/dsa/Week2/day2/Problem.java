package dsa.Week2.day2;


    import java.util.UUID;

    public class Problem {
        private final String id;
        private final String name;
        private final String description;
        private final ProblemType type;
        private boolean solved;

        public Problem(String name, String description, ProblemType type) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.description = description;
            this.type = type;
            this.solved = false;
        }

        public String getId() {
            return id;
        }

        public boolean isSolved() {
            return solved;
        }

        public void markSolved() {
            this.solved = true;
        }

        public ProblemType getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%s | %s | %s | %s",
                    id, name, type, solved ? "Solved" : "Unsolved");
        }
    }

