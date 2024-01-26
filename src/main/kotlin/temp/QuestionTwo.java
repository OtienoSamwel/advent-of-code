package temp;

public class MatrixOperations {

    public static void main(String[] args) {
        // Example 1
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {2, 1, 4, 3},
                {3, 4, 1, 2},
                {4, 3, 2, 1}
        };
        int[] result1 = computeMatrixOperations(matrix1);
        System.out.println(result1.toString()); // Output: [4, 0, 0]

        // Example 2
        int[][] matrix2 = {
                {2, 2, 2, 2},
                {2, 3, 2, 3},
                {2, 2, 2, 3},
                {2, 2, 2, 2}
        };
        int[] result2 = computeMatrixOperations(matrix2);
        System.out.println(result2); // Output: [9, 4, 4]
    }

    public static int[] computeMatrixOperations(int[][] matrix) {
        int n = matrix.length;
        int diagonalSum = 0;
        int rowsWithRepeat = 0;
        int columnsWithRepeat = 0;

        // Compute diagonal sum
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }

        // Compute rows with repeats
        for (int i = 0; i < n; i++) {
            if (hasRepeats(matrix[i])) {
                rowsWithRepeat++;
            }
        }

        // Compute columns with repeats
        for (int j = 0; j < n; j++) {
            if (hasRepeats(getColumn(matrix, j))) {
                columnsWithRepeat++;
            }
        }

        // Return the results in an array
        return new int[]{diagonalSum, rowsWithRepeat, columnsWithRepeat};
    }

    // Helper method to check if an array has repeated elements
    private static boolean hasRepeats(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper method to extract a column from a matrix
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}

public static void main (){
    System.out.println("question two");
}