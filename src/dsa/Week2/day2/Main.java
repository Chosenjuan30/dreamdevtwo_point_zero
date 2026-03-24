package dsa.Week2.day2;

public class Main {
    public static void main(String[] args) {

        ProblemService service = new ProblemService();

        Problem p1 = service.createProblem(
                "Low Income", "Salary too small", ProblemType.FINANCIAL);

        Problem p2 = service.createProblem(
                "Learn Java", "Struggling with OOP", ProblemType.EDUCATION);

        service.createProblem(
                "Server Crash", "Production failure", ProblemType.TECHNICAL);

        service.solveProblem(p2.getId());

        System.out.println("\n--- Unsolved Problems ---");
        service.getUnsolvedProblems().forEach(System.out::println);
    }
}
