public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[2][1] = obstacleGrid[m-2][n-1] == 1 ? 0 : 1;
        dp[1][2] = obstacleGrid[m-1][n-2] == 1 ? 0 : 1;
        dp[1][1] = 1;

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(obstacleGrid[m - i][n - j] == 1 || (i == 1 && j == 1)) continue;
                if( i == 1 ) dp[i][j] = dp[i][j-1];
                else if(j == 1) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles s = new UniquePathsWithObstacles();
        int[][] mat = {{0,0,0},
                       {0,1,0},
                       {0,0,0}};
        s.uniquePathsWithObstacles(mat);
    }
}
