package dsa.wk4.magicsquare;

public class MagicSquare {

    public static boolean isMagicSquare(int[][] matrix) {

        int n = matrix.length;

        for (int[] row : matrix) {
            if (row.length != n) return false;
        }

        int targetSum = 0;
        for (int j = 0; j < n; j++) {
            targetSum += matrix[0][j];
        }

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != targetSum) return false;
        }


        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != targetSum) return false;
        }


        int diagonal1 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += matrix[i][i];
        }
        if (diagonal1 != targetSum) return false;


        int diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal2 += matrix[i][n - 1 - i];
        }
        if (diagonal2 != targetSum) return false;

        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
        };

        System.out.println(isMagicSquare(matrix));
    }
}