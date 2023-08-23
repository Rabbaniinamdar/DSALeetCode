// Initialize two arrays, row and col, each of length m and n respectively, with all elements set to 0.

// Iterate through each element in the matrix:

// If matrix[i][j] is 0, set row[i] and col[j] to 1.
// Iterate through each element in the matrix:

// If row[i] is 1 or col[j] is 1, set matrix[i][j] to 0.

// Return the modified matrix.

class TwoDArray {

    public static int[][] setMatrixZero(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    // "I'll walk you through a Java code example that demonstrates how to rotate a
    // matrix 90 degrees clockwise.
    // Rotating a matrix involves changing its orientation by 90 degrees in a
    // clockwise direction. This can be useful in various applications, such as
    // image processing and graphics transformations."

    // Code Explanation:

    // Transpose (Changing Rows into Columns):

    // The initial section of the code performs a transpose operation on the matrix
    // by swapping elements along the main diagonal. This effectively changes rows
    // into columns.
    // The outer loop iterates through rows i, and the inner loop iterates through
    // columns j starting from i + 1. This avoids redundant swaps.
    // During each iteration, the elements at (i, j) and (j, i) are swapped using a
    // temporary variable temp.
    
    // Reverse Columns:

    // After the transpose operation, the matrix has its rows and columns swapped.
    // To complete the 90-degree clockwise rotation, we need to reverse the columns.
    // The start and end variables define the range of columns to be reversed.
    // The while loop iterates as long as start is less than end.
    // Within the loop, for each row i, the elements at (i, start) and (i, end) are
    // swapped using the same temporary variable temp.

    public static int[][] rotate90deg(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int start = 0;
        int end = m - 1;
        while (start < end) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        int ans[][] = rotate90deg(matrix);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
