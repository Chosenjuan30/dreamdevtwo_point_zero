package dsa.Week2.assignments.studentgrade;





public class StudentGradeCalculator {

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    public static int computeTotal(int[] studentScores) {
        int total = 0;
        for (int score : studentScores) {
            total += score;
        }
        return total;
    }

    public static double computeAverage(int[] studentScores) {
        if (studentScores.length == 0) return 0;
        return (double) computeTotal(studentScores) / studentScores.length;
    }

    public static int[] computePositions(int[] totals) {
        int n = totals.length;
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = 1;
            for (int j = 0; j < n; j++) {
                if (totals[j] > totals[i]) {
                    pos++;
                }
            }
            positions[i] = pos;
        }
        return positions;
    }

    public static int findHighestScorerIndex(int[][] scores, int subjectIndex) {
        int highIdx = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][subjectIndex] > scores[highIdx][subjectIndex]) {
                highIdx = i;
            }
        }
        return highIdx;
    }

    public static int findLowestScorerIndex(int[][] scores, int subjectIndex) {
        int lowIdx = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][subjectIndex] < scores[lowIdx][subjectIndex]) {
                lowIdx = i;
            }
        }
        return lowIdx;
    }

    public static int computeSubjectTotal(int[][] scores, int subjectIndex) {
        int total = 0;
        for (int[] studentScore : scores) {
            total += studentScore[subjectIndex];
        }
        return total;
    }

    public static double computeSubjectAverage(int[][] scores, int subjectIndex) {
        return (double) computeSubjectTotal(scores, subjectIndex) / scores.length;
    }

    public static int countPasses(int[][] scores, int subjectIndex) {
        int passes = 0;
        for (int[] studentScore : scores) {
            if (studentScore[subjectIndex] >= 50) passes++;
        }
        return passes;
    }

    public static int countFails(int[][] scores, int subjectIndex) {
        int fails = 0;
        for (int[] studentScore : scores) {
            if (studentScore[subjectIndex] < 50) fails++;
        }
        return fails;
    }

    public static int findHardestSubjectIndex(int[][] scores, int numSubjects) {
        int hardestIdx = 0;
        int maxFails = -1;
        for (int j = 0; j < numSubjects; j++) {
            int fails = countFails(scores, j);
            if (fails > maxFails) {
                maxFails = fails;
                hardestIdx = j;
            }
        }
        return hardestIdx;
    }

    public static int findEasiestSubjectIndex(int[][] scores, int numSubjects) {
        int easiestIdx = 0;
        int maxPasses = -1;
        for (int j = 0; j < numSubjects; j++) {
            int passes = countPasses(scores, j);
            if (passes > maxPasses) {
                maxPasses = passes;
                easiestIdx = j;
            }
        }
        return easiestIdx;
    }

    public static int[] findOverallHighest(int[][] scores) {
        int[] result = new int[3]; // {studentIdx, subjectIdx, score}
        int high = -1;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] > high) {
                    high = scores[i][j];
                    result[0] = i;
                    result[1] = j;
                    result[2] = high;
                }
            }
        }
        return result;
    }

    public static int[] findOverallLowest(int[][] scores) {
        int[] result = new int[3]; // {studentIdx, subjectIdx, score}
        int low = 101;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] < low) {
                    low = scores[i][j];
                    result[0] = i;
                    result[1] = j;
                    result[2] = low;
                }
            }
        }
        return result;
    }

    public static int computeClassTotal(int[][] scores) {
        int total = 0;
        for (int[] student : scores) {
            for (int score : student) {
                total += score;
            }
        }
        return total;
    }

    public static double computeClassAverage(int[][] scores) {
        int totalCells = scores.length * scores[0].length;
        return (double) computeClassTotal(scores) / totalCells;
    }
}
