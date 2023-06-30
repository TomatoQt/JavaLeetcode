package list;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int loopNum = n / 2;
        int midLoc = n / 2;
        int count = 1;

        // 顺时针绕圈填数
        for (int loop = 0; loop <= loopNum; loop++) {
            //向右
            for (int i = loop; i < n - 1 - loop; i++) {
                matrix[loop][i] = count;
                count++;
            }
            //向下
            for (int i = loop; i < n - 1 - loop; i++) {
                matrix[i][n - 1 - loop] = count;
                count++;
            }
            //向左
            for (int i = n - 1 - loop; i > loop; i--) {
                matrix[n - 1 - loop][i] = count;
                count++;
            }
            //向上
            for (int i = n - 1 - loop; i > loop; i--) {
                matrix[i][loop] = count;
                count++;
            }
        }
        
        // 填完，检查中心是否需要填
        if (n % 2 == 1) {
            matrix[midLoc][midLoc] = count;
        }

        return matrix;
    }

    public static void main(String[] args) {

    }
}
