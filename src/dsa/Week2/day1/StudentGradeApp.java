package dsa.Week2.day1;



import java.util.Scanner;

public class StudentGradeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students do you have? ");
        int numStudents = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("How many subjects do they offer? ");
        int numSubjects = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved successfully");

        int[][] scores = new int[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numSubjects; j++) {
                System.out.println("Entering score for student " + (i + 1));
                System.out.print("Enter score for subject " + (j + 1) + ": ");
                int score;
                do {
                    score = Integer.parseInt(scanner.nextLine().trim());
                    if (!StudentGradeCalculator.isValidScore(score)) {
                        System.out.print("Score must be between 0 and 100. Try again: ");
                    }
                } while (!StudentGradeCalculator.isValidScore(score));
                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully");
                scores[i][j] = score;
            }
        }

        int[] totals    = new int[numStudents];
        double[] avgs   = new double[numStudents];
        for (int i = 0; i < numStudents; i++) {
            totals[i] = StudentGradeCalculator.computeTotal(scores[i]);
            avgs[i]   = StudentGradeCalculator.computeAverage(scores[i]);
        }
        int[] positions = StudentGradeCalculator.computePositions(totals);

        String sep = "=".repeat(60);
        System.out.println(sep);

        System.out.printf("%-12s", "STUDENT");
        for (int j = 0; j < numSubjects; j++) System.out.printf("%-8s", "SUB" + (j + 1));
        System.out.printf("%-6s%-8s%-5s%n", "TOT", "AVE", "POS");
        System.out.println(sep);

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-12s", "Student " + (i + 1));
            for (int j = 0; j < numSubjects; j++) System.out.printf("%-8d", scores[i][j]);
            System.out.printf("%-6d%-8.2f%-5d%n", totals[i], avgs[i], positions[i]);
        }
        System.out.println(sep);

        System.out.println("\nSUBJECT SUMMARY");
        for (int j = 0; j < numSubjects; j++) {
            int hi  = StudentGradeCalculator.findHighestScorerIndex(scores, j);
            int lo  = StudentGradeCalculator.findLowestScorerIndex(scores, j);
            System.out.println("Subject " + (j + 1));
            System.out.println("Highest scoring student is:  Student " + (hi + 1) + " scoring " + scores[hi][j]);
            System.out.println("Lowest Scoring student is: student " + (lo + 1) + " scoring " + scores[lo][j]);
            System.out.println("Total Score is:  " + StudentGradeCalculator.computeSubjectTotal(scores, j));
            System.out.printf("Average score is: %.2f%n", StudentGradeCalculator.computeSubjectAverage(scores, j));
            System.out.println("Number of passes: " + StudentGradeCalculator.countPasses(scores, j));
            System.out.println("Number of Fails: "  + StudentGradeCalculator.countFails(scores, j));
            System.out.println();
        }

        int hardest = StudentGradeCalculator.findHardestSubjectIndex(scores, numSubjects);
        int easiest = StudentGradeCalculator.findEasiestSubjectIndex(scores, numSubjects);
        int[] overallHigh = StudentGradeCalculator.findOverallHighest(scores);
        int[] overallLow  = StudentGradeCalculator.findOverallLowest(scores);

        System.out.println("The hardest subject is Subject " + (hardest + 1) + " with " + StudentGradeCalculator.countFails(scores, hardest) + " failures");
        System.out.println("The easiest subject is Subject " + (easiest + 1) + " with " + StudentGradeCalculator.countPasses(scores, easiest) + " passes");
        System.out.println("The overall Highest score is scored by Student " + (overallHigh[0] + 1) + " in subject " + (overallHigh[1] + 1) + " scoring " + overallHigh[2]);
        System.out.println("The overall Lowest score is scored by Student " + (overallLow[0] + 1)  + " in subject " + (overallLow[1] + 1)  + " scoring " + overallLow[2]);

        int bestIdx  = 0, worstIdx = 0;
        for (int i = 1; i < numStudents; i++) {
            if (totals[i] > totals[bestIdx])  bestIdx  = i;
            if (totals[i] < totals[worstIdx]) worstIdx = i;
        }

        System.out.println(sep);
        System.out.println("CLASS SUMMARY");
        System.out.println(sep);
        System.out.println("Best Graduating Student is: Student " + (bestIdx + 1) + " scoring " + totals[bestIdx]);
        System.out.println(sep);
        System.out.println("!".repeat(50));
        System.out.println("Worst Graduating Student is: Student " + (worstIdx + 1) + " scoring " + totals[worstIdx]);
        System.out.println("!".repeat(50));
        System.out.println(sep);
        System.out.println("Class total score is: " + StudentGradeCalculator.computeClassTotal(scores));
        System.out.printf("Class Average score is: %.1f%n", StudentGradeCalculator.computeClassAverage(scores));
        System.out.println(sep);

        scanner.close();
    }
}
