public class MaxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i = 0, j = 1; j < n; j++){
            grid[i][j] += grid[i][j-1];
        }
        for(int j = 0, i = 1; i < m; i++){
            grid[i][j] += grid[i-1][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
        
    }


    public static void main(String[] args) {
        MaxValue s = new MaxValue();
        int[][] matrix = {{1,3,1},
                          {1,5,1},
                          {4,2,1}};
        s.maxValue(matrix);
    }
}
