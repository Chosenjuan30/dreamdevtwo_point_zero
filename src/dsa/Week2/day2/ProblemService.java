package dsa.Week2.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProblemService {

    private final List<Problem> problems = new ArrayList<>();

    public Problem createProblem(String name, String description, ProblemType type) {
        Problem problem = new Problem(name, description, type);
        problems.add(problem);
        return problem;
    }

    public void solveProblem(String id) {
        findById(id).ifPresentOrElse(
                Problem::markSolved,
                () -> System.out.println("Problem not found")
        );
    }

    public List<Problem> getAllProblems() {
        return new ArrayList<>(problems);
    }

    public List<Problem> getUnsolvedProblems() {
        List<Problem> result = new ArrayList<>();
        for (Problem p : problems) {
            if (!p.isSolved()) result.add(p);
        }
        return result;
    }

    private Optional<Problem> findById(String id) {
        return problems.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
