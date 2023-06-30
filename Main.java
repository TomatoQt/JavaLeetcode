import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for (int i = 0; i < n / 2; i++) {
            // RIGHT, j: column
            for (int j = i; j < n - i - 1; j++) {
                matrix[i][j] = num++;
            }

            // DOWN, j: row
            for (int j = i; j < n - i - 1; j++) {
                matrix[j][n - i - 1] = num++;
            }

            // LEFT, j: column
            for (int j = n - i - 1; j > i; j--) {
                matrix[n - i - 1][j] = num++;
            }

            // UP, j: row
            for (int j = n - i - 1; j > i; j--) {
                matrix[j][i] = num++;
            }
        }

        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = num;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
