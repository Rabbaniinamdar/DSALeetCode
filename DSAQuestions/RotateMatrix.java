public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateMatrix(matrix);
    }

    public static void rotateMatrix(int[][] arr) {
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        int s = 0, e = m - 1;
        while (s < e) {
            for (int i = 0; i < m; i++) {
                int tmp = arr[i][s];
                arr[i][s] = arr[i][e];
                arr[i][e] = tmp;
            }
            s++;
            e--;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}