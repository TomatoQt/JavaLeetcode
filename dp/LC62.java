package dp;

public class LC62 {
    public int uniquePaths(int m, int n) {
        int[][] dpMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
            dpMatrix[i][0] = 1;

        for (int i = 0; i < n; i++)
            dpMatrix[0][i] = 1;

        if (m == 1 || n == 1)
            return dpMatrix[m - 1][n - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpMatrix[i][j] = dpMatrix[i - 1][j] + dpMatrix[i][j - 1];
            }
        }

        return dpMatrix[m - 1][n - 1];
    }
}
