package dp;

public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dpMatrix = new int[rows][cols];

        // 处理第0行
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) // 跳过障碍物
                break;
            dpMatrix[i][0] = 1;
        }

        // 处理第0列
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) // 跳过障碍物
                break;
            dpMatrix[0][i] = 1;
        }

        // 推测只有一条的时候不会出现障碍物，不然无解
        if (rows == 1 || cols == 1)
            return dpMatrix[rows - 1][cols - 1];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                dpMatrix[i][j] = dpMatrix[i - 1][j] + dpMatrix[i][j - 1];
            }
        }

        return dpMatrix[rows - 1][cols - 1];
    }
}
